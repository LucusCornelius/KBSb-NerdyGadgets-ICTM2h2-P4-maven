package m2h2.Algoritme;


import m2h2.Backoffice.Components.Order;
import m2h2.Console_Color_Codes.ConsoleColorCodes;
import m2h2.FileWriter.FileWriter;


import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class Adressen_GEO_Data_Extractor {

    private String GPX_SourcePad = "src/main/java/m2h2/DataFiles/GPX";

    private String bag_light_GPKG_URL = "jdbc:sqlite:src/main/java/m2h2/Nederland_Geografische_Data/bag-light.gpkg";

    private String sql_query = "SELECT r.*, v.feature_id, v.openbare_ruimte_naam, v.huisnummer, v.woonplaats_naam, v.postcode, v.huisletter, v.toevoeging " + "FROM rtree_verblijfsobject_geom r " + "INNER JOIN ( " + "    SELECT feature_id, openbare_ruimte_naam, huisnummer, postcode, woonplaats_naam, huisletter, toevoeging " + "    FROM verblijfsobject " + "    WHERE postcode LIKE ? " + "    AND huisnummer = ? " + "    AND woonplaats_naam LIKE ? " + "    AND (huisletter = ? OR ? IS NULL) " + "    AND (toevoeging = ? OR ? IS NULL) " + ") v ON r.id = v.feature_id";

    private int query_timout = 30; //30 seconds

    private ArrayList<Order> orders;

    private ArrayList<Orders_Met_Coordinaten> orders_met_coordinaten = new ArrayList<>();


    public Adressen_GEO_Data_Extractor(ArrayList<Order> orders) {
        this.orders = orders;

        try {
            FileWriter.deleteFolderContents(GPX_SourcePad);
        } catch (IOException io) {
            io.printStackTrace();
            System.out.println("Er heeft een error plaatsgevonden tijdens het legen van de GPX-bestanden-map.");
        }


        PrintOrders();
        Fetch_And_Add_Coordinates();
    }



    private void PrintOrders() {
        String[] colorStrings = {ConsoleColorCodes.ANSI_GREEN.toString(), ConsoleColorCodes.ANSI_RED.toString(), ConsoleColorCodes.ANSI_BLUE.toString()};
        int colorIndex = 0;

        for (int i = 0; i < orders.size(); i++) {
            String color = colorStrings[colorIndex];

            System.out.println(color + "Processed orders: " + orders.get(i) + ConsoleColorCodes.ANSI_RESET);

            colorIndex = (colorIndex + 1) % colorStrings.length;

            if ((i + 1) % 3 == 0) {
                colorIndex = 0;
            }
        }
    }


    private void Fetch_And_Add_Coordinates() {
        System.out.println("\n" + ConsoleColorCodes.ANSI_YELLOW + "De coördinaten worden opgehaald & opgeslagen." + ConsoleColorCodes.ANSI_RESET);


        for (int i = 0; i < orders.size(); i++) {
            try (
                    Connection connection = DriverManager.getConnection(bag_light_GPKG_URL); Statement statement = connection.createStatement()
            ) {

                Orders_Met_Coordinaten ordersMetCoordinaten = new Orders_Met_Coordinaten(orders.get(i).getOrderID(), orders.get(i).getNaam(), orders.get(i).getStraatnaam(), orders.get(i).getPostcode(), orders.get(i).getPlaatsnaam(), orders.get(i).getHuisnummer(), orders.get(1).getToevoeging());

                int progress = (i + 1) * 100 / orders.size();
                System.out.print("\r[" + "=".repeat(progress) + " ".repeat(100 - progress) + "] " + progress + "%" +"\n");


                statement.setQueryTimeout(query_timout);


                String postcode = orders.get(i).getPostcode();
                int huisnummer = orders.get(i).getHuisnummer();
                String woonplaats = orders.get(i).getPlaatsnaam();
                String huisletter = null;
                String toevoeging = null;

                if(orders.get(i).getHuisletter() != null) {
                    huisletter = orders.get(i).getHuisletter();
                 }

                if(orders.get(i).getToevoeging() != null) {
                    toevoeging = orders.get(i).getToevoeging();
                 }


                PreparedStatement preparedStatement = connection.prepareStatement(sql_query);

                preparedStatement.setString(1, postcode);
                preparedStatement.setInt(2, huisnummer);
                preparedStatement.setString(3, woonplaats);
                preparedStatement.setString(4, huisletter); // huisletter parameter
                preparedStatement.setString(5, huisletter); // huisletter null check
                preparedStatement.setString(6, toevoeging); // toevoeging parameter
                preparedStatement.setString(7, toevoeging); // toevoeging null check

                ResultSet rs = preparedStatement.executeQuery();


                try {
                    ordersMetCoordinaten.setCoordinaten_RijksDriehoek(Double.parseDouble(rs.getString(2)), Double.parseDouble(rs.getString(4)));
                    RDtoDegrees(Double.parseDouble(rs.getString(2)), Double.parseDouble(rs.getString(4)), ordersMetCoordinaten);
                } catch (NullPointerException e) {
                    FileWriter.WriteToFile(e.getMessage(), "src/main/java/m2h2/LogFiles/Adressen_GEO_Data_Extractor_Log.txt", true);
                }
                System.out.println(ordersMetCoordinaten);
                rs.close();
                preparedStatement.close();


            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(ConsoleColorCodes.ANSI_RED + "SQL error bij 'Orders_Met_Coordinaten'" + ConsoleColorCodes.ANSI_RESET);
                System.out.println("Critical error. Breaking...");
                System.exit(10);
            }

        }

        try {
            System.out.println(ConsoleColorCodes.ANSI_PURPLE + "\nProcessed orders\n\n" + orders_met_coordinaten + "\n" + ConsoleColorCodes.ANSI_RESET);

            Regios regios = new Regios(orders_met_coordinaten);
            KNN_Algoritme.setOrders(regios);
        }
        catch (NullPointerException N) {
            System.out.println(ConsoleColorCodes.ANSI_RED + "\n\n###-----> NullPointerException bij het invoegen van de 'Orders_Met_Coordinaten' object in het 'Regios' object" + ConsoleColorCodes.ANSI_RESET);
            System.out.println("Critical error. Breaking...");
            System.exit(1);
        }
    }



    private void RDtoDegrees(double O, double N, Orders_Met_Coordinaten ordersMetCoordinaten) {
        try {
            double X = O;
            double Y = N;

            double dX = (X - 155000) * Math.pow(10, -5);
            double dY = (Y - 463000) * Math.pow(10, -5);

            double SomN = (3235.65389 * dY) + (-32.58297 * Math.pow(dX, 2)) + (-0.2475 * Math.pow(dY, 2)) + (-0.84978 * Math.pow(dX, 2) * dY) + (-0.0655 * Math.pow(dY, 3)) + (-0.01709 * Math.pow(dX, 2) * Math.pow(dY, 2)) + (-0.00738 * dX) + (0.0053 * Math.pow(dX, 4)) + (-0.00039 * Math.pow(dX, 2) * Math.pow(dY, 3)) + (0.00033 * Math.pow(dX, 4) * dY) + (-0.00012 * dX * dY);
            double SomE = (5260.52916 * dX) + (105.94684 * dX * dY) + (2.45656 * dX * Math.pow(dY, 2)) + (-0.81885 * Math.pow(dX, 3)) + (0.05594 * dX * Math.pow(dY, 3)) + (-0.05607 * Math.pow(dX, 3) * dY) + (0.01199 * dY) + (-0.00256 * Math.pow(dX, 3) * Math.pow(dY, 2)) + (0.00128 * dX * Math.pow(dY, 4)) + (0.00022 * Math.pow(dY, 2)) + (-0.00022 * Math.pow(dX, 2)) + (0.00026 * Math.pow(dX, 5));

            double Latitude = 52.15517 + (SomN / 3600);
            double Longitude = 5.387206 + (SomE / 3600);


            int LatitudeGraden = (int) Latitude;
            int LongitudeGraden = (int) Longitude;

            double LatitudeMinuten = (Latitude - LatitudeGraden) * 60;
            double LongitudeMinuten = (Longitude - LongitudeGraden) * 60;

            double latitudeDecimalDegrees = LatitudeGraden + LatitudeMinuten / 60;
            double longitudeDecimalDegrees = LongitudeGraden + LongitudeMinuten / 60;

            ordersMetCoordinaten.setCoordinaten_DecimalDegrees(latitudeDecimalDegrees, longitudeDecimalDegrees);

            String LatitudeGradenString = Integer.toString(LatitudeGraden);
            String LongitudeGradenString = Integer.toString(LongitudeGraden);

            String LatitudeMinutenString = Double.toString(LatitudeMinuten);
            String LongitudeMinutenString = Double.toString(LongitudeMinuten);


            ordersMetCoordinaten.setCoordinaten_DMS(LatitudeGradenString, LatitudeMinutenString, LongitudeGradenString, LongitudeMinutenString);
            orders_met_coordinaten.add(ordersMetCoordinaten);
        } catch (NullPointerException N_RDtDG) {
            System.out.println(ConsoleColorCodes.ANSI_RED + "\n\n###-----> NullPointerException bij het omreken van Rijksdriehoekscoordinaten naar DM structuur in 'Adressen_GEO_Data_Filter." + ConsoleColorCodes.ANSI_RESET);
            System.out.println("Critical error. Breaking...");
            N_RDtDG.printStackTrace();
            System.exit(1);
        }


    }
}

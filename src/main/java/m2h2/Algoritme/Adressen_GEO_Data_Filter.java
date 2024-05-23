package m2h2.Algoritme;


import m2h2.Console_Color_Codes.ConsoleColorCodes;
import m2h2.FileWriter.FileWriter;


import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class Adressen_GEO_Data_Filter {

    private static String GPX_SourcePad = "src/main/java/m2h2/DataFiles/GPX";

    private String bag_light_GPKG_URL = "jdbc:sqlite:/Users/lucasvissers/IdeaProjects/KBSb-NerdyGadgets-ICTM2h2-P4-maven/src/main/java/m2h2/Nederland_Geografische_Data/bag-light.gpkg";
    private ArrayList<Order> orders;

    private ArrayList<Orders_Met_Coordinaten> orders_met_coordinaten = new ArrayList<>();


    double maxOrders = 200;
    int startIndex = 0;
    int endIndex = 199;


    public Adressen_GEO_Data_Filter(ArrayList<Order> orders) {
        this.orders = orders;

        try {
            FileWriter.deleteFolderContents(GPX_SourcePad);
        } catch (IOException io) {
            io.printStackTrace();
            System.out.println("Er heeft een error plaatsgevonden tijdens het legen van de GPX-bestanden-map.");
        }


        printOrders();
        voegCoordinatenAanArray();
    }



    private void printOrders() {
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


    private void voegCoordinatenAanArray() {
        System.out.println("\n" + ConsoleColorCodes.ANSI_YELLOW + "Het sql process wordt uitgevoerd" + ConsoleColorCodes.ANSI_RESET);


        for (int i = 0; i < orders.size(); i++) {
            try (
                    Connection connection = DriverManager.getConnection(bag_light_GPKG_URL); Statement statement = connection.createStatement()
            ) {

                Orders_Met_Coordinaten ordersMetCoordinaten = new Orders_Met_Coordinaten(orders.get(i).getOrderID(), orders.get(i).getNaam(), orders.get(i).getStraatnaam(), orders.get(i).getPostcode(), orders.get(i).getHuisnummer(), orders.get(i).getOrder());


                int progress = (i + 1) * 100 / orders.size();
                System.out.print("\r[" + "=".repeat(progress) + " ".repeat(100 - progress) + "] " + progress + "%");


                statement.setQueryTimeout(30);


                String postcode = orders.get(i).getPostcode();
                int huisnummer = orders.get(i).getHuisnummer();
                String woonplaats = orders.get(i).getPlaatsnaam();
                String huisletter = null;
                String toevoeging = null;


                String sql = "SELECT r.*, v.feature_id, v.openbare_ruimte_naam, v.huisnummer, v.woonplaats_naam, v.postcode, v.huisletter, v.toevoeging " + "FROM rtree_verblijfsobject_geom r " + "INNER JOIN ( " + "    SELECT feature_id, openbare_ruimte_naam, huisnummer, postcode, woonplaats_naam, huisletter, toevoeging " + "    FROM verblijfsobject " + "    WHERE postcode LIKE ? " + "    AND huisnummer = ? " + "    AND woonplaats_naam LIKE ? " + "    AND (huisletter = ? OR ? IS NULL) " + "    AND (toevoeging = ? OR ? IS NULL) " + ") v ON r.id = v.feature_id";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                // Setting parameter values
                preparedStatement.setString(1, postcode);
                preparedStatement.setInt(2, huisnummer);
                preparedStatement.setString(3, woonplaats);
                preparedStatement.setString(4, huisletter); // huisletter parameter
                preparedStatement.setString(5, huisletter); // huisletter null check
                preparedStatement.setString(6, toevoeging); // toevoeging parameter
                preparedStatement.setString(7, toevoeging); // toevoeging null check

                // Execute your prepared statement
                ResultSet rs = preparedStatement.executeQuery();

                try {
                    ordersMetCoordinaten.setCoordinaten_RijksDriehoek(Double.parseDouble(rs.getString(2)), Double.parseDouble(rs.getString(4)));
                    RDtoDegrees(rs.getString(1), Double.parseDouble(rs.getString(2)), Double.parseDouble(rs.getString(4)), ordersMetCoordinaten);
                } catch (NullPointerException e) {
//                        e.printStackTrace();
                }

                rs.close();
                preparedStatement.close();

                if (i == orders.size() - 1) {
                    System.out.println(ConsoleColorCodes.ANSI_PURPLE + "\nProcessed orders\n\n" + orders_met_coordinaten + "\n" + ConsoleColorCodes.ANSI_RESET);

                    Regios regios = new Regios(orders_met_coordinaten);
                    GFG.setOrders(regios);

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }



    private void RDtoDegrees(String id, double O, double N, Orders_Met_Coordinaten ordersMetCoordinaten) {
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


        ordersMetCoordinaten.setCoordinaten_DMS(LatitudeGradenString,  LatitudeMinutenString, LongitudeGradenString, LongitudeMinutenString);
        orders_met_coordinaten.add(ordersMetCoordinaten);




    }
}

package m2h2.Adressen;


import m2h2.Console_Color_Codes.ConsoleColorCodes;
import m2h2.Algoritme.GFG;
import m2h2.FileWriter.FileWriter;
import m2h2.Orders.Order;
import m2h2.Regios.Orders_Met_Coordinaten;
import m2h2.Regios.Regios;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.List;

public class Adressen_GEO_Data_Filter {
    private String url = "jdbc:sqlite:/Users/lucasvissers/IdeaProjects/KBSb-NerdyGadgets-ICTM2h2-P4-maven/src/main/java/m2h2/Nederland_Geografische_Data/bag-light.gpkg";
    private ArrayList<Order> orders;

    private ArrayList<Orders_Met_Coordinaten> orders_met_coordinaten = new ArrayList<>();

    private int progressie = 1;

    private int error_counter = 0;


    public Adressen_GEO_Data_Filter(ArrayList<Order> orders) {
        this.orders = orders;
        Filter_Coordinaten_Op_Adres();
    }


    public void Filter_Coordinaten_Op_Adres() {

//        System.out.println("ORDERS" + orders);

        String[] colorStrings = {ConsoleColorCodes.ANSI_GREEN.toString(), ConsoleColorCodes.ANSI_RED.toString(), ConsoleColorCodes.ANSI_BLUE.toString()};
        int colorIndex = 0; // Initialize the color index

        for (int i = 0; i < orders.size(); i++) {
            String color = colorStrings[colorIndex]; // Get the color based on the current color index

            // Print the processed orders with the current color
            System.out.println(color + "Processed orders: " + orders.get(i) + ConsoleColorCodes.ANSI_RESET);

            // Increment the color index, resetting to 0 after reaching the end of the palette
            colorIndex = (colorIndex + 1) % colorStrings.length;

            // Check if three prints have been made, if so, reset the color index to 0
            if ((i + 1) % 3 == 0) {
                colorIndex = 0;
            }
        }



        System.out.println("\n" + ConsoleColorCodes.ANSI_YELLOW + "Het process wordt uitgevoerd" + ConsoleColorCodes.ANSI_RESET);


        for (int i = 0; i < orders.size(); i++) {

            Orders_Met_Coordinaten ordersMetCoordinaten = new Orders_Met_Coordinaten(orders.get(i).getOrderID(), orders.get(i).getNaam(), orders.get(i).getStraatnaam(), orders.get(i).getPostcode(), orders.get(i).getHuisnummer(), orders.get(i).getOrder());


            try (
                    Connection connection = DriverManager.getConnection(url); Statement statement = connection.createStatement())
            {


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


                    if((i+1 == orders.size())) {

                        System.out.println(ConsoleColorCodes.ANSI_PURPLE + "\nProcessed orders" + orders_met_coordinaten + ConsoleColorCodes.ANSI_RESET);


                        Regios regio = new Regios(orders_met_coordinaten);


                        FileWriter.WriteToFile(regio.getRegio_Noord_Postcodes().toString(), "src/main/java/m2h2/DataFiles/Postcodes/Postcodes_Noord.txt", true);
                        FileWriter.WriteToFile(regio.getRegio_West_Postcodes().toString(), "src/main/java/m2h2/DataFiles/Postcodes/Postcodes_West.txt", true);
                        FileWriter.WriteToFile(regio.getRegio_Zuid_West_Postcodes().toString(), "src/main/java/m2h2/DataFiles/Postcodes/Postcodes_Zuid-West.txt", true);
                        FileWriter.WriteToFile(regio.getRegio_Zuid_Oost_Postcodes().toString(), "src/main/java/m2h2/DataFiles/Postcodes/Postcodes_Zuid-Oost.txt", true);
                        FileWriter.WriteToFile(regio.getRegio_Oost_Postcodes().toString(), "src/main/java/m2h2/DataFiles/Postcodes/Postcodes_Oost.txt", true);


                        int totalOrders = orders.size();

                        System.out.println("Totale orders: " + totalOrders);

                        double dummyOrders = 450;
                        double maxOrders = 200;

                        int startIndex = 0;
                        int endIndex = 199;


                        double m = totalOrders / maxOrders;
                        double n = Math.floor(m);
                        double restwaarde = (m - n) * maxOrders;

                        int batchCount = 0;


                        for (int j = 0; j <= n; j++){
                            if (j < n){

                                for (int k = startIndex; k <= endIndex ; k++) {
//                                    System.out.println(1 + " " + k);

                                    System.out.println("batch 1: " + regio.getRegio_West_Postcodes().get(k));
                                    ArrayList<Orders_Met_Coordinaten> west = new ArrayList<>();
                                    west.add(regio.getRegio_West_Postcodes().get(k));
                                }

                                System.out.println("Eerste is true");
                                System.out.println(startIndex + " " + endIndex);
//
////                                GFG.createPoints(new ArrayList<>(regio.getRegio_West_Postcodes().subList(startIndex, endIndex)), "W");
                                startIndex += 200;
                                endIndex += 200;



                            }
                            if (j == n){
                                System.out.println("tweede is true");

                                int endIndex_Casted = (endIndex + (int)((restwaarde) - maxOrders) + 2);
                                System.out.println(startIndex + " " + endIndex_Casted);

//                                System.out.println("test2");
//                                System.out.println("batch 2: " + batchCount + " " + endIndex_Casted + "\n\n");

                                for (int d = startIndex; d < endIndex_Casted ; d++) {
//                                    System.out.println(2 + " " + d);
                                    System.out.println("batch 2: "  + regio.getRegio_West_Postcodes().get(d));
                                    ArrayList<Orders_Met_Coordinaten> west = new ArrayList<>();
                                    west.add(regio.getRegio_West_Postcodes().get(d));
                                }
////                                GFG.createPoints(new ArrayList<>(regio.getRegio_West_Postcodes().subList(startIndex, endIndex)), "W");

//                                batchCount++;

                            }
                        }




//                        GFG.createPoints(regio.getRegio_West_Postcodes(), "W");
//                        GFG.createPoints(regio.getRegio_Zuid_West_Postcodes(), "ZW");
//                        GFG.createPoints(regio.getRegio_Oost_Postcodes(), "O");
//                        GFG.createPoints(regio.getRegio_Zuid_Oost_Postcodes(), "ZO");
//                        GFG.createPoints(regio.getRegio_Noord_Postcodes(), "N");


                        if(error_counter > 0) {
                            System.out.println("\n" + ConsoleColorCodes.ANSI_RED + "Er hebben " + error_counter + " fouten plaatsgevonden bij het ophalen van de coördinaten van adressen. Voor meer informatie zie de logfile in DataFiles/GEO_Data_Fetch_Errors.txt");
                        }

                    }

                } catch (Exception e) {
                    error_counter++;
                    String data = e + " " + orders.get(i) + "\n";
                    FileWriter.WriteToFile(data, "src/main/java/m2h2/DataFiles/Errors/GEO_Data_Fetch_Errors.txt", true);
                }

                rs.close();
                preparedStatement.close();

            } catch (SQLException e) {
                e.printStackTrace(System.err);
            } catch (Exception a) {
                System.out.println("Error: " + a);
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



    public void addOrder(Order order) {
        orders.add(order);
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }


}

package m2h2.Adressen;


import m2h2.Orders.Order;
import m2h2.Regios.GefilterdeAdressen;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class Adressen_GEO_Data {

    private String url = "jdbc:sqlite:/Users/lucasvissers/IdeaProjects/KBSb-NerdyGadgets-ICTM2h2-P4-maven/src/main/java/m2h2/Nederland_Geografische_Data/nwb_wegen.gpkg";
    private ArrayList<Order> orders;

    private int progressie = 1;




    public Adressen_GEO_Data(ArrayList<Order> orders) {
        this.orders = orders;
    }



    public void Filter_Coordinaten_Op_Adres(ArrayList<Order> orders) {

        for (int i = 0; i < orders.size() ; i++) {

            String straatnaam = orders.get(i).getStraatnaam();

            GefilterdeAdressen gefilterdeAdressen1 = new GefilterdeAdressen(
                    orders.get(i).getOrderID(),
                    orders.get(i).getNaam(),
                    orders.get(i).getStraatnaam(),
                    orders.get(i).getPostcode(),
                    orders.get(i).getHuisnummer(),
                    orders.get(i).getOrder()
                    );




            try (
                    //Database connectie
                    Connection connection = DriverManager.getConnection(url);
                    Statement statement = connection.createStatement()
            ) {

                statement.setQueryTimeout(30);  // set timeout to 30 sec.

                // Use a placeholder (?) in the query for straatnaam
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT rtree_wegvakken_geom.id, wegvakken.fid, wegvakken.stt_naam, rtree_wegvakken_geom.minx, rtree_wegvakken_geom.miny, rtree_wegvakken_geom.maxx, rtree_wegvakken_geom.maxy FROM wegvakken JOIN rtree_wegvakken_geom ON wegvakken.fid = rtree_wegvakken_geom.id WHERE wegvakken.stt_naam = ?");

                // Set the value of straatnaam
                preparedStatement.setString(1, straatnaam);

                ResultSet rs = preparedStatement.executeQuery();


                System.out.println("-----> Connectie gemaakt!");


                while (rs.next()) {
                    try {
                        RDtoDegrees(rs.getString(1), Double.parseDouble(rs.getString(4)), Double.parseDouble(rs.getString(5)), gefilterdeAdressen1);

                    } catch (Exception e) {
                        System.out.println("Er is een fout opgetreden" + e);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace(System.err);
            } catch (Exception a) {
                System.out.println("Error: " + a);
            }
        }


    }

    ArrayList<Double> gemiddeldeList = new ArrayList<>();

    private void RDtoDegrees(String id, double O, double N, GefilterdeAdressen adressen) {
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

        double LatitudeGraden_double = LatitudeGraden;
        double LongitudeGraden_double = Longitude;


        double LatitudeMinuten = (Latitude - LatitudeGraden) * 60;
        double LongitudeMinuten = (Longitude - LongitudeGraden) * 60;

        String LatitudeGradenString = Integer.toString(LatitudeGraden);
        String LongitudeGradenString = Integer.toString(LongitudeGraden);

        String LatitudeMinutenString = Double.toString(LatitudeMinuten);
        String LongitudeMinutenString = Double.toString(LongitudeMinuten);

        adressen.setCoordinaten(" Coördinaten: " + LatitudeGradenString + "° " + LatitudeMinutenString + ", " + LongitudeGradenString + "° " + LongitudeMinutenString);
        System.out.println(adressen);

        gemiddeldeList.add(LatitudeGraden_double);
        gemiddeldeList.add(LatitudeMinuten);
        gemiddeldeList.add(LongitudeGraden_double);
        gemiddeldeList.add(LongitudeMinuten);



        writeToFile(id, LatitudeGradenString, LatitudeMinutenString, LongitudeGradenString, LongitudeMinutenString);

    }

    public void calculateMidpoint() {
        double totalLatitude = 0;
        double totalLongitude = 0;
        int count = 0;

        // Iterate through gemiddeldeList by 4 elements at a time (latitudeGraden, latitudeMinuten, longitudeGraden, longitudeMinuten)
        for (int i = 0; i < gemiddeldeList.size(); i += 4) {
            double latitudeGraden = gemiddeldeList.get(i);
            double latitudeMinuten = gemiddeldeList.get(i + 1);
            double longitudeGraden = gemiddeldeList.get(i + 2);
            double longitudeMinuten = gemiddeldeList.get(i + 3);

            // Convert degrees and minutes to decimal degrees
            double latitudeDecimal = latitudeGraden + latitudeMinuten / 60.0;
            double longitudeDecimal = longitudeGraden + longitudeMinuten / 60.0;

            // Accumulate total latitude and longitude
            totalLatitude += latitudeDecimal;
            totalLongitude += longitudeDecimal;
            count++;
        }

        // Calculate the average latitude and longitude
        double averageLatitude = totalLatitude / count;
        double averageLongitude = totalLongitude / count;

        // Convert average latitude and longitude back to degrees and minutes
        int averageLatitudeGraden = (int) averageLatitude;
        double averageLatitudeMinuten = (averageLatitude - averageLatitudeGraden) * 60;
        int averageLongitudeGraden = (int) averageLongitude;
        double averageLongitudeMinuten = (averageLongitude - averageLongitudeGraden) * 60;

        // Print the midpoint coordinates
        System.out.println("Coördinaten: " + averageLatitudeGraden + "° " + averageLatitudeMinuten + "', " + averageLongitudeGraden + "° " + averageLongitudeMinuten + "'");
    }


    private void writeToFile(String id, String LatitudeGraden, String LatitudeMinuten, String LongitudeGraden, String LongitudeMinuten) {
        try {
            FileWriter myWriter = new FileWriter("/Users/lucasvissers/IdeaProjects/KBSb-NerdyGadgets-ICTM2h2-P4-maven/src/main/java/m2h2/sqlite_queries_outputs/Coordinaten_orders.txt", true);
//            myWriter.write( "N" + LatitudeGraden + "'" + LatitudeMinuten + "\n");
            myWriter.write( " W" + LongitudeGraden + "'" + LongitudeMinuten + "\n");

//            myWriter.write(LatitudeGraden + "° " + LatitudeMinuten + ", " + LongitudeGraden + "° " + LongitudeMinuten + "\n");
            myWriter.close();
            System.out.println("ID: " + progressie + "-----> ✔");
            progressie++;
        } catch (IOException e) {
            System.out.println("### -----> Er is een fout opgetreden bij ID: " + progressie);
            e.printStackTrace();
        }
    }
    public void addOrder(Order order){
        orders.add(order);
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }


}

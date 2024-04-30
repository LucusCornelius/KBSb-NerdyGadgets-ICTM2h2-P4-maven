package DataExtractor;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Hectometerpaal_GEO_Data_WGS {
    private static int progressie = 1;

    public static void main(String[] args) {
        // Geopackage URL
        String url = "jdbc:sqlite:src/main/java/m2h2/Nederland_Geografische_Data/nwb_wegen.gpkg";

        try (
            //Database connectie
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
        ) {

            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            //Query 1
//            ResultSet rs = statement.executeQuery("SELECT * FROM rtree_hectopunten_geom ORDER BY id asc;");
            ResultSet rs = statement.executeQuery("SELECT * from rtree_wegvakken_geom where id = 108577;");


            System.out.println("-----> Connectie gemaakt!");


            while (rs.next()) {
                try {
                    RDtoDegrees(rs.getString(1), Double.parseDouble(rs.getString(3)), Double.parseDouble(rs.getString(5)));

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


    private static void RDtoDegrees(String id, double O, double N) {
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

        String LatitudeGradenString = Integer.toString(LatitudeGraden);
        String LongitudeGradenString = Integer.toString(LongitudeGraden);

        String LatitudeMinutenString = Double.toString(LatitudeMinuten);
        String LongitudeMinutenString = Double.toString(LongitudeMinuten);

        writeToFile(id, LatitudeGradenString, LatitudeMinutenString, LongitudeGradenString, LongitudeMinutenString);
    }

    private static void writeToFile(String id, String LatitudeGraden, String LatitudeMinuten, String LongitudeGraden, String LongitudeMinuten) {
        try {
            FileWriter myWriter = new FileWriter("/Users/lucasvissers/IdeaProjects/KBSb-NerdyGadgets-ICTM2h2-P4-maven/src/main/java/m2h2/sqlite_queries_outputs/HectometerpaalCordsWGS.txt", true);
            myWriter.write("Hectometerpaal-ID: " + id + " Coördinaten: " + LatitudeGraden + "° " + LatitudeMinuten + ", " + LongitudeGraden + "° " + LongitudeMinuten + "\n");
            myWriter.close();
            System.out.println("ID: " + progressie + "-----> ✔");
            progressie++;
        } catch (IOException e) {
            System.out.println("### -----> Er is een fout opgetreden bij ID: " + progressie);
            e.printStackTrace();
        }
    }
}

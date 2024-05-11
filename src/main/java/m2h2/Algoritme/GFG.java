package m2h2.Algoritme;

import Console_Color_Codes.ConsoleColorCodes;
import com.google.zxing.EncodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import m2h2.Regios.Orders_Met_Coordinaten;
import m2h2.RouteBuilder.RouteBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class GFG {

    static ArrayList<Orders_Met_Coordinaten> route = new ArrayList<>();

    public static void createPoints(ArrayList<Orders_Met_Coordinaten> orders, String Regio) {
        int n = orders.size();
        Point[] arr = new Point[n];

        for (int i = 0; i < orders.size(); i++) {



            arr[i] = new Point();
            arr[i].adres = orders.get(i).getStraatnaam();
            arr[i].huisnummer = orders.get(i).getHuisnummer();
            arr[i].x = orders.get(i).getCoordinaten_RijksDriehoek_X();
            arr[i].y = orders.get(i).getCoordinaten_RijksDriehoek_Y();
            arr[i].order = orders.get(i);



            if(orders.size() == i + 1) {

                Point testPoint = new Point();
                testPoint.x = 136215; //Startpunt is Utrecht
                testPoint.y = 455886;


                //K NN
                int k = 1;

                System.out.println("\n" + ConsoleColorCodes.ANSI_YELLOW + "Het dichtstbijzijnde punt vanaf het startpunt UTRECHT is " +  findClosestCity(arr, n, k, testPoint) + "\n" + ConsoleColorCodes.ANSI_RESET);



                resetFile();
                writeToFileFunctions(route);

                try {


                    //ergens in amsterdam: 4.898435157003786, 52.34329645288008

                            //utrecht: 5.113111,52.09092
                    StringBuilder route_URL = new StringBuilder("http://127.0.0.1:5000/route/v1/driving/4.898435157003786,52.34329645288008;");


                    for (int j = 0; j < route.size(); j++) {
                        route_URL.append(orders.get(j).getCoordinaten_OSMR());

                        if(j == route.size() -1 ) {

                            String url = route_URL.toString();

                            int lastIndex = url.lastIndexOf(";");

                            if (lastIndex != -1) {

                                url = url.substring(0, lastIndex) + url.substring(lastIndex + 1);

                                route_URL = new StringBuilder(url);
                            }
                            route_URL.append("?alternatives=false&steps=true&annotations=false&geometries=geojson&overview=full");
                        }
                    }

                    String path = "route.png";

                    // Encoding charset
                    String charset = "UTF-8";

                    Map<EncodeHintType, ErrorCorrectionLevel> hashMap
                            = new HashMap<EncodeHintType,
                            ErrorCorrectionLevel>();

                    hashMap.put(EncodeHintType.ERROR_CORRECTION,
                            ErrorCorrectionLevel.L);



                    RouteBuilder.setRoutes(route_URL.toString(), Regio);
                    System.out.println(route_URL);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    static String findClosestCity(Point arr[], int n, int k, Point p) {
        try {
            // Fill distances of all arr from p
            for (int i = 0; i < n; i++)
                arr[i].distance = Math.sqrt(
                        Math.pow((arr[i].x - p.x), 2)
                                + Math.pow((arr[i].y - p.y), 2));

            // Sort the arr by distance from p
            Arrays.sort(arr, new Comparison());

            // Now consider the first k elements

            for (int i = 0; i < arr.length; i++) {
                route.add(arr[i].order);
            }

        } catch(Exception e) {
            System.out.println(e);
        }
        return arr[0].adres;
    }

    // This function finds the closest adres to the test point using
    // k nearest neighbour algorithm.

    private static void writeToFileFunctions(ArrayList<Orders_Met_Coordinaten> orders_gesorteerd_op_route) {


        try {
            FileWriter myWriter = new FileWriter("src/main/java/m2h2/Sqlite_Queries_Outputs/orders_gesorteerd_op_route.txt", true);

            for (int i = 0; i < orders_gesorteerd_op_route.size(); i++) {
                myWriter.write(orders_gesorteerd_op_route.get(i) + "\n");
                System.out.println(ConsoleColorCodes.ANSI_PURPLE + "ID: " + i + " -----> ✔" + ConsoleColorCodes.ANSI_RESET);
            }
            myWriter.close(); // Remember to close the FileWriter
        } catch (IOException e) {
            System.out.println("### -----> Er is een fout opgetreden bij ID: ");
            e.printStackTrace();
        }
    }

    private static void resetFile() {


        try {
            FileWriter myWriter = new FileWriter("src/main/java/m2h2/Sqlite_Queries_Outputs/orders_gesorteerd_op_route.txt", false);


                myWriter.write("");
                myWriter.close(); // Remember to close the FileWriter

        } catch (IOException e) {
            System.out.println("### -----> Reset mislukt");
            e.printStackTrace();
        }
    }

    public static class Point {

        String adres; // Name of the adres

        Orders_Met_Coordinaten order;

        int huisnummer;
        double x, y; // Co-ordinate of adres
        double distance; // Distance from test point


    }

    // Used to sort an array of points by increasing
    // order of distance
    static class Comparison implements Comparator<Point> {




        public int compare(Point a, Point b)
        {
            if (a.distance < b.distance)
                return -1;
            else if (a.distance > b.distance)
                return 1;
            return 0;
        }
    }


}

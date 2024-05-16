package m2h2.Algoritme;

import m2h2.Console_Color_Codes.ConsoleColorCodes;
import com.google.zxing.EncodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import m2h2.Regios.Orders_Met_Coordinaten;
import m2h2.Regios.Regios;
import m2h2.RouteBuilder.RouteBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.CompletableFuture;


public class GFG {

//    private static ArrayList<Orders_Met_Coordinaten> route = new ArrayList<>();

    private static String route;

    private static ArrayList<Orders_Met_Coordinaten> regio_West = new ArrayList<>();
    private static ArrayList<Orders_Met_Coordinaten> regio_Noord = new ArrayList<>();
    private static ArrayList<Orders_Met_Coordinaten> regio_Oost = new ArrayList<>();
    private static ArrayList<Orders_Met_Coordinaten> regio_Zuid_Oost = new ArrayList<>();
    private static ArrayList<Orders_Met_Coordinaten> regio_Zuid_West = new ArrayList<>();

    private static int aantalRegios = 5;


    private static void addAllIfNotNull(ArrayList<Orders_Met_Coordinaten> destination, ArrayList<Orders_Met_Coordinaten> source) {
        if (source != null) {
            destination.addAll(source);
        }
    }
    public static void setOrders(Regios regios) {
        System.out.println("Orders worden voorberreid voor algoritme.");

        addAllIfNotNull(regio_West, regios.getRegio_West_Postcodes());
        addAllIfNotNull(regio_Noord, regios.getRegio_Noord_Postcodes());
        addAllIfNotNull(regio_Oost, regios.getRegio_Oost_Postcodes());
        addAllIfNotNull(regio_Zuid_Oost, regios.getRegio_Zuid_Oost_Postcodes());
        addAllIfNotNull(regio_Zuid_West, regios.getRegio_Zuid_West_Postcodes());

        String[] regionCodes = {"w", "n", "o", "zo", "zw"};
        for (String code : regionCodes) {
                if(!getRegionList(code).isEmpty()) {
                    createPoints(getRegionList(code), code);
                } else {
                    System.out.println("De volgende regio's zijn leeg: " + code);
                }

        }
    }

    private static ArrayList<Orders_Met_Coordinaten> getRegionList(String regionCode) {
        switch (regionCode) {
            case "w":
                return regio_West;
            case "n":
                return regio_Noord;
            case "o":
                return regio_Oost;
            case "zo":
                return regio_Zuid_Oost;
            case "zw":
                return regio_Zuid_West;
            default:
                return null;
        }
    }

    public static void createPoints(ArrayList<Orders_Met_Coordinaten> regio, String regio_letter) {

        System.out.println("Regio: " + regio_letter);
        System.out.println(regio);

        int n = regio.size();
        Point[] arr = new Point[n];

        for (int i = 0; i < regio.size(); i++) {

            System.out.println("Dit: " + i);

            arr[i] = new Point();
            arr[i].adres = regio.get(i).getStraatnaam();
            arr[i].huisnummer = regio.get(i).getHuisnummer();
            arr[i].x = regio.get(i).getCoordinaten_RijksDriehoek_X();
            arr[i].y = regio.get(i).getCoordinaten_RijksDriehoek_Y();
            arr[i].order = regio.get(i);


            if(regio.size() == i + 1) {

                Point testPoint = new Point();
                testPoint.x = 136215; //Startpunt is Utrecht
                testPoint.y = 455886;

                //K NN
                int k = 1;

                System.out.println("\n" + ConsoleColorCodes.ANSI_YELLOW + "Het dichtstbijzijnde punt vanaf het startpunt UTRECHT is " +  findClosestCity(arr, n, k, testPoint) + "\n" + ConsoleColorCodes.ANSI_RESET);

                try {
                    StringBuilder route_URL = new StringBuilder("http://127.0.0.1:5000/route/v1/driving/5.0651060782846375,52.10576529347831;");


                    for (int j = 0; j < regio.size() ; j++) {
                        System.out.println("doppio: " + regio.get(j));
                        route_URL.append(regio.get(j).getCoordinaten_OSMR());

                        if(j == regio.size() -1 ) {
                            System.out.println("unico: " + route);
                            route_URL.append("5.0651060782846375,52.10576529347831?alternatives=false&steps=true&annotations=false&geometries=geojson&overview=full");
                        }
                    }

                    CompletableFuture<Void> future = CompletableFuture.runAsync(() -> RouteBuilder.setRoutes(route_URL.toString(), regio_letter, 1));
                    System.out.println(route_URL);

                    future.thenRun(() -> System.out.println("setRoutes is klaar"));

                    future.join();
                } catch (Exception e) {
                    e.printStackTrace();
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

//            for (int i = 0; i < arr.length; i++) {
//                route.add(arr[i].);
//            }


        } catch(Exception e) {
            System.out.println(e);
        }
        return arr[0].adres;
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

package m2h2.Algoritme;

import m2h2.Console_Color_Codes.ConsoleColorCodes;

import java.util.*;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class KNN_Algoritme {
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

            arr[i] = new Point();
            arr[i].adres = regio.get(i).getStraatnaam();
            arr[i].huisnummer = regio.get(i).getHuisnummer();
            arr[i].x = regio.get(i).getCoordinaten_RijksDriehoek_X();
            arr[i].y = regio.get(i).getCoordinaten_RijksDriehoek_Y();
            arr[i].order = regio.get(i);
            arr[i].osmr = regio.get(i).getCoordinaten_OSMR();


            if(regio.size() == i + 1) {

                Point startPoint = new Point();
                startPoint.x = 136215; //Startpunt is Utrecht
                startPoint.y = 455886;

                //K NN
                int k = 1;

                ArrayList<Point> sortedOrders = sortOrders(arr, n, k, startPoint);

                System.out.println("\n" + ConsoleColorCodes.ANSI_YELLOW + "Het dichtstbijzijnde punt vanaf het startpunt UTRECHT is "  + "\n" + ConsoleColorCodes.ANSI_RESET);

                try {

                    int batch_count = 0;
                    int sortedOrders_size = sortedOrders.size();
                    double maxOrders = 200;

                    int aantal_bussen = (int) Math.ceil( sortedOrders_size / maxOrders);

                    System.out.println("bussen: " + aantal_bussen);

                    double m = sortedOrders_size / maxOrders;
                    double a = Math.floor(m);
                    double restwaarde = (m - a) * maxOrders;

                    System.out.println("size: " + sortedOrders_size);


                    int startIndex = 0;
                    int endIndex = 199;

                    String start_url = "http://0.0.0.0:5000/route/v1/driving/5.0651060782846375,52.10576529347831;";

                    StringBuilder route_URL = new StringBuilder(start_url);

                        for (int j = 0; j < aantal_bussen - 1; j++) {
                            System.out.println("startIndex: " + startIndex + "endIndex: " + endIndex);

                            List<Point> sublist = sortedOrders.subList(startIndex, endIndex - 1);
                            for (Point point : sublist) {
                                String coordinates = point.osmr;
                                route_URL.append(coordinates);
                            }
                            startIndex = endIndex + 1;
                            endIndex += 200;


                            if (j == aantal_bussen - 2) {
                                batch_count++;
                                final int batchCount = batch_count;
                                System.out.println(batchCount);


                                route_URL.append("5.0651060782846375,52.10576529347831?alternatives=false&steps=true&annotations=false&geometries=geojson&overview=full");


                                System.out.println(route_URL);

                                final String route_osmr_complete_URL = route_URL.toString();
                                route_URL.replace(0, route_URL.length(), start_url);


                                CompletableFuture<Void> future = CompletableFuture.runAsync(() -> RouteBuilder_OSRM.setRoutes(route_osmr_complete_URL, regio_letter, batchCount));

                                future.thenRun(() -> System.out.println("setRoutes is klaar"));

                                future.join();

                            }

                        }

                    if (restwaarde == 0) {
                        System.out.println(startIndex);
                        System.out.println(endIndex - 1);
                    } else {

                        System.out.println(ConsoleColorCodes.ANSI_GREEN + "\n BLOCK 2\n" + "Regio: " + regio_letter);
                        System.out.println("startIndex: " + startIndex + "endIndex: " + (int)(startIndex + restwaarde));

                        List<Point> sublist = sortedOrders.subList((int) startIndex, (int)(startIndex + restwaarde));
                        int sublistSize = sublist.size();
                        System.out.println("sublist: " + sublistSize);
                        int loopCount = 0;
                        for (Point point : sublist) {
                            String coordinates = point.osmr;
                            route_URL.append(coordinates);
                            loopCount++;
                        }

                        if (loopCount == sublistSize) {
                            batch_count++;
                            final int batchCount = batch_count;


                            route_URL.append("5.0651060782846375,52.10576529347831?alternatives=false&steps=true&annotations=false&geometries=geojson&overview=full");
                            System.out.println("batch_count: " + batchCount);
                            System.out.println(route_URL);


                            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                                try {
                                    RouteBuilder_OSRM.setRoutes(route_URL.toString(), regio_letter, batchCount);
                                } catch (Exception e) {
                                    e.printStackTrace(); // Handle the exception appropriately
                                }
                            });

                            future.thenRun(() -> {
                                System.out.println("setRoutes is klaar");
                                synchronized (route_URL) {
                                    route_URL.replace(0, route_URL.length(), start_url);
                                }
                            }).exceptionally(e -> {
                                e.printStackTrace(); // Handle any exceptions that occurred during the asynchronous operation
                                return null;
                            });

                            future.join(); // Ensure this is intentional, as it blocks the main thread

                        }

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    static ArrayList<Point> sortOrders(Point arr[], int n, int k, Point p) {
        try {
            // Fill distances of all arr from p
            for (int i = 0; i < n; i++)
                arr[i].distance = Math.sqrt(
                        Math.pow((arr[i].x - p.x), 2)
                                + Math.pow((arr[i].y - p.y), 2));

            // Sort the arr by distance from p
            Arrays.sort(arr, new Comparison());

            // Create the sortedOrders array and populate it with sorted points
            ArrayList<Point> sortedOrders = new ArrayList<>(Arrays.asList(arr));
            return sortedOrders;

        } catch(Exception e) {
            System.out.println(e);
        }
        return null; // Handle potential error cases or return another appropriate value
    }

    public static class Point {

        String adres; // Name of the adres

        Orders_Met_Coordinaten order;

        int huisnummer;
        double x, y; // Co-ordinate of adres
        double distance; // Distance from test point

        String osmr;
        int routeIndex;

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

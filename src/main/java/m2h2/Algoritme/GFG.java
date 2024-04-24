package Algoritme;

import Console_Color_Codes.ConsoleColorCodes;

import java.util.*;

class GFG {

    static class Point {

        String city; // Name of the city
        double x, y; // Co-ordinate of city
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

    // This function finds the closest city to the test point using
    // k nearest neighbour algorithm.


    static ArrayList<String> route = new ArrayList<>();

    static String findClosestCity(Point arr[], int n, int k, Point p) {
        // Fill distances of all cities from p
        for (int i = 0; i < n; i++)
            arr[i].distance = Math.sqrt(
                    Math.pow((arr[i].x - p.x), 2)
                            + Math.pow((arr[i].y - p.y), 2));

        // Sort the cities by distance from p
        Arrays.sort(arr, new Comparison());

        // Now consider the first k elements

        for (int i = 0; i < arr.length; i++) {
            route.add(arr[i].city);
        }

        return arr[0].city;
    }

    // Driver code
    public static void main(String[] args)
    {
        int n = 7;

        Point[] cities = new Point[n];
        cities[0] = new Point();
        cities[0].city = "De Wijk";
        cities[0].x = 52.6762;
        cities[0].y = 6.2842;

        cities[1] = new Point();
        cities[1].city = "Zwolle";
        cities[1].x = 52.5171;
        cities[1].y = 6.0833;

        cities[2] = new Point();
        cities[2].city = "Hilversum";
        cities[2].x = 52.22333;
        cities[2].y = 5.17639;

        cities[3] = new Point();
        cities[3].city = "Utrecht";
        cities[3].x = 52.0907;
        cities[3].y = 5.1214;

        cities[4] = new Point();
        cities[4].city = "Eindhoven";
        cities[4].x = 51.4416;
        cities[4].y = 5.4697;

        cities[5] = new Point();
        cities[5].city = "Groningen";
        cities[5].x = 53.2194;
        cities[5].y = 6.5665;

        cities[6] = new Point();
        cities[6].city = "Maastricht";
        cities[6].x = 50.8514;
        cities[6].y = 5.6913;





        Point testPoint = new Point();
        testPoint.x = 52.0907; //Startpunt is Utrecht
        testPoint.y = 5.1214;

        // Parameter to decide the number of nearest neighbors to consider
        int k = 1;

        System.out.println(ConsoleColorCodes.ANSI_YELLOW + "De dichtstbijzijnde stad vanaf het startpunt UTRECHT is " +  findClosestCity(cities, n, k, testPoint) + ConsoleColorCodes.ANSI_RESET);
        System.out.println(ConsoleColorCodes.ANSI_PURPLE + "Route" + route + ConsoleColorCodes.ANSI_RESET);


    }
}

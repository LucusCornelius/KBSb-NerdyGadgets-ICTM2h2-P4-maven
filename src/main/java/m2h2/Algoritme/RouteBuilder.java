package m2h2.Algoritme;




import m2h2.Backoffice.Components.Route;

import m2h2.Console_Color_Codes.ConsoleColorCodes;
import m2h2.FileWriter.FileWriter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;



public class RouteBuilder {

    private static String Route_URL_SUBSTRING = "http://127.0.0.1:5000/route/v1/driving/5.0651060782846375,52.10576529347831;";


    public static void setRoutes(String Route_URL, String regio_letter, int batch_count) {

        if (Route_URL.contains(Route_URL_SUBSTRING)) {
            System.out.println(ConsoleColorCodes.ANSI_GREEN + "\n URL heeft de check gepasseerd!" + ConsoleColorCodes.ANSI_RESET);

            CompletableFuture<Void> future = null;
            switch (regio_letter) {
                case "w":
                    future = CompletableFuture.runAsync(() -> BuildRoute(Route_URL, "west", batch_count));
                    break;
                case "n":
                    future = CompletableFuture.runAsync(() -> BuildRoute(Route_URL, "noord", batch_count));
                    break;
                case "zw":
                    future = CompletableFuture.runAsync(() -> BuildRoute(Route_URL, "zuid-west", batch_count));
                    break;
                case "zo":
                    future = CompletableFuture.runAsync(() -> BuildRoute(Route_URL, "zuid-oost", batch_count));
                    break;
                case "o":
                    future = CompletableFuture.runAsync(() -> BuildRoute(Route_URL, "oost", batch_count));
                    break;
                default:
                    System.out.println("Invalid regio_letter");
            }

            if (future != null) {
                System.out.println(ConsoleColorCodes.ANSI_RED + "\n ROUTE BUILDER GESTART" + ConsoleColorCodes.ANSI_RESET);
                future.join();
            }
        }
    }



    private static void BuildRoute(String Route_URL_REGIO, String Regio, int batch_count) {

        System.out.println(ConsoleColorCodes.ANSI_YELLOW + "\n POST REQUEST wordt uitgevoerd!\n" + ConsoleColorCodes.ANSI_RESET);

        try {
            HttpClient client = HttpClient.newHttpClient();

            String jsonBody = "";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(Route_URL_REGIO))
                    .timeout(Duration.ofMinutes(1))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            CompletableFuture<HttpResponse<String>> responseFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

            HttpResponse<String> response = responseFuture.join();

            response.body();
                        try {

                            FileWriter.WriteToFile(response.body(), "src/main/java/m2h2/DataFiles/Responses/PostReq_OSRM.json", true);
                            CompletableFuture<Void> future = null;

                            future = CompletableFuture.runAsync(() -> formatResponseGeoJSON(response.body(), Regio, Route_URL_REGIO, batch_count));


                            future.join();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
        catch (Exception e) {
            e.printStackTrace();

        }

    }

    private static void formatResponseGeoJSON(String jsonResponse, String Regio, String Route_URL_REGIO, int batch_count) {
        JsonObject jsonObject = new Gson().fromJson(jsonResponse, JsonObject.class);

        JsonObject geoJson = new JsonObject();
        geoJson.addProperty("type", "FeatureCollection");

        JsonArray features = new JsonArray();

        // waypoints
        JsonArray waypoints = jsonObject.getAsJsonArray("waypoints");
        for (JsonElement waypointElement : waypoints) {
            JsonObject waypoint = waypointElement.getAsJsonObject();
            JsonObject waypointFeature = new JsonObject();
            waypointFeature.addProperty("type", "Feature");
            JsonObject waypointGeometry = new JsonObject();
            waypointGeometry.addProperty("type", "Point");
            waypointGeometry.add("coordinates", waypoint.get("location"));
            waypointFeature.add("geometry", waypointGeometry);
            waypoint.remove("location");
            waypointFeature.add("properties", waypoint);
            features.add(waypointFeature);
        }

        //Route
        JsonArray routes = jsonObject.getAsJsonArray("routes");

        for (JsonElement routeElement : routes) {
            JsonObject route = routeElement.getAsJsonObject();
            JsonObject routeFeature = new JsonObject();
            routeFeature.addProperty("type", "Feature");
            JsonObject routeGeometry = new JsonObject();
            routeGeometry.addProperty("type", "LineString");
            routeGeometry.add("coordinates", route.getAsJsonObject("geometry").get("coordinates"));
            route.remove("geometry");
            routeFeature.add("geometry", routeGeometry);
            routeFeature.add("properties", route);
            features.add(routeFeature);
        }

        geoJson.add("features", features);

        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                GeoJson_to_GPX(geoJson.toString(), Regio, Route_URL_REGIO, batch_count);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        FileWriter.WriteToFile(geoJson.toString(), "src/main/java/m2h2/DataFiles/Responses/PostReqGeoJSON_Filtered.geojson", true);

        future.join();
    }


    private static void GeoJson_to_GPX(String geoJSON, String Regio, String Route_URL_Regio, int batch_count) {

        ArrayList<String> lat = new ArrayList<>();
        ArrayList<String> longi = new ArrayList<>();


        try {
            URL url = new URL(Route_URL_Regio);
            String path = url.getPath();

            // Define a regular expression to match coordinates
            Pattern pattern = Pattern.compile("[-+]?\\d*\\.\\d+,[ ]?[-+]?\\d*\\.\\d+");
            Matcher matcher = pattern.matcher(path);




            // Extract and print coordinates
            while (matcher.find()) {
                String coordinatePair = matcher.group();
                String[] coordinates = coordinatePair.split(",");
                if (coordinates.length == 2) {
                    // Parse latitude and longitude
                    double longitude = Double.parseDouble(coordinates[0]);
                    double latitude = Double.parseDouble(coordinates[1]);

                    lat.add(Double.toString(latitude));
                    longi.add(Double.toString(longitude));


                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



        try {
            JSONObject geoJsonObject = new JSONObject(geoJSON);

            java.io.FileWriter gpxWriter = new java.io.FileWriter("src/main/java/m2h2/DataFiles/GPX/" + Regio + "_batch_" + batch_count + ".gpx");
            gpxWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            gpxWriter.write("<gpx version=\"1.1\" xmlns=\"http://www.nerdygadgets.nl\">\n");

            JSONArray features = geoJsonObject.getJSONArray("features");
            for (int i = 0; i < features.length(); i++) {
                JSONObject feature = features.getJSONObject(i);
                JSONObject properties = feature.getJSONObject("properties");
                String name = properties.has("name") ? properties.getString("name") : Integer.toString(i);

                JSONObject geometry = feature.getJSONObject("geometry");
                JSONArray coordinates = geometry.getJSONArray("coordinates");

                if (geometry.getString("type").equals("Point")) {

                    gpxWriter.write("<wpt lat=\"" + lat.get(i) + "\" lon=\"" + longi.get(i) + "\">\n");
                    gpxWriter.write("<name>" + name + "</name>\n");
                    gpxWriter.write("</wpt>\n");
                } else if (geometry.getString("type").equals("LineString")) {
                    gpxWriter.write("<trk>\n");
                    gpxWriter.write("<name>" + name + "</name>\n");
                    gpxWriter.write("<trkseg>\n");
                    for (int j = 0; j < coordinates.length(); j++) {
                        JSONArray coordinate = coordinates.getJSONArray(j);
                        gpxWriter.write("<trkpt lat=\"" + coordinate.getDouble(1) + "\" lon=\"" + coordinate.getDouble(0) + "\"></trkpt>\n");
                    }
                    gpxWriter.write("</trkseg>\n");
                    gpxWriter.write("</trk>\n");
                }
            }

            gpxWriter.write("</gpx>");
            gpxWriter.close();
            System.out.println(ConsoleColorCodes.ANSI_PURPLE + " -------> GPX conversie is succesvol verlopen ✓ \n De GPX bestanden staan opgeslagen in de map DataFiles/GPX" + ConsoleColorCodes.ANSI_RESET);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package m2h2.RouteBuilder;




import Console_Color_Codes.ConsoleColorCodes;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
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

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;



public class RouteBuilder {

   private static String Routes_West_URL;
    private static String Routes_Zuid_West_URL;
    private static String Routes_Oost_URL;
    private static String Routes_Zuid_Oost_URL;
    private static String Routes_Noord_URL;







    public static void setRoutes(String Route_URL, String Regio) {


       String Route_URL_SUBSTRING = "http://127.0.0.1:5000/route/v1/driving/4.898435157003786,52.34329645288008;";
        if (Route_URL.contains(Route_URL_SUBSTRING)) {
            System.out.println(ConsoleColorCodes.ANSI_GREEN + "\n URL heeft de check gepasseerd!" + ConsoleColorCodes.ANSI_RESET);

            if(Regio.equals("W")) {
                Routes_West_URL = Route_URL;
            }

            if(Regio.equals("N")) {
              Routes_Noord_URL = Route_URL;
            }

            if(Regio.equals("ZW")) {
                Routes_Zuid_West_URL = Route_URL;
            }
            if(Regio.equals("ZO")) {
                Routes_Zuid_Oost_URL = Route_URL;
            }

            if(Regio.equals("O")) {
                Routes_Oost_URL = Route_URL;
            }

        }
    }

    public static void BuildRoutes_Starter() {

        System.out.println(ConsoleColorCodes.ANSI_RED + "\n ROUTE BUILDER GESTART" + ConsoleColorCodes.ANSI_RESET);

        for (int i = 0; i <= 4; i++) {
            if (i == 0 && Routes_West_URL != null) {
                BuildRoute(Routes_West_URL, "west");
            }

            if (i == 1 && Routes_Noord_URL != null) {
                BuildRoute(Routes_Noord_URL, "noord");
            }

            if (i == 2 && Routes_Zuid_West_URL != null) {
                BuildRoute(Routes_Zuid_West_URL, "zuid-west");
            }

            if (i == 3 && Routes_Zuid_Oost_URL != null) {
                BuildRoute(Routes_Zuid_Oost_URL, "zuid-oost");
            }

            if (i == 4 && Routes_Oost_URL != null) {
                BuildRoute(Routes_Oost_URL, "oost");
            }

        }
    }

    private static void BuildRoute(String Route_URL_REGIO, String Regio) {


        System.out.println(ConsoleColorCodes.ANSI_YELLOW + "\n POST REQUEST wordt uitgevoerd!\n" + ConsoleColorCodes.ANSI_RESET);

        HttpClient client = HttpClient.newHttpClient();

        String jsonBody = "";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(Route_URL_REGIO))
                .timeout(Duration.ofMinutes(1))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        CompletableFuture<Void> delayedFuture = CompletableFuture
                .supplyAsync(() -> {
                    try {
                        Thread.sleep(2000); // Delay for 5 seconds
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    return null;
                })
                .thenCompose(ignored -> client.sendAsync(request, HttpResponse.BodyHandlers.ofString()))
                .thenAccept(response -> {

                    m2h2.FileWriter.FileWriter.WriteToFile(response.body(), "src/main/java/m2h2/DataFiles/Responses/PostReq_OSRM.json", true);;




                    try {

                        String jsonResponse = response.body();




                        JsonObject jsonObject = new Gson().fromJson(jsonResponse, JsonObject.class);

// Create a new GeoJSON object
                        JsonObject geoJson = new JsonObject();
                        geoJson.addProperty("type", "FeatureCollection");

// Create an array to hold features
                        JsonArray features = new JsonArray();

// Extract waypoints
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

// Extract routes
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

// Add features to GeoJSON object
                        geoJson.add("features", features);

                        GeoJson_to_GPX(geoJson.toString(), Regio, Route_URL_REGIO);


                        //Write geojson data to file
                        m2h2.FileWriter.FileWriter.WriteToFile(geoJson.toString(), "src/main/java/m2h2/DataFiles/Responses/PostReqGeoJSON_Filtered.geojson", true);




                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

        delayedFuture.join();


    }


    public static void GeoJson_to_GPX(String geoJSON, String Regio, String Route_URL_Regio) {
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

        JSONObject geoJsonObject = new JSONObject(geoJSON);

        try {
            FileWriter gpxWriter = new FileWriter("src/main/java/m2h2/DataFiles/GPX/" + Regio + ".gpx");
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

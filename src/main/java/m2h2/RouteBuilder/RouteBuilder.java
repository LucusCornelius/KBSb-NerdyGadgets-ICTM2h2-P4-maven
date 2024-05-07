package m2h2.RouteBuilder;




import Console_Color_Codes.ConsoleColorCodes;
import org.springframework.util.RouteMatcher;

import java.awt.*;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;




public class RouteBuilder {

   private static ArrayList<String> Routes_West = new ArrayList<>();


    public static void setRoutes_West(String Route_URL) {


       String Route_URL_SUBSTRING = "http://127.0.0.1:5000/route/v1/driving/4.898435157003786,52.34329645288008;";
        if (Route_URL.contains(Route_URL_SUBSTRING)) {
            System.out.println(ConsoleColorCodes.ANSI_GREEN + "\n URL heeft de check gepasseerd!" + ConsoleColorCodes.ANSI_RESET);
            Routes_West.add(Route_URL);
        }
    }


    public static void BuildRoutes() {

        System.out.println(ConsoleColorCodes.ANSI_YELLOW + "\n POST REQUEST wordt uitgevoerd!\n" + ConsoleColorCodes.ANSI_RESET);

        HttpClient client = HttpClient.newHttpClient();

        String jsonBody = "";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(Routes_West.get(0)))
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
                    System.out.println("Response status code: " + response.statusCode());
                    System.out.println("Response body: " + response.body());


                    try {
               String jsonResponse = "{\n" +
                       "    \"code\": \"Ok\",\n" +
                       "    \"routes\": [\n" +
                       "        {\n" +
                       "            \"geometry\": {\n" +
                       "                \"coordinates\": [\n" +
                       "                    [\n" +
                       "                        6.34892,\n" +
                       "                        52.652292\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        6.348145,\n" +
                       "                        52.651865\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        6.348074,\n" +
                       "                        52.651815\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        6.346605,\n" +
                       "                        52.652225\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        6.346445,\n" +
                       "                        52.652273\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        6.345914,\n" +
                       "                        52.652515\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        6.345779,\n" +
                       "                        52.652552\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        6.345594,\n" +
                       "                        52.652589\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        6.345557,\n" +
                       "                        52.652633\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        6.345486,\n" +
                       "                        52.652682\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        6.345414,\n" +
                       "                        52.652722\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        6.345129,\n" +
                       "                        52.652848\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        6.344492,\n" +
                       "                        52.653128\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        6.344018,\n" +
                       "                        52.653336\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        6.343574,\n" +
                       "                        52.65355\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        6.343116,\n" +
                       "                        52.653789\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        6.343933,\n" +
                       "                        52.654101\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        6.344517,\n" +
                       "                        52.654323\n" +
                       "                    ]\n" +
                       "                ],\n" +
                       "                \"type\": \"LineString\"\n" +
                       "            },\n" +
                       "            \"legs\": [\n" +
                       "                {\n" +
                       "                    \"steps\": [\n" +
                       "                        {\n" +
                       "                            \"geometry\": {\n" +
                       "                                \"coordinates\": [\n" +
                       "                                    [\n" +
                       "                                        6.34892,\n" +
                       "                                        52.652292\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        6.348145,\n" +
                       "                                        52.651865\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        6.348074,\n" +
                       "                                        52.651815\n" +
                       "                                    ]\n" +
                       "                                ],\n" +
                       "                                \"type\": \"LineString\"\n" +
                       "                            },\n" +
                       "                            \"maneuver\": {\n" +
                       "                                \"bearing_after\": 228,\n" +
                       "                                \"bearing_before\": 0,\n" +
                       "                                \"location\": [\n" +
                       "                                    6.34892,\n" +
                       "                                    52.652292\n" +
                       "                                ],\n" +
                       "                                \"modifier\": \"left\",\n" +
                       "                                \"type\": \"depart\"\n" +
                       "                            },\n" +
                       "                            \"mode\": \"driving\",\n" +
                       "                            \"driving_side\": \"right\",\n" +
                       "                            \"name\": \"Bloemberg\",\n" +
                       "                            \"intersections\": [\n" +
                       "                                {\n" +
                       "                                    \"out\": 0,\n" +
                       "                                    \"entry\": [\n" +
                       "                                        true\n" +
                       "                                    ],\n" +
                       "                                    \"bearings\": [\n" +
                       "                                        228\n" +
                       "                                    ],\n" +
                       "                                    \"location\": [\n" +
                       "                                        6.34892,\n" +
                       "                                        52.652292\n" +
                       "                                    ]\n" +
                       "                                }\n" +
                       "                            ],\n" +
                       "                            \"weight\": 38.1,\n" +
                       "                            \"duration\": 19.4,\n" +
                       "                            \"distance\": 78.1\n" +
                       "                        },\n" +
                       "                        {\n" +
                       "                            \"geometry\": {\n" +
                       "                                \"coordinates\": [\n" +
                       "                                    [\n" +
                       "                                        6.348074,\n" +
                       "                                        52.651815\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        6.346605,\n" +
                       "                                        52.652225\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        6.346445,\n" +
                       "                                        52.652273\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        6.345914,\n" +
                       "                                        52.652515\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        6.345779,\n" +
                       "                                        52.652552\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        6.345594,\n" +
                       "                                        52.652589\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        6.345557,\n" +
                       "                                        52.652633\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        6.345486,\n" +
                       "                                        52.652682\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        6.345414,\n" +
                       "                                        52.652722\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        6.345129,\n" +
                       "                                        52.652848\n" +
                       "                                    ]\n" +
                       "                                ],\n" +
                       "                                \"type\": \"LineString\"\n" +
                       "                            },\n" +
                       "                            \"maneuver\": {\n" +
                       "                                \"bearing_after\": 293,\n" +
                       "                                \"bearing_before\": 222,\n" +
                       "                                \"location\": [\n" +
                       "                                    6.348074,\n" +
                       "                                    52.651815\n" +
                       "                                ],\n" +
                       "                                \"modifier\": \"right\",\n" +
                       "                                \"type\": \"continue\"\n" +
                       "                            },\n" +
                       "                            \"mode\": \"driving\",\n" +
                       "                            \"driving_side\": \"right\",\n" +
                       "                            \"name\": \"Bloemberg\",\n" +
                       "                            \"intersections\": [\n" +
                       "                                {\n" +
                       "                                    \"out\": 2,\n" +
                       "                                    \"in\": 0,\n" +
                       "                                    \"entry\": [\n" +
                       "                                        false,\n" +
                       "                                        true,\n" +
                       "                                        true\n" +
                       "                                    ],\n" +
                       "                                    \"bearings\": [\n" +
                       "                                        45,\n" +
                       "                                        105,\n" +
                       "                                        300\n" +
                       "                                    ],\n" +
                       "                                    \"location\": [\n" +
                       "                                        6.348074,\n" +
                       "                                        52.651815\n" +
                       "                                    ]\n" +
                       "                                },\n" +
                       "                                {\n" +
                       "                                    \"out\": 2,\n" +
                       "                                    \"in\": 0,\n" +
                       "                                    \"entry\": [\n" +
                       "                                        false,\n" +
                       "                                        true,\n" +
                       "                                        true\n" +
                       "                                    ],\n" +
                       "                                    \"bearings\": [\n" +
                       "                                        105,\n" +
                       "                                        180,\n" +
                       "                                        330\n" +
                       "                                    ],\n" +
                       "                                    \"location\": [\n" +
                       "                                        6.345594,\n" +
                       "                                        52.652589\n" +
                       "                                    ]\n" +
                       "                                }\n" +
                       "                            ],\n" +
                       "                            \"weight\": 16.7,\n" +
                       "                            \"duration\": 16.7,\n" +
                       "                            \"distance\": 232.7\n" +
                       "                        },\n" +
                       "                        {\n" +
                       "                            \"geometry\": {\n" +
                       "                                \"coordinates\": [\n" +
                       "                                    [\n" +
                       "                                        6.345129,\n" +
                       "                                        52.652848\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        6.345129,\n" +
                       "                                        52.652848\n" +
                       "                                    ]\n" +
                       "                                ],\n" +
                       "                                \"type\": \"LineString\"\n" +
                       "                            },\n" +
                       "                            \"maneuver\": {\n" +
                       "                                \"bearing_after\": 0,\n" +
                       "                                \"bearing_before\": 306,\n" +
                       "                                \"location\": [\n" +
                       "                                    6.345129,\n" +
                       "                                    52.652848\n" +
                       "                                ],\n" +
                       "                                \"modifier\": \"left\",\n" +
                       "                                \"type\": \"arrive\"\n" +
                       "                            },\n" +
                       "                            \"mode\": \"driving\",\n" +
                       "                            \"driving_side\": \"right\",\n" +
                       "                            \"name\": \"Bloemberg\",\n" +
                       "                            \"intersections\": [\n" +
                       "                                {\n" +
                       "                                    \"in\": 0,\n" +
                       "                                    \"entry\": [\n" +
                       "                                        true\n" +
                       "                                    ],\n" +
                       "                                    \"bearings\": [\n" +
                       "                                        126\n" +
                       "                                    ],\n" +
                       "                                    \"location\": [\n" +
                       "                                        6.345129,\n" +
                       "                                        52.652848\n" +
                       "                                    ]\n" +
                       "                                }\n" +
                       "                            ],\n" +
                       "                            \"weight\": 0,\n" +
                       "                            \"duration\": 0,\n" +
                       "                            \"distance\": 0\n" +
                       "                        }\n" +
                       "                    ],\n" +
                       "                    \"summary\": \"Bloemberg\",\n" +
                       "                    \"weight\": 54.8,\n" +
                       "                    \"duration\": 36.1,\n" +
                       "                    \"distance\": 310.8\n" +
                       "                },\n" +
                       "                {\n" +
                       "                    \"steps\": [\n" +
                       "                        {\n" +
                       "                            \"geometry\": {\n" +
                       "                                \"coordinates\": [\n" +
                       "                                    [\n" +
                       "                                        6.345129,\n" +
                       "                                        52.652848\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        6.344492,\n" +
                       "                                        52.653128\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        6.344018,\n" +
                       "                                        52.653336\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        6.343574,\n" +
                       "                                        52.65355\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        6.343116,\n" +
                       "                                        52.653789\n" +
                       "                                    ]\n" +
                       "                                ],\n" +
                       "                                \"type\": \"LineString\"\n" +
                       "                            },\n" +
                       "                            \"maneuver\": {\n" +
                       "                                \"bearing_after\": 306,\n" +
                       "                                \"bearing_before\": 0,\n" +
                       "                                \"location\": [\n" +
                       "                                    6.345129,\n" +
                       "                                    52.652848\n" +
                       "                                ],\n" +
                       "                                \"modifier\": \"left\",\n" +
                       "                                \"type\": \"depart\"\n" +
                       "                            },\n" +
                       "                            \"mode\": \"driving\",\n" +
                       "                            \"driving_side\": \"right\",\n" +
                       "                            \"name\": \"Bloemberg\",\n" +
                       "                            \"intersections\": [\n" +
                       "                                {\n" +
                       "                                    \"out\": 0,\n" +
                       "                                    \"entry\": [\n" +
                       "                                        true\n" +
                       "                                    ],\n" +
                       "                                    \"bearings\": [\n" +
                       "                                        306\n" +
                       "                                    ],\n" +
                       "                                    \"location\": [\n" +
                       "                                        6.345129,\n" +
                       "                                        52.652848\n" +
                       "                                    ]\n" +
                       "                                }\n" +
                       "                            ],\n" +
                       "                            \"weight\": 13.8,\n" +
                       "                            \"duration\": 13.8,\n" +
                       "                            \"distance\": 171.9\n" +
                       "                        },\n" +
                       "                        {\n" +
                       "                            \"geometry\": {\n" +
                       "                                \"coordinates\": [\n" +
                       "                                    [\n" +
                       "                                        6.343116,\n" +
                       "                                        52.653789\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        6.343933,\n" +
                       "                                        52.654101\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        6.344517,\n" +
                       "                                        52.654323\n" +
                       "                                    ]\n" +
                       "                                ],\n" +
                       "                                \"type\": \"LineString\"\n" +
                       "                            },\n" +
                       "                            \"maneuver\": {\n" +
                       "                                \"bearing_after\": 57,\n" +
                       "                                \"bearing_before\": 309,\n" +
                       "                                \"location\": [\n" +
                       "                                    6.343116,\n" +
                       "                                    52.653789\n" +
                       "                                ],\n" +
                       "                                \"modifier\": \"right\",\n" +
                       "                                \"type\": \"turn\"\n" +
                       "                            },\n" +
                       "                            \"mode\": \"driving\",\n" +
                       "                            \"driving_side\": \"right\",\n" +
                       "                            \"name\": \"Stapelerveldweg\",\n" +
                       "                            \"intersections\": [\n" +
                       "                                {\n" +
                       "                                    \"out\": 0,\n" +
                       "                                    \"in\": 1,\n" +
                       "                                    \"entry\": [\n" +
                       "                                        true,\n" +
                       "                                        false,\n" +
                       "                                        true\n" +
                       "                                    ],\n" +
                       "                                    \"bearings\": [\n" +
                       "                                        60,\n" +
                       "                                        135,\n" +
                       "                                        315\n" +
                       "                                    ],\n" +
                       "                                    \"location\": [\n" +
                       "                                        6.343116,\n" +
                       "                                        52.653789\n" +
                       "                                    ]\n" +
                       "                                }\n" +
                       "                            ],\n" +
                       "                            \"weight\": 7.1,\n" +
                       "                            \"duration\": 7.1,\n" +
                       "                            \"distance\": 111.9\n" +
                       "                        },\n" +
                       "                        {\n" +
                       "                            \"geometry\": {\n" +
                       "                                \"coordinates\": [\n" +
                       "                                    [\n" +
                       "                                        6.344517,\n" +
                       "                                        52.654323\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        6.344517,\n" +
                       "                                        52.654323\n" +
                       "                                    ]\n" +
                       "                                ],\n" +
                       "                                \"type\": \"LineString\"\n" +
                       "                            },\n" +
                       "                            \"maneuver\": {\n" +
                       "                                \"bearing_after\": 0,\n" +
                       "                                \"bearing_before\": 58,\n" +
                       "                                \"location\": [\n" +
                       "                                    6.344517,\n" +
                       "                                    52.654323\n" +
                       "                                ],\n" +
                       "                                \"modifier\": \"right\",\n" +
                       "                                \"type\": \"arrive\"\n" +
                       "                            },\n" +
                       "                            \"mode\": \"driving\",\n" +
                       "                            \"driving_side\": \"right\",\n" +
                       "                            \"name\": \"Stapelerveldweg\",\n" +
                       "                            \"intersections\": [\n" +
                       "                                {\n" +
                       "                                    \"in\": 0,\n" +
                       "                                    \"entry\": [\n" +
                       "                                        true\n" +
                       "                                    ],\n" +
                       "                                    \"bearings\": [\n" +
                       "                                        238\n" +
                       "                                    ],\n" +
                       "                                    \"location\": [\n" +
                       "                                        6.344517,\n" +
                       "                                        52.654323\n" +
                       "                                    ]\n" +
                       "                                }\n" +
                       "                            ],\n" +
                       "                            \"weight\": 0,\n" +
                       "                            \"duration\": 0,\n" +
                       "                            \"distance\": 0\n" +
                       "                        }\n" +
                       "                    ],\n" +
                       "                    \"summary\": \"Bloemberg, Stapelerveldweg\",\n" +
                       "                    \"weight\": 20.9,\n" +
                       "                    \"duration\": 20.9,\n" +
                       "                    \"distance\": 283.7\n" +
                       "                }\n" +
                       "            ],\n" +
                       "            \"weight_name\": \"routability\",\n" +
                       "            \"weight\": 75.699999999,\n" +
                       "            \"duration\": 57,\n" +
                       "            \"distance\": 594.5\n" +
                       "        }\n" +
                       "    ],\n" +
                       "    \"waypoints\": [\n" +
                       "        {\n" +
                       "            \"hint\": \"ylosgNNaLIBTAQAAIwAAACMAAACYBwAA6ICNQsvs40DOMutAXIDKQ6kAAAASAAAAEgAAAMsDAAAkBgAAeOBgAARpIwNI4WAAeWgjAwEA_wL8WA1T\",\n" +
                       "            \"distance\": 20.909301424,\n" +
                       "            \"name\": \"Bloemberg\",\n" +
                       "            \"location\": [\n" +
                       "                6.34892,\n" +
                       "                52.652292\n" +
                       "            ]\n" +
                       "        },\n" +
                       "        {\n" +
                       "            \"hint\": \"jFosgI9aLIANAAAAHgAAAAsAAABDAAAA1rK-Qb6wVELn5ppBBmftQg0AAAAeAAAACwAAAEMAAAAkBgAAqdFgADBrIwNC0WAA2mojAwMAHxP8WA1T\",\n" +
                       "            \"distance\": 11.837441789,\n" +
                       "            \"name\": \"Bloemberg\",\n" +
                       "            \"location\": [\n" +
                       "                6.345129,\n" +
                       "                52.652848\n" +
                       "            ]\n" +
                       "        },\n" +
                       "        {\n" +
                       "            \"hint\": \"jlosgJRaLIAiAAAAogAAACUAAADHAQAA8Fw6Qm90VkP2hoJCk8sXRCIAAACiAAAAJQAAAMcBAAAkBgAARc9gAPNwIwP9z2AAQHAjAwEArwP8WA1T\",\n" +
                       "            \"distance\": 23.487667722,\n" +
                       "            \"name\": \"Stapelerveldweg\",\n" +
                       "            \"location\": [\n" +
                       "                6.344517,\n" +
                       "                52.654323\n" +
                       "            ]\n" +
                       "        }\n" +
                       "    ]\n" +
                       "}";

               String jsonResposneWeesp = "{\n" +
                       "    \"code\": \"Ok\",\n" +
                       "    \"routes\": [\n" +
                       "        {\n" +
                       "            \"geometry\": {\n" +
                       "                \"coordinates\": [\n" +
                       "                    [\n" +
                       "                        5.04293,\n" +
                       "                        52.318261\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        5.042905,\n" +
                       "                        52.318293\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        5.042649,\n" +
                       "                        52.318348\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        5.04258,\n" +
                       "                        52.318363\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        5.042511,\n" +
                       "                        52.318378\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        5.042575,\n" +
                       "                        52.318478\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        5.042603,\n" +
                       "                        52.318564\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        5.042669,\n" +
                       "                        52.31869\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        5.042852,\n" +
                       "                        52.319004\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        5.042763,\n" +
                       "                        52.319023\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        5.042265,\n" +
                       "                        52.319127\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        5.042128,\n" +
                       "                        52.318883\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        5.042265,\n" +
                       "                        52.319127\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        5.042763,\n" +
                       "                        52.319023\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        5.042852,\n" +
                       "                        52.319004\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        5.042831,\n" +
                       "                        52.318969\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        5.042669,\n" +
                       "                        52.31869\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        5.042603,\n" +
                       "                        52.318564\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        5.042514,\n" +
                       "                        52.318495\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        5.042487,\n" +
                       "                        52.318467\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        5.042435,\n" +
                       "                        52.318394\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        5.042511,\n" +
                       "                        52.318378\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        5.04258,\n" +
                       "                        52.318363\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        5.042649,\n" +
                       "                        52.318348\n" +
                       "                    ],\n" +
                       "                    [\n" +
                       "                        5.042905,\n" +
                       "                        52.318293\n" +
                       "                    ]\n" +
                       "                ],\n" +
                       "                \"type\": \"LineString\"\n" +
                       "            },\n" +
                       "            \"legs\": [\n" +
                       "                {\n" +
                       "                    \"steps\": [\n" +
                       "                        {\n" +
                       "                            \"geometry\": {\n" +
                       "                                \"coordinates\": [\n" +
                       "                                    [\n" +
                       "                                        5.04293,\n" +
                       "                                        52.318261\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        5.042905,\n" +
                       "                                        52.318293\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        5.042649,\n" +
                       "                                        52.318348\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        5.04258,\n" +
                       "                                        52.318363\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        5.042511,\n" +
                       "                                        52.318378\n" +
                       "                                    ]\n" +
                       "                                ],\n" +
                       "                                \"type\": \"LineString\"\n" +
                       "                            },\n" +
                       "                            \"maneuver\": {\n" +
                       "                                \"bearing_after\": 334,\n" +
                       "                                \"bearing_before\": 0,\n" +
                       "                                \"location\": [\n" +
                       "                                    5.04293,\n" +
                       "                                    52.318261\n" +
                       "                                ],\n" +
                       "                                \"modifier\": \"right\",\n" +
                       "                                \"type\": \"depart\"\n" +
                       "                            },\n" +
                       "                            \"mode\": \"driving\",\n" +
                       "                            \"driving_side\": \"right\",\n" +
                       "                            \"name\": \"Fort Diemerdamplein\",\n" +
                       "                            \"intersections\": [\n" +
                       "                                {\n" +
                       "                                    \"out\": 0,\n" +
                       "                                    \"entry\": [\n" +
                       "                                        true\n" +
                       "                                    ],\n" +
                       "                                    \"bearings\": [\n" +
                       "                                        334\n" +
                       "                                    ],\n" +
                       "                                    \"location\": [\n" +
                       "                                        5.04293,\n" +
                       "                                        52.318261\n" +
                       "                                    ]\n" +
                       "                                }\n" +
                       "                            ],\n" +
                       "                            \"weight\": 6.9,\n" +
                       "                            \"duration\": 6.9,\n" +
                       "                            \"distance\": 32.4\n" +
                       "                        },\n" +
                       "                        {\n" +
                       "                            \"geometry\": {\n" +
                       "                                \"coordinates\": [\n" +
                       "                                    [\n" +
                       "                                        5.042511,\n" +
                       "                                        52.318378\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        5.042575,\n" +
                       "                                        52.318478\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        5.042603,\n" +
                       "                                        52.318564\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        5.042669,\n" +
                       "                                        52.31869\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        5.042852,\n" +
                       "                                        52.319004\n" +
                       "                                    ]\n" +
                       "                                ],\n" +
                       "                                \"type\": \"LineString\"\n" +
                       "                            },\n" +
                       "                            \"maneuver\": {\n" +
                       "                                \"bearing_after\": 21,\n" +
                       "                                \"bearing_before\": 289,\n" +
                       "                                \"location\": [\n" +
                       "                                    5.042511,\n" +
                       "                                    52.318378\n" +
                       "                                ],\n" +
                       "                                \"modifier\": \"right\",\n" +
                       "                                \"type\": \"turn\"\n" +
                       "                            },\n" +
                       "                            \"mode\": \"driving\",\n" +
                       "                            \"driving_side\": \"right\",\n" +
                       "                            \"name\": \"Bloemendalerpoldersingel\",\n" +
                       "                            \"intersections\": [\n" +
                       "                                {\n" +
                       "                                    \"out\": 0,\n" +
                       "                                    \"in\": 1,\n" +
                       "                                    \"entry\": [\n" +
                       "                                        true,\n" +
                       "                                        false,\n" +
                       "                                        false,\n" +
                       "                                        true\n" +
                       "                                    ],\n" +
                       "                                    \"bearings\": [\n" +
                       "                                        15,\n" +
                       "                                        105,\n" +
                       "                                        195,\n" +
                       "                                        285\n" +
                       "                                    ],\n" +
                       "                                    \"location\": [\n" +
                       "                                        5.042511,\n" +
                       "                                        52.318378\n" +
                       "                                    ]\n" +
                       "                                },\n" +
                       "                                {\n" +
                       "                                    \"out\": 0,\n" +
                       "                                    \"in\": 1,\n" +
                       "                                    \"entry\": [\n" +
                       "                                        true,\n" +
                       "                                        false,\n" +
                       "                                        true\n" +
                       "                                    ],\n" +
                       "                                    \"bearings\": [\n" +
                       "                                        30,\n" +
                       "                                        195,\n" +
                       "                                        300\n" +
                       "                                    ],\n" +
                       "                                    \"location\": [\n" +
                       "                                        5.042575,\n" +
                       "                                        52.318478\n" +
                       "                                    ]\n" +
                       "                                }\n" +
                       "                            ],\n" +
                       "                            \"weight\": 16.5,\n" +
                       "                            \"duration\": 16.5,\n" +
                       "                            \"distance\": 73.5\n" +
                       "                        },\n" +
                       "                        {\n" +
                       "                            \"geometry\": {\n" +
                       "                                \"coordinates\": [\n" +
                       "                                    [\n" +
                       "                                        5.042852,\n" +
                       "                                        52.319004\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        5.042763,\n" +
                       "                                        52.319023\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        5.042265,\n" +
                       "                                        52.319127\n" +
                       "                                    ]\n" +
                       "                                ],\n" +
                       "                                \"type\": \"LineString\"\n" +
                       "                            },\n" +
                       "                            \"maneuver\": {\n" +
                       "                                \"bearing_after\": 288,\n" +
                       "                                \"bearing_before\": 18,\n" +
                       "                                \"location\": [\n" +
                       "                                    5.042852,\n" +
                       "                                    52.319004\n" +
                       "                                ],\n" +
                       "                                \"modifier\": \"left\",\n" +
                       "                                \"type\": \"turn\"\n" +
                       "                            },\n" +
                       "                            \"mode\": \"driving\",\n" +
                       "                            \"driving_side\": \"right\",\n" +
                       "                            \"name\": \"\",\n" +
                       "                            \"intersections\": [\n" +
                       "                                {\n" +
                       "                                    \"out\": 2,\n" +
                       "                                    \"in\": 1,\n" +
                       "                                    \"entry\": [\n" +
                       "                                        true,\n" +
                       "                                        false,\n" +
                       "                                        true\n" +
                       "                                    ],\n" +
                       "                                    \"bearings\": [\n" +
                       "                                        15,\n" +
                       "                                        195,\n" +
                       "                                        285\n" +
                       "                                    ],\n" +
                       "                                    \"location\": [\n" +
                       "                                        5.042852,\n" +
                       "                                        52.319004\n" +
                       "                                    ]\n" +
                       "                                }\n" +
                       "                            ],\n" +
                       "                            \"weight\": 11.7,\n" +
                       "                            \"duration\": 11.7,\n" +
                       "                            \"distance\": 42.3\n" +
                       "                        },\n" +
                       "                        {\n" +
                       "                            \"geometry\": {\n" +
                       "                                \"coordinates\": [\n" +
                       "                                    [\n" +
                       "                                        5.042265,\n" +
                       "                                        52.319127\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        5.042128,\n" +
                       "                                        52.318883\n" +
                       "                                    ]\n" +
                       "                                ],\n" +
                       "                                \"type\": \"LineString\"\n" +
                       "                            },\n" +
                       "                            \"maneuver\": {\n" +
                       "                                \"bearing_after\": 198,\n" +
                       "                                \"bearing_before\": 288,\n" +
                       "                                \"location\": [\n" +
                       "                                    5.042265,\n" +
                       "                                    52.319127\n" +
                       "                                ],\n" +
                       "                                \"modifier\": \"left\",\n" +
                       "                                \"type\": \"turn\"\n" +
                       "                            },\n" +
                       "                            \"mode\": \"driving\",\n" +
                       "                            \"driving_side\": \"right\",\n" +
                       "                            \"name\": \"\",\n" +
                       "                            \"intersections\": [\n" +
                       "                                {\n" +
                       "                                    \"out\": 2,\n" +
                       "                                    \"in\": 1,\n" +
                       "                                    \"entry\": [\n" +
                       "                                        true,\n" +
                       "                                        false,\n" +
                       "                                        true\n" +
                       "                                    ],\n" +
                       "                                    \"bearings\": [\n" +
                       "                                        15,\n" +
                       "                                        105,\n" +
                       "                                        195\n" +
                       "                                    ],\n" +
                       "                                    \"location\": [\n" +
                       "                                        5.042265,\n" +
                       "                                        52.319127\n" +
                       "                                    ]\n" +
                       "                                }\n" +
                       "                            ],\n" +
                       "                            \"weight\": 31.7,\n" +
                       "                            \"duration\": 31.7,\n" +
                       "                            \"distance\": 28.7\n" +
                       "                        },\n" +
                       "                        {\n" +
                       "                            \"geometry\": {\n" +
                       "                                \"coordinates\": [\n" +
                       "                                    [\n" +
                       "                                        5.042128,\n" +
                       "                                        52.318883\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        5.042265,\n" +
                       "                                        52.319127\n" +
                       "                                    ]\n" +
                       "                                ],\n" +
                       "                                \"type\": \"LineString\"\n" +
                       "                            },\n" +
                       "                            \"maneuver\": {\n" +
                       "                                \"bearing_after\": 18,\n" +
                       "                                \"bearing_before\": 198,\n" +
                       "                                \"location\": [\n" +
                       "                                    5.042128,\n" +
                       "                                    52.318883\n" +
                       "                                ],\n" +
                       "                                \"modifier\": \"uturn\",\n" +
                       "                                \"type\": \"continue\"\n" +
                       "                            },\n" +
                       "                            \"mode\": \"driving\",\n" +
                       "                            \"driving_side\": \"right\",\n" +
                       "                            \"name\": \"\",\n" +
                       "                            \"intersections\": [\n" +
                       "                                {\n" +
                       "                                    \"out\": 0,\n" +
                       "                                    \"in\": 0,\n" +
                       "                                    \"entry\": [\n" +
                       "                                        true\n" +
                       "                                    ],\n" +
                       "                                    \"bearings\": [\n" +
                       "                                        15\n" +
                       "                                    ],\n" +
                       "                                    \"location\": [\n" +
                       "                                        5.042128,\n" +
                       "                                        52.318883\n" +
                       "                                    ]\n" +
                       "                                }\n" +
                       "                            ],\n" +
                       "                            \"weight\": 6.3,\n" +
                       "                            \"duration\": 6.3,\n" +
                       "                            \"distance\": 28.7\n" +
                       "                        },\n" +
                       "                        {\n" +
                       "                            \"geometry\": {\n" +
                       "                                \"coordinates\": [\n" +
                       "                                    [\n" +
                       "                                        5.042265,\n" +
                       "                                        52.319127\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        5.042763,\n" +
                       "                                        52.319023\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        5.042852,\n" +
                       "                                        52.319004\n" +
                       "                                    ]\n" +
                       "                                ],\n" +
                       "                                \"type\": \"LineString\"\n" +
                       "                            },\n" +
                       "                            \"maneuver\": {\n" +
                       "                                \"bearing_after\": 108,\n" +
                       "                                \"bearing_before\": 18,\n" +
                       "                                \"location\": [\n" +
                       "                                    5.042265,\n" +
                       "                                    52.319127\n" +
                       "                                ],\n" +
                       "                                \"modifier\": \"right\",\n" +
                       "                                \"type\": \"turn\"\n" +
                       "                            },\n" +
                       "                            \"mode\": \"driving\",\n" +
                       "                            \"driving_side\": \"right\",\n" +
                       "                            \"name\": \"\",\n" +
                       "                            \"intersections\": [\n" +
                       "                                {\n" +
                       "                                    \"out\": 1,\n" +
                       "                                    \"in\": 2,\n" +
                       "                                    \"entry\": [\n" +
                       "                                        true,\n" +
                       "                                        true,\n" +
                       "                                        false\n" +
                       "                                    ],\n" +
                       "                                    \"bearings\": [\n" +
                       "                                        15,\n" +
                       "                                        105,\n" +
                       "                                        195\n" +
                       "                                    ],\n" +
                       "                                    \"location\": [\n" +
                       "                                        5.042265,\n" +
                       "                                        52.319127\n" +
                       "                                    ]\n" +
                       "                                }\n" +
                       "                            ],\n" +
                       "                            \"weight\": 8.5,\n" +
                       "                            \"duration\": 8.5,\n" +
                       "                            \"distance\": 42.3\n" +
                       "                        },\n" +
                       "                        {\n" +
                       "                            \"geometry\": {\n" +
                       "                                \"coordinates\": [\n" +
                       "                                    [\n" +
                       "                                        5.042852,\n" +
                       "                                        52.319004\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        5.042831,\n" +
                       "                                        52.318969\n" +
                       "                                    ]\n" +
                       "                                ],\n" +
                       "                                \"type\": \"LineString\"\n" +
                       "                            },\n" +
                       "                            \"maneuver\": {\n" +
                       "                                \"bearing_after\": 198,\n" +
                       "                                \"bearing_before\": 108,\n" +
                       "                                \"location\": [\n" +
                       "                                    5.042852,\n" +
                       "                                    52.319004\n" +
                       "                                ],\n" +
                       "                                \"modifier\": \"right\",\n" +
                       "                                \"type\": \"turn\"\n" +
                       "                            },\n" +
                       "                            \"mode\": \"driving\",\n" +
                       "                            \"driving_side\": \"right\",\n" +
                       "                            \"name\": \"Bloemendalerpoldersingel\",\n" +
                       "                            \"intersections\": [\n" +
                       "                                {\n" +
                       "                                    \"out\": 1,\n" +
                       "                                    \"in\": 2,\n" +
                       "                                    \"entry\": [\n" +
                       "                                        true,\n" +
                       "                                        true,\n" +
                       "                                        false\n" +
                       "                                    ],\n" +
                       "                                    \"bearings\": [\n" +
                       "                                        15,\n" +
                       "                                        195,\n" +
                       "                                        285\n" +
                       "                                    ],\n" +
                       "                                    \"location\": [\n" +
                       "                                        5.042852,\n" +
                       "                                        52.319004\n" +
                       "                                    ]\n" +
                       "                                }\n" +
                       "                            ],\n" +
                       "                            \"weight\": 0.6,\n" +
                       "                            \"duration\": 0.6,\n" +
                       "                            \"distance\": 4.1\n" +
                       "                        },\n" +
                       "                        {\n" +
                       "                            \"geometry\": {\n" +
                       "                                \"coordinates\": [\n" +
                       "                                    [\n" +
                       "                                        5.042831,\n" +
                       "                                        52.318969\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        5.042831,\n" +
                       "                                        52.318969\n" +
                       "                                    ]\n" +
                       "                                ],\n" +
                       "                                \"type\": \"LineString\"\n" +
                       "                            },\n" +
                       "                            \"maneuver\": {\n" +
                       "                                \"bearing_after\": 0,\n" +
                       "                                \"bearing_before\": 200,\n" +
                       "                                \"location\": [\n" +
                       "                                    5.042831,\n" +
                       "                                    52.318969\n" +
                       "                                ],\n" +
                       "                                \"modifier\": \"left\",\n" +
                       "                                \"type\": \"arrive\"\n" +
                       "                            },\n" +
                       "                            \"mode\": \"driving\",\n" +
                       "                            \"driving_side\": \"right\",\n" +
                       "                            \"name\": \"Bloemendalerpoldersingel\",\n" +
                       "                            \"intersections\": [\n" +
                       "                                {\n" +
                       "                                    \"in\": 0,\n" +
                       "                                    \"entry\": [\n" +
                       "                                        true\n" +
                       "                                    ],\n" +
                       "                                    \"bearings\": [\n" +
                       "                                        20\n" +
                       "                                    ],\n" +
                       "                                    \"location\": [\n" +
                       "                                        5.042831,\n" +
                       "                                        52.318969\n" +
                       "                                    ]\n" +
                       "                                }\n" +
                       "                            ],\n" +
                       "                            \"weight\": 0,\n" +
                       "                            \"duration\": 0,\n" +
                       "                            \"distance\": 0\n" +
                       "                        }\n" +
                       "                    ],\n" +
                       "                    \"summary\": \"Fort Diemerdamplein, Bloemendalerpoldersingel\",\n" +
                       "                    \"weight\": 82.2,\n" +
                       "                    \"duration\": 82.2,\n" +
                       "                    \"distance\": 252.1\n" +
                       "                },\n" +
                       "                {\n" +
                       "                    \"steps\": [\n" +
                       "                        {\n" +
                       "                            \"geometry\": {\n" +
                       "                                \"coordinates\": [\n" +
                       "                                    [\n" +
                       "                                        5.042831,\n" +
                       "                                        52.318969\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        5.042669,\n" +
                       "                                        52.31869\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        5.042603,\n" +
                       "                                        52.318564\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        5.042514,\n" +
                       "                                        52.318495\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        5.042487,\n" +
                       "                                        52.318467\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        5.042435,\n" +
                       "                                        52.318394\n" +
                       "                                    ]\n" +
                       "                                ],\n" +
                       "                                \"type\": \"LineString\"\n" +
                       "                            },\n" +
                       "                            \"maneuver\": {\n" +
                       "                                \"bearing_after\": 200,\n" +
                       "                                \"bearing_before\": 0,\n" +
                       "                                \"location\": [\n" +
                       "                                    5.042831,\n" +
                       "                                    52.318969\n" +
                       "                                ],\n" +
                       "                                \"modifier\": \"left\",\n" +
                       "                                \"type\": \"depart\"\n" +
                       "                            },\n" +
                       "                            \"mode\": \"driving\",\n" +
                       "                            \"driving_side\": \"right\",\n" +
                       "                            \"name\": \"Bloemendalerpoldersingel\",\n" +
                       "                            \"intersections\": [\n" +
                       "                                {\n" +
                       "                                    \"out\": 0,\n" +
                       "                                    \"entry\": [\n" +
                       "                                        true\n" +
                       "                                    ],\n" +
                       "                                    \"bearings\": [\n" +
                       "                                        200\n" +
                       "                                    ],\n" +
                       "                                    \"location\": [\n" +
                       "                                        5.042831,\n" +
                       "                                        52.318969\n" +
                       "                                    ]\n" +
                       "                                },\n" +
                       "                                {\n" +
                       "                                    \"out\": 2,\n" +
                       "                                    \"in\": 0,\n" +
                       "                                    \"entry\": [\n" +
                       "                                        false,\n" +
                       "                                        true,\n" +
                       "                                        true,\n" +
                       "                                        true\n" +
                       "                                    ],\n" +
                       "                                    \"bearings\": [\n" +
                       "                                        30,\n" +
                       "                                        120,\n" +
                       "                                        210,\n" +
                       "                                        285\n" +
                       "                                    ],\n" +
                       "                                    \"location\": [\n" +
                       "                                        5.042514,\n" +
                       "                                        52.318495\n" +
                       "                                    ]\n" +
                       "                                }\n" +
                       "                            ],\n" +
                       "                            \"weight\": 16.5,\n" +
                       "                            \"duration\": 16.5,\n" +
                       "                            \"distance\": 69.9\n" +
                       "                        },\n" +
                       "                        {\n" +
                       "                            \"geometry\": {\n" +
                       "                                \"coordinates\": [\n" +
                       "                                    [\n" +
                       "                                        5.042435,\n" +
                       "                                        52.318394\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        5.042511,\n" +
                       "                                        52.318378\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        5.04258,\n" +
                       "                                        52.318363\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        5.042649,\n" +
                       "                                        52.318348\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        5.042905,\n" +
                       "                                        52.318293\n" +
                       "                                    ]\n" +
                       "                                ],\n" +
                       "                                \"type\": \"LineString\"\n" +
                       "                            },\n" +
                       "                            \"maneuver\": {\n" +
                       "                                \"bearing_after\": 108,\n" +
                       "                                \"bearing_before\": 205,\n" +
                       "                                \"location\": [\n" +
                       "                                    5.042435,\n" +
                       "                                    52.318394\n" +
                       "                                ],\n" +
                       "                                \"modifier\": \"left\",\n" +
                       "                                \"type\": \"turn\"\n" +
                       "                            },\n" +
                       "                            \"mode\": \"driving\",\n" +
                       "                            \"driving_side\": \"right\",\n" +
                       "                            \"name\": \"Fort Diemerdamplein\",\n" +
                       "                            \"intersections\": [\n" +
                       "                                {\n" +
                       "                                    \"out\": 1,\n" +
                       "                                    \"in\": 0,\n" +
                       "                                    \"entry\": [\n" +
                       "                                        false,\n" +
                       "                                        true,\n" +
                       "                                        true\n" +
                       "                                    ],\n" +
                       "                                    \"bearings\": [\n" +
                       "                                        30,\n" +
                       "                                        105,\n" +
                       "                                        195\n" +
                       "                                    ],\n" +
                       "                                    \"location\": [\n" +
                       "                                        5.042435,\n" +
                       "                                        52.318394\n" +
                       "                                    ]\n" +
                       "                                },\n" +
                       "                                {\n" +
                       "                                    \"out\": 1,\n" +
                       "                                    \"in\": 3,\n" +
                       "                                    \"entry\": [\n" +
                       "                                        true,\n" +
                       "                                        true,\n" +
                       "                                        false,\n" +
                       "                                        false\n" +
                       "                                    ],\n" +
                       "                                    \"bearings\": [\n" +
                       "                                        15,\n" +
                       "                                        105,\n" +
                       "                                        195,\n" +
                       "                                        285\n" +
                       "                                    ],\n" +
                       "                                    \"location\": [\n" +
                       "                                        5.042511,\n" +
                       "                                        52.318378\n" +
                       "                                    ]\n" +
                       "                                }\n" +
                       "                            ],\n" +
                       "                            \"weight\": 5,\n" +
                       "                            \"duration\": 5,\n" +
                       "                            \"distance\": 34\n" +
                       "                        },\n" +
                       "                        {\n" +
                       "                            \"geometry\": {\n" +
                       "                                \"coordinates\": [\n" +
                       "                                    [\n" +
                       "                                        5.042905,\n" +
                       "                                        52.318293\n" +
                       "                                    ],\n" +
                       "                                    [\n" +
                       "                                        5.042905,\n" +
                       "                                        52.318293\n" +
                       "                                    ]\n" +
                       "                                ],\n" +
                       "                                \"type\": \"LineString\"\n" +
                       "                            },\n" +
                       "                            \"maneuver\": {\n" +
                       "                                \"bearing_after\": 0,\n" +
                       "                                \"bearing_before\": 109,\n" +
                       "                                \"location\": [\n" +
                       "                                    5.042905,\n" +
                       "                                    52.318293\n" +
                       "                                ],\n" +
                       "                                \"modifier\": \"left\",\n" +
                       "                                \"type\": \"arrive\"\n" +
                       "                            },\n" +
                       "                            \"mode\": \"driving\",\n" +
                       "                            \"driving_side\": \"right\",\n" +
                       "                            \"name\": \"Fort Diemerdamplein\",\n" +
                       "                            \"intersections\": [\n" +
                       "                                {\n" +
                       "                                    \"in\": 0,\n" +
                       "                                    \"entry\": [\n" +
                       "                                        true\n" +
                       "                                    ],\n" +
                       "                                    \"bearings\": [\n" +
                       "                                        289\n" +
                       "                                    ],\n" +
                       "                                    \"location\": [\n" +
                       "                                        5.042905,\n" +
                       "                                        52.318293\n" +
                       "                                    ]\n" +
                       "                                }\n" +
                       "                            ],\n" +
                       "                            \"weight\": 0,\n" +
                       "                            \"duration\": 0,\n" +
                       "                            \"distance\": 0\n" +
                       "                        }\n" +
                       "                    ],\n" +
                       "                    \"summary\": \"Bloemendalerpoldersingel, Fort Diemerdamplein\",\n" +
                       "                    \"weight\": 21.5,\n" +
                       "                    \"duration\": 21.5,\n" +
                       "                    \"distance\": 103.9\n" +
                       "                }\n" +
                       "            ],\n" +
                       "            \"weight_name\": \"routability\",\n" +
                       "            \"weight\": 103.7,\n" +
                       "            \"duration\": 103.7,\n" +
                       "            \"distance\": 356\n" +
                       "        }\n" +
                       "    ],\n" +
                       "    \"waypoints\": [\n" +
                       "        {\n" +
                       "            \"hint\": \"P24XgL1uF4AZAAAAAAAAABAAAAAwAAAAKNCFQQAAAAAwsyxBMbUBQhkAAAAAAAAAEAAAADAAAAAkBgAA8vJMADVQHgMX90wAN1EeAwEAPwD8WA1T\",\n" +
                       "            \"distance\": 77.826997481,\n" +
                       "            \"name\": \"Fort Diemerdamplein\",\n" +
                       "            \"location\": [\n" +
                       "                5.04293,\n" +
                       "                52.318261\n" +
                       "            ]\n" +
                       "        },\n" +
                       "        {\n" +
                       "            \"hint\": \"JHEXgCxxF4AGAAAAMgAAAAAAAAAWAAAACMiEQGbOA0IAAAAAGplrQQYAAAAyAAAAAAAAABYAAAAkBgAAj_JMAPlSHgNv90wA6VEeAwAAfwz8WA1T\",\n" +
                       "            \"distance\": 90.310779362,\n" +
                       "            \"name\": \"Bloemendalerpoldersingel\",\n" +
                       "            \"location\": [\n" +
                       "                5.042831,\n" +
                       "                52.318969\n" +
                       "            ]\n" +
                       "        },\n" +
                       "        {\n" +
                       "            \"hint\": \"P24XgL1uF4AGAAAAAAAAACkAAAAqAAAA7KZ8QAAAAADAKdxBhNXjQQYAAAAAAAAAKQAAACoAAAAkBgAA2fJMAFVQHgMW9UwALFEeAwIA7xT8WA1T\",\n" +
                       "            \"distance\": 45.810151885,\n" +
                       "            \"name\": \"Fort Diemerdamplein\",\n" +
                       "            \"location\": [\n" +
                       "                5.042905,\n" +
                       "                52.318293\n" +
                       "            ]\n" +
                       "        }\n" +
                       "    ]\n" +
                       "}";


                        String jsonResponseFromProject = response.body();

                            // Load the string from a file
                            String longString = new String(Files.readAllBytes(Paths.get("src/main/java/m2h2/RouteBuilder/data.json")));
//                            System.out.println(ConsoleColorCodes.ANSI_CYAN + longString + ConsoleColorCodes.ANSI_RESET);




                        JsonObject jsonObject = new Gson().fromJson(jsonResposneWeesp, JsonObject.class);

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

                        System.out.println("GEOJSON: \n\n\n\n\n" + geoJson.toString());



                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

        delayedFuture.join();


    }



}

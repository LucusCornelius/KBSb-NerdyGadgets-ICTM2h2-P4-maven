package m2h2;

import m2h2.Adressen.Adressen_GEO_Data_Filter;
//import m2h2.DataExtractor.Postcode_GEO_Data_WGS;
import m2h2.Orders.Order;
import m2h2.RouteBuilder.RouteBuilder;

import java.util.ArrayList;



public class Main {
public static void main(String[] args) {
    // Geopackage URL

    ArrayList<Order> orders = new ArrayList<>();
//
//    String url = "jdbc:sqlite:/Users/lucasvissers/IdeaProjects/KBSb-NerdyGadgets-ICTM2h2-P4-maven/src/main/java/m2h2/Nederland_Geografische_Data/bag-light.gpkg";
//
//    try (
//            //Database connectie
//            Connection connection = DriverManager.getConnection(url); Statement statement = connection.createStatement()) {
//        String sql = "SELECT openbare_ruimte_naam, postcode, woonplaats_naam, huisnummer FROM verblijfsobject WHERE verblijfsobject.woonplaats_naam LIKE 'Amsterdam' AND huisletter IS NULL LIMIT 450";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        ResultSet rs = preparedStatement.executeQuery();

    //            String sql = "SELECT openbare_ruimte_naam, postcode, woonplaats_naam, huisnummer FROM verblijfsobject WHERE verblijfsobject.postcode LIKE '7924PW' AND verblijfsobject.huisnummer > 27 AND huisletter IS NULL LIMIT 10";


//
//        int i = 0;
//
//        while (rs.next()) {
//            System.out.println(rs.getString(1) + rs.getString(2) + rs.getString(3) + Integer.parseInt(rs.getString(4)));
//            orders.add(new Order(i, "dummy", rs.getString(1), rs.getString(2), rs.getString(3), Integer.parseInt(rs.getString(4)), "iphone 12"));
//            i++;
//        }
//
//        if (i == 450) {
//            Adressen_GEO_Data AdressenObject1 = new Adressen_GEO_Data(orders);
//        }
//
//        System.out.println(orders);
//
//        RouteBuilder.BuildRoutes_Starter();
//
//    } catch (SQLException e) {
//        e.printStackTrace(System.err);


//        orders.add(new Order(2, "Rick", "Nieuwstraat", "1381BB", "Weesp", 41, "iphone 12"));
//        orders.add(new Order(1, "Lucas", "Bloemberg", "7924PW", "Veeningen", 28, "t-shirt"));
//        orders.add(new Order(3, "Emma", "Amstel", "1011PN", "Amsterdam", 1, "sneakers"));
//        orders.add(new Order(4, "Sophie", "Kerkstraat", "1017GW", "Amsterdam", 257, "rugzak"));
//        orders.add(new Order(4, "Jeff", "Europastraat", "6014CD", "Ittervoort", 6, "auto"));
//        orders.add(new Order(4, "Justin", "Markt", "6088BP", "Roggel", 16, "auto"));
//        orders.add(new Order(4, "Piet", "Schuilenburgsingel", "7604BT", "Almelo", 5, "boot"));

   int i = 0;

 orders.add(new Order(i++, "lucas", "Ambonplein", "1094PW", "Amsterdam", 59, "usb"));
 orders.add(new Order(i++, "lucas", "Minahassastraat", "1094RV", "Amsterdam", 145, "usb"));
 orders.add(new Order(i++, "lucas", "Eerste Atjehstraat", "1094KL", "Amsterdam", 2, "usb"));
// orders.add(new Order(i++, "lucas", "Reinwardtstraat", "1093LA", "Amsterdam", 344, "usb"));
// orders.add(new Order(i++, "lucas", "Eerste Van Swindenstraat", "1093XD", "Amsterdam", 44, "usb")); //deze
// orders.add(new Order(i++, "lucas", "Tweede van Swindenstraat", "1093VG", "Amsterdam", 31, "usb"));
// orders.add(new Order(i++, "lucas", "Laing's Nekstraat", "1092GX", "Amsterdam", 44, "usb"));
// orders.add(new Order(i++, "lucas", "Tweede Constantijn Huygensstraat", "1054CP", "Amsterdam", 41, "usb"));
// orders.add(new Order(i++, "lucas", "Valeriusplein", "1075BJ", "Amsterdam", 15, "usb"));
// orders.add(new Order(i++, "lucas", "Wolfert van Borsselenweg", "1181PJ", "Amstelveen", 116, "usb"));
// orders.add(new Order(i++, "lucas", "Gondel", "1186MJ", "Amstelveen", 1, "usb"));
// orders.add(new Order(i++, "lucas", "Herman Gorterhof", "1422JP", "Uithoorn", 3, "usb"));
// orders.add(new Order(i++, "lucas", "Eendracht", "1423ET", "Uithoorn", 8, "usb"));
// orders.add(new Order(i++, "lucas", "Haven Westzijde", "1426AR", "De Hoef", 4, "usb"));
// orders.add(new Order(i++, "lucas", "De Hoef Oostzijde", "1426AD", "De Hoef", 17, "usb"));
// orders.add(new Order(i++, "lucas", "Hogedijk", "2435ND", "Zevenhoven", 19, "usb"));
// orders.add(new Order(i++, "lucas", "Kousweg", "2435NK", "Zevenhoven", 9, "usb"));
// orders.add(new Order(i++, "lucas", "Donkereind", "3645TE", "Vinkeveen", 46, "usb"));
// orders.add(new Order(i++, "lucas", "Donkereind", "3645TD", "Vinkeveen", 24, "usb"));
// orders.add(new Order(i++, "lucas", "C.J. van Houtenlaan", "1381CP", "Weesp", 36, "usb"));
// orders.add(new Order(i++, "lucas", "Van Houten Industriepark", "1381MZ", "Weesp", 4, "usb"));
// orders.add(new Order(i++, "lucas", "Pr. Beatrixlaan", "1381AJ", "Weesp", 44, "usb"));
// orders.add(new Order(i++, "lucas", "Buitenveer", "1381AC", "Weesp", 69, "usb"));
// orders.add(new Order(i++, "lucas", "Pr. Beatrixlaan", "1381AG", "Weesp", 21, "usb"));
// orders.add(new Order(i++, "lucas", "Van Houten Industriepark", "1381MZ", "Weesp", 2, "usb"));
// orders.add(new Order(i++, "lucas", "Van Houten Industriepark", "1381MZ", "Weesp", 22, "usb"));
// orders.add(new Order(i++, "lucas", "C.J. van Houtenlaan", "1381CP", "Weesp", 36, "usb"));
// orders.add(new Order(i++, "lucas", "Aetsveldseweg", "1383HS", "Weesp", 3, "usb"));
// orders.add(new Order(i++, "lucas", "Lakenkopersweg", "1383CV", "Weesp", 62, "usb"));
// orders.add(new Order(i++, "lucas", "Lakenkopersweg", "1383CV", "Weesp", 96, "usb"));
// orders.add(new Order(i++, "lucas", "Chirurgijnsweg", "1383DX", "Weesp", 12, "usb"));
// orders.add(new Order(i++, "lucas", "Chirurgijnsweg", "1383DX", "Weesp", 6, "usb"));
// orders.add(new Order(i++, "lucas", "Chirurgijnsweg", "1383DW", "Weesp", 5, "usb"));
// orders.add(new Order(i++, "lucas", "Chirurgijnsweg", "1383DZ", "Weesp", 72, "usb"));
// orders.add(new Order(i++, "lucas", "Helmkruidstraat", "1121XM", "Landsmeer", 2, "usb"));
// orders.add(new Order(i++, "lucas", "Wederikstraat", "1121XH", "Landsmeer", 25, "usb"));
// orders.add(new Order(i++, "lucas", "Wederikstraat", "1121XH", "Landsmeer", 1, "usb"));
// orders.add(new Order(i++, "lucas", "Noordeinde", "1121AM", "Landsmeer", 168, "usb"));
// orders.add(new Order(i++, "lucas", "Noordeinde", "1121AM", "Landsmeer", 150, "usb"));
// orders.add(new Order(i++, "lucas", "Noordeinde", "1121AM", "Landsmeer", 144, "usb"));
// orders.add(new Order(i++, "lucas", "Noordeinde", "1121AJ", "Landsmeer", 117, "usb"));
// orders.add(new Order(i++, "lucas", "Noordeinde", "1121AC", "Landsmeer", 91, "usb"));
// orders.add(new Order(i++, "lucas", "Mercuriusweg", "1443VA", "Purmerend", 33, "usb"));
// orders.add(new Order(i++, "lucas", "Juno", "1443BN", "Purmerend", 8, "usb"));
// orders.add(new Order(i++, "lucas", "Jonkheer van Cittersplein", "1442XJ", "Purmerend", 214, "usb"));
// orders.add(new Order(i++, "lucas", "Eemstraat", "1442SG", "Purmerend", 1, "usb"));
// orders.add(new Order(i++, "lucas", "Scheldestraat", "1442SC", "Purmerend", 47, "usb"));
// orders.add(new Order(i++, "lucas", "Flevostraat", "1442PV", "Purmerend", 59, "usb"));
// orders.add(new Order(i++, "lucas", "Spuistraat", "1442PR", "Purmerend", 29, "usb"));
// orders.add(new Order(i++, "lucas", "Rivierenlaan", "1442PE", "Purmerend", 167, "usb"));
// orders.add(new Order(i++, "lucas", "Trimpad", "1443WB", "Purmerend", 14, "usb"));
// orders.add(new Order(i++, "lucas", "Heiligeweg", "1561DG", "Krommenie", 73, "usb"));
// orders.add(new Order(i++, "lucas", "Jan van Beaumontstraat", "1561VS", "Krommenie", 11, "usb"));
// orders.add(new Order(i++, "lucas", "Volwerf", "1561VP", "Krommenie", 14, "usb"));
// orders.add(new Order(i++, "lucas", "Volwerf", "1561VP", "Krommenie", 25, "usb"));
// orders.add(new Order(i++, "lucas", "Josua Gekeerstraat", "1561DW", "Krommenie", 18, "usb"));
// orders.add(new Order(i++, "lucas", "Heiligeweg", "1561DL", "Krommenie", 114, "usb"));
// orders.add(new Order(i++, "lucas", "Heiligeweg", "1561DG", "Krommenie", 89, "usb"));
// orders.add(new Order(i++, "lucas", "Heiligeweg", "1561DH", "Krommenie", 105, "usb"));
// orders.add(new Order(i++, "lucas", "Van Bloisstraat", "1561DP", "Krommenie", 14, "usb"));
// orders.add(new Order(i++, "lucas", "Deken Schmidtstraat", "1561DW", "Krommenie", 60, "usb"));
// orders.add(new Order(i++, "lucas", "Heiligeweg", "1561DM", "Krommenie", 140, "usb"));
// orders.add(new Order(i++, "lucas", "Burgemeester Waliglaan", "1561WT", "Krommenie", 19, "usb"));
// orders.add(new Order(i++, "lucas", "Burgemeester Albertiplein", "1561WJ", "Krommenie", 18, "usb"));
// orders.add(new Order(i++, "lucas", "Bilderdijkstraat", "1702AP", "Heerhugowaard", 93, "usb"));
// orders.add(new Order(i++, "lucas", "Bilderdijkstraat", "1702AP", "Heerhugowaard", 89, "usb"));
// orders.add(new Order(i++, "lucas", "Bilderdijkstraat", "1702AR", "Heerhugowaard", 22, "usb"));
// orders.add(new Order(i++, "lucas", "Bilderdijkstraat", "1702AR", "Heerhugowaard", 22, "usb"));
// orders.add(new Order(i++, "lucas", "Themislaan", "1702AV", "Heerhugowaard", 97, "usb"));
// orders.add(new Order(i++, "lucas", "Themislaan", "1702AT", "Heerhugowaard", 65, "usb"));
// orders.add(new Order(i++, "lucas", "Umbriellaan", "1702AJ", "Heerhugowaard", 9, "usb"));
// orders.add(new Order(i++, "lucas", "Winterkoning", "1722CC", "Zuid-Scharwoude", 35, "usb"));
// orders.add(new Order(i++, "lucas", "Winterkoning", "1722CA", "Zuid-Scharwoude", 1, "usb"));
// orders.add(new Order(i++, "lucas", "Winterkoning", "1722CB", "Zuid-Scharwoude", 21, "usb"));
// orders.add(new Order(i++, "lucas", "Langeweide", "1722WX", "Zuid-Scharwoude", 266, "usb"));
// orders.add(new Order(i++, "lucas", "Langeweide", "1722WX", "Zuid-Scharwoude", 260, "usb"));
// orders.add(new Order(i++, "lucas", "Langeweide", "1722WK", "Zuid-Scharwoude", 293, "usb"));
// orders.add(new Order(i++, "lucas", "Frederik Hendrikstraat", "1723KD", "Noord-Scharwoude", 35, "usb"));
//
//


 Adressen_GEO_Data_Filter AdressenObject1 = new Adressen_GEO_Data_Filter(orders);


    RouteBuilder.BuildRoutes_Starter();



//    System.out.println(orders);
//
//    RouteBuilder.BuildRoutes();
    }
}







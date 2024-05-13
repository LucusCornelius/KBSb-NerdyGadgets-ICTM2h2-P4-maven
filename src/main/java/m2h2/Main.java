package m2h2;

import m2h2.Adressen.Adressen_GEO_Data;
//import m2h2.DataExtractor.Postcode_GEO_Data_WGS;
import m2h2.Orders.Order;
import m2h2.Regios.Regios;
import m2h2.RouteBuilder.RouteBuilder;
import org.springframework.util.RouteMatcher;

import java.sql.*;
import java.util.ArrayList;


public class Main {
public static void main(String[] args) {
    // Geopackage URL

    ArrayList<Order> orders = new ArrayList<>();

    String url = "jdbc:sqlite:/Users/lucasvissers/IdeaProjects/KBSb-NerdyGadgets-ICTM2h2-P4-maven/src/main/java/m2h2/Nederland_Geografische_Data/bag-light.gpkg";

    try (
            //Database connectie
            Connection connection = DriverManager.getConnection(url); Statement statement = connection.createStatement()) {
        String sql = "SELECT openbare_ruimte_naam, postcode, woonplaats_naam, huisnummer FROM verblijfsobject WHERE verblijfsobject.woonplaats_naam LIKE 'Weesp' AND huisletter IS NULL LIMIT 10";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();

        int i = 0;

        while (rs.next()) {
            System.out.println(rs.getString(1) + rs.getString(2) + rs.getString(3) + Integer.parseInt(rs.getString(4)));
            orders.add(new Order(i, "dummy", rs.getString(1), rs.getString(2), rs.getString(3), Integer.parseInt(rs.getString(4)), "iphone 12"));
            i++;
        }

        if (i == 10) {
            System.out.println("JAA");
            Adressen_GEO_Data AdressenObject1 = new Adressen_GEO_Data(orders);
        }

        System.out.println(orders);

        RouteBuilder.BuildRoutes();

    } catch (SQLException e) {
        e.printStackTrace(System.err);


//        orders.add(new Order(2, "Rick", "Nieuwstraat", "1381BB", "Weesp", 41, "iphone 12"));
//        orders.add(new Order(1, "Lucas", "Bloemberg", "7924PW", "Veeningen", 28, "t-shirt"));
//        orders.add(new Order(3, "Emma", "Amstel", "1011PN", "Amsterdam", 1, "sneakers"));
//        orders.add(new Order(4, "Sophie", "Kerkstraat", "1017GW", "Amsterdam", 257, "rugzak"));
//        orders.add(new Order(4, "Jeff", "Europastraat", "6014CD", "Ittervoort", 6, "auto"));
//        orders.add(new Order(4, "Justin", "Markt", "6088BP", "Roggel", 16, "auto"));
//        orders.add(new Order(4, "Piet", "Schuilenburgsingel", "7604BT", "Almelo", 5, "boot"));


    }
}

}




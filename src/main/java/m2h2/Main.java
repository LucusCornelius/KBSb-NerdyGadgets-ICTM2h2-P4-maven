/* package m2h2;

import m2h2.Adressen.Adressen_GEO_Data;
import m2h2.DataExtractor.Postcode_GEO_Data_WGS;
import m2h2.Orders.Order;
import m2h2.Regios.Regios;

import java.util.ArrayList;

public class Main {
public static void main(String[] args) {
    // Geopackage URL

    ArrayList<Order> orders = new ArrayList<>();


    Order order1 = new Order(1, "Lucas", "Bloemberg", "7924PW", 28, "t-shirt");
    Order order2 = new Order(2, "Rick", "Kerhofslaan", "1033AB", 7, "megaDildo");
    Order order3 = new Order(3, "Emma", "Amsterdamsestraatweg", "1066AC", 15, "sneakers");
    Order order4 = new Order(4, "Sophie", "Van Woustraat", "1098AD", 12, "jeans");
    Order order5 = new Order(5, "Max", "Piet Heinkade", "1122AE", 20, "rugzak");
    Order order6 = new Order(6, "Anna", "Ceintuurbaan", "1155AF", 10, "hoed");

    orders.add(order1);
    orders.add(order2);
    orders.add(order3);
    orders.add(order4);
    orders.add(order5);
    orders.add(order6);

    Adressen_GEO_Data AdressenObject1 = new Adressen_GEO_Data(orders);


    Regios regios = new Regios(AdressenObject1.getOrders());
//    System.out.println(regios.getRegio_West_Postcodes());



    AdressenObject1.Filter_Coordinaten_Op_Adres(regios.getRegio_Noord_Postcodes());
////    AdressenObject1.Filter_Coordinaten_Op_Adres(regios.getRegio_Oost_Postcodes());
//    AdressenObject1.Filter_Coordinaten_Op_Adres(regios.getRegio_West_Postcodes());
////    AdressenObject1.Filter_Coordinaten_Op_Adres(regios.getRegio_Zuid_Oost_Postcodes());
////    AdressenObject1.Filter_Coordinaten_Op_Adres(regios.getRegio_Zuid_West_Postcodes());
//

    }





}

 */
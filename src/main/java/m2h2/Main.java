package m2h2;

import m2h2.Adressen.Adressen_GEO_Data;
//import m2h2.DataExtractor.Postcode_GEO_Data_WGS;
import m2h2.Orders.Order;
import m2h2.Regios.Regios;

import java.util.ArrayList;

public class Main {
public static void main(String[] args) {
    // Geopackage URL

    ArrayList<Order> orders = new ArrayList<>();


    orders.add(new Order(2, "Rick", "Nieuwstraat", "1381BB", "Weesp", 41, "iphone 12"));
    orders.add(new Order(1, "Lucas", "Bloemberg" , "7924PW", "Veeningen", 28, "t-shirt"));
    orders.add( new Order(3, "Emma", "Amstel", "1011PN", "Amsterdam", 1, "sneakers"));
    orders.add( new Order(4, "Sophie", "Kerkstraat", "1017GW", "Amsterdam", 257, "rugzak"));
    orders.add( new Order(4, "Jeff", "Europastraat", "6014CD", "Ittervoort", 6, "auto"));
    orders.add( new Order(4, "Justin", "Markt", "6088BP", "Roggel", 16, "auto"));
    orders.add( new Order(4, "Piet", "Schuilenburgsingel", "7604BT", "Almelo", 5, "boot"));




    Adressen_GEO_Data AdressenObject1 = new Adressen_GEO_Data(orders);


//    Regios regios = new Regios(AdressenObject1.getOrders());
//    System.out.println(regios.getRegio_West_Postcodes());



//    AdressenObject1.Filter_Coordinaten_Op_Adres(regios.getRegio_Noord_Postcodes());
//    AdressenObject1.Filter_Coordinaten_Op_Adres(regios.getRegio_Oost_Postcodes());
//    AdressenObject1.Filter_Coordinaten_Op_Adres(regios.getRegio_West_Postcodes());
//    AdressenObject1.Filter_Coordinaten_Op_Adres(regios.getRegio_Zuid_Oost_Postcodes());
//    AdressenObject1.Filter_Coordinaten_Op_Adres(regios.getRegio_Zuid_West_Postcodes());

    }





}


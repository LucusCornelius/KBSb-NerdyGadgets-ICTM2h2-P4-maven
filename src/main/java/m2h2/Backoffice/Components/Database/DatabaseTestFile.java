package m2h2.Backoffice.Components.Database;

import m2h2.Backoffice.Components.Bus;
import m2h2.Backoffice.Components.Koerier;
import m2h2.Backoffice.Components.OrderLine;
import m2h2.Backoffice.Components.Route;
import m2h2.Regios.Orders_Met_Coordinaten;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DatabaseTestFile {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver geladen");
        } catch (Exception e) {
            System.out.println("oepsie");
            System.out.println(e.getMessage());
        }

        DatabaseConnectie dbCon = new DatabaseConnectie();
        
        ArrayList<Orders_Met_Coordinaten> orders = new ArrayList<Orders_Met_Coordinaten>();
        Orders_Met_Coordinaten O = new Orders_Met_Coordinaten("lus", "Ambonplein", "1094PW", "Amsterdam", 59);
        OrderLine OL = new OrderLine("B", 2, "usb");
        O.addOrderline(OL);
        orders.add(O);
        O = new Orders_Met_Coordinaten("lucas", "Minahassastraat", "1094RV", "Amsterdam", 145);
        OL = new OrderLine("A", 3, "shirt");
        O.addOrderline(OL);
        orders.add(O);
        O = new Orders_Met_Coordinaten("Rick", "kerkhofslaan", "8479HH", "Oldetrijne", 7);
        OL = new OrderLine("A3", 1, "chocolade");
        O.addOrderline(OL);
        orders.add(O);


        Bus bus = new Bus("GH-75-PL", 5);
        Koerier koerier = new Koerier("Rick", 6);
        Route route = new Route(bus, "west", "", koerier, orders);



        dbCon.insertRoute(route);

    }
}

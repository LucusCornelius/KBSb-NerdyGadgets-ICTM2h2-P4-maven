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
        Orders_Met_Coordinaten O = new Orders_Met_Coordinaten(dbCon.getNewOrderID(),"lus", "Ambonplein", "1094PW", "Amsterdam", 59);
        OrderLine OL = new OrderLine(dbCon.getNewOrderLineID(),"B", 2, "usb");
        O.addOrderline(OL);
        orders.add(O);
        O = new Orders_Met_Coordinaten(dbCon.getNewOrderID(),"lucas", "Minahassastraat", "1094RV", "Amsterdam", 145);
        OL = new OrderLine(dbCon.getNewOrderLineID(),"A", 3, "shirt");
        O.addOrderline(OL);
        OL = new OrderLine(dbCon.getNewOrderLineID(),"C", 2, "bal");
        O.addOrderline(OL);
        orders.add(O);
        O = new Orders_Met_Coordinaten(dbCon.getNewOrderID(),"Rick", "kerkhofslaan", "8479HH", "Oldetrijne", 7);
        OL = new OrderLine(dbCon.getNewOrderLineID(),"A3", 1, "chocolade");
        O.addOrderline(OL);
        orders.add(O);

        Bus bus = new Bus("GH-75-PL", 3);
        Koerier koerier = new Koerier("Rick", 6);
        Route route = new Route(dbCon.getNewRouteID() ,bus, "west", "nieuw", koerier);
        for (Orders_Met_Coordinaten order : orders) {
            route.addOrder(order);
        }

        dbCon.insertRoute(route);

        DatabaseRouteImport dbRoute = new DatabaseRouteImport(dbCon);
        dbRoute.prepRoutesToday();


    }
}

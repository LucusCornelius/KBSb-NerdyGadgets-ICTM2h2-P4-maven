package m2h2.Backoffice.Components.Database;

import m2h2.Backoffice.Components.*;
import m2h2.Algoritme.Orders_Met_Coordinaten;

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



        ArrayList<Orders_Met_Coordinaten> orders = new ArrayList<>();
        int oID = dbCon.getNewOrderID();
        int oLID = dbCon.getNewOrderLineID();

        Orders_Met_Coordinaten O = new Orders_Met_Coordinaten(oID++,"lus", "Ambonplein", "1094PW", "Amsterdam", 59, "");
        OrderLine OL = new OrderLine(oLID++,"B", 2, "usb");
        O.addOrderline(OL);
        orders.add(O);

        O = new Orders_Met_Coordinaten(oID++,"lucas", "Minahassastraat", "1094RV", "Amsterdam", 145, "");
        OL = new OrderLine(oLID++,"A", 3, "shirt");
        O.addOrderline(OL);
        OL = new OrderLine(dbCon.getNewOrderLineID(),"C", 2, "bal");
        O.addOrderline(OL);
        orders.add(O);
        O = new Orders_Met_Coordinaten(oID++,"Rick", "kerkhofslaan", "8479HH", "Oldetrijne", 7, "");
        OL = new OrderLine(oLID++,"A3", 1, "chocolade");
        O.addOrderline(OL);
        orders.add(O);
        O = new Orders_Met_Coordinaten(oID++,"Rick", "kerkhofslaan", "8479HH", "Oldetrijne", 16, "");
        OL = new OrderLine(oLID++,"F", 2, "stuff");
        O.addOrderline(OL);
        orders.add(O);

         O = new Orders_Met_Coordinaten(oID++,"lucas", "Zilverhoek", "4651SP", "Steenbergen", 5, "");
         OL = new OrderLine(oLID++,"kI", 1, "Stand Mixer");
        O.addOrderline(OL);
        orders.add(O);

         O = new Orders_Met_Coordinaten(oID++,"lucas", "Sardinieweg", "1044AE", "Amsterdam", 6, "", -1);
         OL = new OrderLine(oLID++,"Wi", 9, "AirFryer");
        O.addOrderline(OL);
        orders.add(O);

         O = new Orders_Met_Coordinaten(oID++,"lucas", "Runmolenerf", "2807DT", "Gouda", 17, "", -1);
         OL = new OrderLine(oLID++,"3", 6, "Power Bank");
        O.addOrderline(OL);
        orders.add(O);

         O = new Orders_Met_Coordinaten(oID++,"lucas", "Castellumstraat", "4007MP", "Tiel", 11, "", -1);
         OL = new OrderLine(oLID++,"7", 4, "Nail Polish");
        O.addOrderline(OL);
        orders.add(O);

         O = new Orders_Met_Coordinaten(oID++,"lucas", "Prinses Beatrixlaan", "3554JG", "Utrecht", 3, "", -1);
         OL = new OrderLine(oLID++,"OW", 8, "Water Bottle");
        O.addOrderline(OL);
        orders.add(O);

         O = new Orders_Met_Coordinaten(oID++,"lucas", "Brouwerskolkweg", "2051ED", "Overveen", 5, "", -1);
         OL = new OrderLine(oLID++,"9", 2, "Waffle Maker");
        O.addOrderline(OL);
        orders.add(O);

/*
         O = new Orders_Met_Coordinaten(oID++,"lucas", "Hoge Dries", "7335AK", "Apeldoorn", 31, "", -1);
         OL = new OrderLine(oLID++,"FU", 2, "undefined");
        O.addOrderline(OL);
        orders.add(O);

         O = new Orders_Met_Coordinaten(oID++,"lucas", "Veritasweg", "6861XP", "Oosterbeek", 179, "", -1);
         OL = new OrderLine(oLID++,"n", 1, "Canvas");
        O.addOrderline(OL);
        orders.add(O);

         O = new Orders_Met_Coordinaten(oID++,"lucas", "Hendrik van Viandenstraat", "3817AA", "Amersfoort", 64, "", -1);
         OL = new OrderLine(oLID++,"s", 1, "Luggage");
        O.addOrderline(OL);
        orders.add(O);

         O = new Orders_Met_Coordinaten(oID++,"lucas", "Fontijnehof", "2921BM", "Krimpen Aan Den Ijssel", 52, "", -1);
         OL = new OrderLine(oLID++,"X", 3, "undefined");
        O.addOrderline(OL);
        orders.add(O);

         O = new Orders_Met_Coordinaten(oID++,"lucas", "Wit-Geellaan", "2718BC", "Zoetermeer", 54, "", -1);
         OL = new OrderLine(oLID++,"2", 6, "Books");
        O.addOrderline(OL);
        orders.add(O);

         O = new Orders_Met_Coordinaten(oID++,"lucas", "Sibeliuslaan", "5343BX", "Oss", 195, "", -1);
         OL = new OrderLine(oLID++,"TT", 6, "undefined");
        O.addOrderline(OL);
        orders.add(O);

         O = new Orders_Met_Coordinaten(oID++,"lucas", "Cornelis Jacobus Anthonius Koelemanstraat", "2461WD", "Ter Aar", 44, "", -1);
         OL = new OrderLine(oLID++,"wi", 6, "Puzzle");
        O.addOrderline(OL);
        orders.add(O);

         O = new Orders_Met_Coordinaten(oID++,"lucas", "Westeresweg", "7875BC", "Exloo", 39, "", -1);
         OL = new OrderLine(oLID++,"SU", 7, "Scarf");
        O.addOrderline(OL);
        orders.add(O);

         O = new Orders_Met_Coordinaten(oID++,"lucas", "Monnen Bogerd", "3343BE", "Hendrik-ido-ambacht", 104, "", -1);
         OL = new OrderLine(oLID++,"K", 6, "undefined");
        O.addOrderline(OL);
        orders.add(O);
*/


  /*      Bus bus = new Bus("GH-75-PL", 3);
        Koerier koerier = new Koerier("Rick", 6);
        Route route = new Route(dbCon.getNewRouteID() ,bus, "west", "nieuw", koerier);
*/
        for (Orders_Met_Coordinaten order : orders) {
            dbCon.insertOrder(order);
        }


        DatabaseRouteImport dbRoute = new DatabaseRouteImport(dbCon);
        dbRoute.prepRoutesToday();


    }
}

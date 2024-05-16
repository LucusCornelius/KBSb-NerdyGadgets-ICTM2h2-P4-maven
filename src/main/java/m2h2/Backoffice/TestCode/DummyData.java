package m2h2.Backoffice.TestCode;

import m2h2.Adressen.Adressen_GEO_Data_Filter;
import m2h2.Backoffice.Components.*;
import m2h2.Backoffice.Magazijn.*;
import m2h2.Regios.Orders_Met_Coordinaten;
import m2h2.RouteBuilder.RouteBuilder;

import java.util.ArrayList;

public class DummyData {


    public void setDummyData(){
        ArrayList<Orders_Met_Coordinaten> orders = new ArrayList<Orders_Met_Coordinaten>();
        Orders_Met_Coordinaten O = new Orders_Met_Coordinaten("lucas", "Ambonplein", "1094PW", "Amsterdam", 59);
        OrderLine OL = new OrderLine("B", 2, "usb");
        O.addOrderline(OL);
        orders.add(O);
        O = new Orders_Met_Coordinaten("lucas", "Minahassastraat", "1094RV", "Amsterdam", 145);
        OL = new OrderLine("A", 3, "shirt");
        O.addOrderline(OL);
        orders.add(O);
        orders.add(new Orders_Met_Coordinaten("lucas", "Eerste Atjehstraat", "1094KL", "Amsterdam", 2));
        orders.add(new Orders_Met_Coordinaten("lucas", "Reinwardtstraat", "1093LA", "Amsterdam", 344));
        orders.add(new Orders_Met_Coordinaten("lucas", "Tweede van Swindenstraat", "1093VG", "Amsterdam", 31));
        orders.add(new Orders_Met_Coordinaten("lucas", "Eerste Van Swindenstraat", "1093XD", "Amsterdam", 44));
        orders.add(new Orders_Met_Coordinaten("lucas", "Laing's Nekstraat", "1092GX", "Amsterdam", 44));
        orders.add(new Orders_Met_Coordinaten("lucas", "Tweede Constantijn Huygensstraat", "1054CP", "Amsterdam", 41));
        orders.add(new Orders_Met_Coordinaten("lucas", "Valeriusplein", "1075BJ", "Amsterdam", 15));
        orders.add(new Orders_Met_Coordinaten("lucas", "Wolfert van Borsselenweg", "1181PJ", "Amstelveen", 116));
        orders.add(new Orders_Met_Coordinaten("lucas", "Gondel", "1186MJ", "Amstelveen", 1));
        orders.add(new Orders_Met_Coordinaten("lucas", "Herman Gorterhof", "1422JP", "Uithoorn", 3));
        orders.add(new Orders_Met_Coordinaten("lucas", "Eendracht", "1423ET", "Uithoorn", 8));
        orders.add(new Orders_Met_Coordinaten("lucas", "Haven Westzijde", "1426AR", "De Hoef", 4));
        orders.add(new Orders_Met_Coordinaten("lucas", "De Hoef Oostzijde", "1426AD", "De Hoef", 17));
        orders.add(new Orders_Met_Coordinaten("lucas", "Hogedijk", "2435ND", "Zevenhoven", 19));
        orders.add(new Orders_Met_Coordinaten("lucas", "Kousweg", "2435NK", "Zevenhoven", 9));
        orders.add(new Orders_Met_Coordinaten("lucas", "Donkereind", "3645TE", "Vinkeveen", 46));
        orders.add(new Orders_Met_Coordinaten("lucas", "Donkereind", "3645TD", "Vinkeveen", 24));
        orders.add(new Orders_Met_Coordinaten("lucas", "C.J. van Houtenlaan", "1381CP", "Weesp", 36));
        orders.add(new Orders_Met_Coordinaten("lucas", "Van Houten Industriepark", "1381MZ", "Weesp", 4));
        orders.add(new Orders_Met_Coordinaten("lucas", "Pr. Beatrixlaan", "1381AJ", "Weesp", 44));
        orders.add(new Orders_Met_Coordinaten("lucas", "Buitenveer", "1381AC", "Weesp", 69));
        orders.add(new Orders_Met_Coordinaten("lucas", "Pr. Beatrixlaan", "1381AG", "Weesp", 21));
        orders.add(new Orders_Met_Coordinaten("lucas", "Van Houten Industriepark", "1381MZ", "Weesp", 2));
        orders.add(new Orders_Met_Coordinaten("lucas", "Van Houten Industriepark", "1381MZ", "Weesp", 22));
        orders.add(new Orders_Met_Coordinaten("lucas", "C.J. van Houtenlaan", "1381CP", "Weesp", 36));
        orders.add(new Orders_Met_Coordinaten("lucas", "Aetsveldseweg", "1383HS", "Weesp", 3));
        orders.add(new Orders_Met_Coordinaten("lucas", "Lakenkopersweg", "1383CV", "Weesp", 62));
        orders.add(new Orders_Met_Coordinaten("lucas", "Lakenkopersweg", "1383CV", "Weesp", 96));
        orders.add(new Orders_Met_Coordinaten("lucas", "Chirurgijnsweg", "1383DX", "Weesp", 12));
        orders.add(new Orders_Met_Coordinaten("lucas", "Chirurgijnsweg", "1383DX", "Weesp", 6));
        orders.add(new Orders_Met_Coordinaten("lucas", "Chirurgijnsweg", "1383DW", "Weesp", 5));
        orders.add(new Orders_Met_Coordinaten("lucas", "Chirurgijnsweg", "1383DZ", "Weesp", 72));
        orders.add(new Orders_Met_Coordinaten("lucas", "Helmkruidstraat", "1121XM", "Landsmeer", 2));
        orders.add(new Orders_Met_Coordinaten("lucas", "Wederikstraat", "1121XH", "Landsmeer", 25));
        orders.add(new Orders_Met_Coordinaten("lucas", "Wederikstraat", "1121XH", "Landsmeer", 1));
        orders.add(new Orders_Met_Coordinaten("lucas", "Noordeinde", "1121AM", "Landsmeer", 168));
        orders.add(new Orders_Met_Coordinaten("lucas", "Noordeinde", "1121AM", "Landsmeer", 150));
        orders.add(new Orders_Met_Coordinaten("lucas", "Noordeinde", "1121AM", "Landsmeer", 144));
        orders.add(new Orders_Met_Coordinaten("lucas", "Noordeinde", "1121AJ", "Landsmeer", 117));
        orders.add(new Orders_Met_Coordinaten("lucas", "Noordeinde", "1121AC", "Landsmeer", 91));
        orders.add(new Orders_Met_Coordinaten("lucas", "Mercuriusweg", "1443VA", "Purmerend", 33));
        orders.add(new Orders_Met_Coordinaten("lucas", "Juno", "1443BN", "Purmerend", 8));
        orders.add(new Orders_Met_Coordinaten("lucas", "Jonkheer van Cittersplein", "1442XJ", "Purmerend", 214));
        orders.add(new Orders_Met_Coordinaten("lucas", "Eemstraat", "1442SG", "Purmerend", 1));
        orders.add(new Orders_Met_Coordinaten("lucas", "Scheldestraat", "1442SC", "Purmerend", 47));
        orders.add(new Orders_Met_Coordinaten("lucas", "Flevostraat", "1442PV", "Purmerend", 59));
        orders.add(new Orders_Met_Coordinaten("lucas", "Spuistraat", "1442PR", "Purmerend", 29));
        orders.add(new Orders_Met_Coordinaten("lucas", "Rivierenlaan", "1442PE", "Purmerend", 167));
        orders.add(new Orders_Met_Coordinaten("lucas", "Trimpad", "1443WB", "Purmerend", 14));
        orders.add(new Orders_Met_Coordinaten("lucas", "Heiligeweg", "1561DG", "Krommenie", 73));
        orders.add(new Orders_Met_Coordinaten("lucas", "Jan van Beaumontstraat", "1561VS", "Krommenie", 11));
        orders.add(new Orders_Met_Coordinaten("lucas", "Volwerf", "1561VP", "Krommenie", 14));
        orders.add(new Orders_Met_Coordinaten("lucas", "Volwerf", "1561VP", "Krommenie", 25));
        orders.add(new Orders_Met_Coordinaten("lucas", "Josua Gekeerstraat", "1561DW", "Krommenie", 18));
        orders.add(new Orders_Met_Coordinaten("lucas", "Heiligeweg", "1561DL", "Krommenie", 114));
        orders.add(new Orders_Met_Coordinaten("lucas", "Heiligeweg", "1561DG", "Krommenie", 89));
        orders.add(new Orders_Met_Coordinaten("lucas", "Heiligeweg", "1561DH", "Krommenie", 105));
        orders.add(new Orders_Met_Coordinaten("lucas", "Van Bloisstraat", "1561DP", "Krommenie", 14));
        orders.add(new Orders_Met_Coordinaten("lucas", "Deken Schmidtstraat", "1561DW", "Krommenie", 60));
        orders.add(new Orders_Met_Coordinaten("lucas", "Heiligeweg", "1561DM", "Krommenie", 140));
        orders.add(new Orders_Met_Coordinaten("lucas", "Burgemeester Waliglaan", "1561WT", "Krommenie", 19));
        orders.add(new Orders_Met_Coordinaten("lucas", "Burgemeester Albertiplein", "1561WJ", "Krommenie", 18));
        orders.add(new Orders_Met_Coordinaten("lucas", "Bilderdijkstraat", "1702AP", "Heerhugowaard", 93));
        orders.add(new Orders_Met_Coordinaten("lucas", "Bilderdijkstraat", "1702AP", "Heerhugowaard", 89));
        orders.add(new Orders_Met_Coordinaten("lucas", "Bilderdijkstraat", "1702AR", "Heerhugowaard", 22));
        orders.add(new Orders_Met_Coordinaten("lucas", "Bilderdijkstraat", "1702AR", "Heerhugowaard", 22));
        orders.add(new Orders_Met_Coordinaten("lucas", "Themislaan", "1702AV", "Heerhugowaard", 97));
        orders.add(new Orders_Met_Coordinaten("lucas", "Themislaan", "1702AT", "Heerhugowaard", 65));
        orders.add(new Orders_Met_Coordinaten("lucas", "Umbriellaan", "1702AJ", "Heerhugowaard", 9));
        orders.add(new Orders_Met_Coordinaten("lucas", "Winterkoning", "1722CC", "Zuid-Scharwoude", 35));
        orders.add(new Orders_Met_Coordinaten("lucas", "Winterkoning", "1722CA", "Zuid-Scharwoude", 1));
        orders.add(new Orders_Met_Coordinaten("lucas", "Winterkoning", "1722CB", "Zuid-Scharwoude", 21));
        orders.add(new Orders_Met_Coordinaten("lucas", "Langeweide", "1722WX", "Zuid-Scharwoude", 266));
        orders.add(new Orders_Met_Coordinaten("lucas", "Langeweide", "1722WX", "Zuid-Scharwoude", 260));
        orders.add(new Orders_Met_Coordinaten("lucas", "Langeweide", "1722WK", "Zuid-Scharwoude", 293));
        orders.add(new Orders_Met_Coordinaten("lucas", "Frederik Hendrikstraat", "1723KD", "Noord-Scharwoude", 35));


        Bus bus = new Bus("GH-75-PL");
        Koerier koerier = new Koerier("Rick");
        Route route = new Route(bus, "west", "", koerier, orders);


        //Backoffice & Magazijn
        /*

        Adressen_GEO_Data_Filter AdressenObject1 = new Adressen_GEO_Data_Filter(orders);

        Koerier k1 = new Koerier("Willem");
        Bus b1 = new m2h2.Backoffice.Components.Bus("67-jh-kk");
        Route r1 = new Route(b1 , "west" , "klaar voor picken", k1);
        Order o1 = new Order("kerkhofslaan", 7, "8479HH", false);
        OrderLine ol1 = new OrderLine("A" , 2 , "USB");
        o1.addOrderline(ol1);
        OrderLine ol2 = new OrderLine("b" , 2 , "shirt");
        o1.addOrderline(ol2);
        r1.addOrder(o1);



        Bus b2 = new Bus("68-45-kk");
        Route r2 = new Route(b2 , "Oost" , "bezig met picken", k1);
        Order o21 = new Order("kerkhofslaan", 7, "8479HH", false);
        OrderLine ol21 = new OrderLine("A" , 2 , "USB");
        o21.addOrderline(ol21);
        OrderLine ol22 = new OrderLine("b" , 2 , "shirt");
        o21.addOrderline(ol22);
        r2.addOrder(o21);
        Order o22 = new Order("kfslaan", 9, "8474HH", false);
        OrderLine ol23 = new OrderLine("B" , 1 , "USB");
        o22.addOrderline(ol23);
        r2.addOrder(o22);

        //koerier DummyData
        Bus b5 = new Bus("68-45-kk");
        Route r8 = new Route("Oost" , "Aannemen order", k1);
        Order o25 = new Order("kerkhofslaan", 7, "8479HH", false);
        OrderLine ol25 = new OrderLine("A" , 2 , "USB");
        o21.addOrderline(ol25);
        OrderLine ol26 = new OrderLine("b" , 2 , "shirt");
        o21.addOrderline(ol26);
        r8.addOrder(o25);
        Order o27 = new Order("kfslaan", 9, "8474HH", false);
        OrderLine ol27 = new OrderLine("B" , 1 , "USB");
        o22.addOrderline(ol27);
        r8.addOrder(o25);

        Bus b6 = new Bus("34-67-mm");
        Route r9 = new Route(b6, "West", "Aannemen order");
        Order o28 = new Order("Stationstraat", 10, "8466KK", false);
        OrderLine ol28 = new OrderLine("C", 3, "Headphones");
        o28.addOrderline(ol28);
        r9.addOrder(o28);
        Order o29 = new Order("Hoofdweg", 12, "8499LL", false);
        OrderLine ol29 = new OrderLine("D", 2, "Mouse");
        o29.addOrderline(ol29);
        OrderLine ol30 = new OrderLine("E", 1, "Keyboard");
        o29.addOrderline(ol30);
        r9.addOrder(o29);

        Bus b7 = new Bus("12-34-pp");
        Route r10 = new Route("Noord", "Aannemen order");
        Order o30 = new Order("Dorpsstraat", 5, "8465JJ", false);
        OrderLine ol31 = new OrderLine("F", 1, "Monitor");
        o30.addOrderline(ol31);
        r10.addOrder(o30);
        Order o31 = new Order("Schoolweg", 8, "8455MM", false);
        OrderLine ol32 = new OrderLine("G", 4, "Laptop");
        o31.addOrderline(ol32);
        r10.addOrder(o31);

         */


        RouteBuilder.BuildRoutes_Starter();


        //Delivery

    }
}
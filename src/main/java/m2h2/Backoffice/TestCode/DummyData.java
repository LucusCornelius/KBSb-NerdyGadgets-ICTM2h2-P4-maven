package m2h2.Backoffice.TestCode;

import m2h2.Backoffice.Components.*;
import m2h2.Backoffice.Magazijn.*;

public class DummyData {


    public void setDummyData(){

        //Backoffice & Magazijn DummyData
        Koerier k1 = new Koerier("Willem");
        Bus b1 = new m2h2.Backoffice.Components.Bus("67-jh-kk");
        Route r1 = new Route(b1 , "west" , "klaar voor picken");
        Order o1 = new Order("kerkhofslaan", 7, "8479HH", false);
        OrderLine ol1 = new OrderLine("A" , 2 , "USB");
        o1.addOrderline(ol1);
        OrderLine ol2 = new OrderLine("b" , 2 , "shirt");
        o1.addOrderline(ol2);
        r1.addOrder(o1);

        Order o3 = new Order("kerkhofslaan", 7, "8479HH", false);
        OrderLine ol4 = new OrderLine("A" , 2 , "USB");
        o3.addOrderline(ol4);
        OrderLine ol5 = new OrderLine("b" , 2 , "shirt");
        o3.addOrderline(ol5);
        r1.addOrder(o3);
        Order o4 = new Order("kfslaan", 9, "7643HH", false);
        OrderLine ol6 = new OrderLine("B" , 1 , "USB");
        o4.addOrderline(ol6);
        r1.addOrder(o4);


        Bus b2 = new Bus("68-45-kk");
        Route r2 = new Route(b2 , "Oost" , "bezig met picken");
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
        Route r8 = new Route(b5 , "Oost" , "Aannemen order");
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
        Route r10 = new Route(b7, "Noord", "Aannemen order");
        Order o30 = new Order("Dorpsstraat", 5, "8465JJ", false);
        OrderLine ol31 = new OrderLine("F", 1, "Monitor");
        o30.addOrderline(ol31);
        r10.addOrder(o30);
        Order o31 = new Order("Schoolweg", 8, "8455MM", false);
        OrderLine ol32 = new OrderLine("G", 4, "Laptop");
        o31.addOrderline(ol32);
        r10.addOrder(o31);

        //Delivery

    }
}
package m2h2.Backoffice.TestCode;

import m2h2.Backoffice.Components.*;
import m2h2.Backoffice.Magazijn.*;


public class Main {

    public static void main(String[] args) {
        Bus b1 = new m2h2.Backoffice.Components.Bus("67-jh-kk");
        Route r1 = new Route(b1 , "noord" , "klaar voor picken");
        Order o1 = new Order("kerkhofslaan", 7, "8479HH", false);
        OrderLine ol1 = new OrderLine("A" , 2 , "USB");
        o1.addOrderline(ol1);
        OrderLine ol2 = new OrderLine("b" , 2 , "shirt");
        o1.addOrderline(ol2);
        r1.addOrder(o1);

        Bus b3 = new m2h2.Backoffice.Components.Bus("67-jh-fk");
        Route r3 = new Route(b3 , "noord" , "klaar voor picken");
        Order o3 = new Order("kerkhofslaan", 7, "8479HH", false);
        OrderLine ol4 = new OrderLine("A" , 2 , "USB");
        o3.addOrderline(ol4);
        OrderLine ol5 = new OrderLine("b" , 2 , "shirt");
        o3.addOrderline(ol5);
        r3.addOrder(o3);
        Order o4 = new Order("kfslaan", 9, "7643HH", false);
        OrderLine ol6 = new OrderLine("B" , 1 , "USB");
        o4.addOrderline(ol6);
        r3.addOrder(o4);


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
        
        MagazijnController m = new MagazijnController();
        System.out.println(m);

        MagazijnFrame frame = new MagazijnFrame(m);

    }
}

package m2h2.Backoffice.testCode;



public class Main {
    public static void main(String[] args) {
        Bus b1 = new Bus("67-jh-kk");
        Route r1 = new Route(b1 , "noord" , "klaar voor picken");
        Order o1 = new Order("kerkhofslaan", 7, "8479HH", false);
        OrderLine ol1 = new OrderLine("A" , 2 , "USB");
        o1.addOrderline(ol1);
        OrderLine ol2 = new OrderLine("b" , 2 , "shirt");
        o1.addOrderline(ol2);
        r1.addOrder(o1);
        Order o2 = new Order("kfslaan", 9, "8474HH", false);
        OrderLine ol3 = new OrderLine("B" , 1 , "USB");
        o2.addOrderline(ol3);
        r1.addOrder(o2);


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

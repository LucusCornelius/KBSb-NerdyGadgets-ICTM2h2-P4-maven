package m2h2.Backoffice.Components;

import java.util.ArrayList;


public class Route {
    private static ArrayList<Route> routes = new ArrayList<>();
    private static int IDCounter;

    public static ArrayList<Route> getRoutes(String status){
        ArrayList<Route> r = new ArrayList<>();
        for( Route route: routes){
            if (route.getStatus().equals(status)) {
                r.add(route);
            }
        }
        return r;
    }

    private int ID;
    private Bus bus;
    private String regio;
    private ArrayList<Order> orders;
    private String status;

    public Route(Bus bus ,String regio, String status){
        orders = new ArrayList<>();

        setID();
        setBus(bus);
        setRegio(regio);
        setStatus(status);

        routes.add(this);
    }
    public void setID() {
        if (ID == 0) {
            IDCounter++;
            ID = IDCounter;
        } else {
            System.out.println("## ID al gezet! ##");
        }
    }
    public int getID() {
        return ID;
    }
    public void setBus(Bus bus) {
        this.bus = bus;
    }
    public Bus getBus() {
        return bus;
    }
    public void setRegio(String regio) {
        this.regio = regio;
    }
    public String getRegio() {
        return regio;
    }
    // statussen zijn: "nieuw" , "klaar voor picken" , "bezig met picken" , "klaar voor versturen" , "bezorgd"
    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
    public void addOrder(Order order){
        orders.add(order);
    }

    @Override
    public String toString() {
        String s = (
            "route-ID: " + ID + "\n" +
            "Bus: " + bus + "\n" +
            "regio: " + regio + "\n"
            );
        if (orders.size() == 0) {
            s = s + "geen orders";
        } else {
            for(Order order: orders){
                s = s + order + "\n";
            }
        }
        return s;
    }

    public String getPostcodeRange(){
        String pr = "";
        int min = 9999;
        int max = 0;
        for(Order order:orders){
            if (order.getPostcodeNummers() != -1) {
                if (order.getPostcodeNummers() < min) {
                    min = order.getPostcodeNummers();
                }
                if (order.getPostcodeNummers() > max) {
                    max = order.getPostcodeNummers();
                }
            }
        }
        return min + " - " + max;
    }

    public int getSize(){
        return orders.size();
    }
}

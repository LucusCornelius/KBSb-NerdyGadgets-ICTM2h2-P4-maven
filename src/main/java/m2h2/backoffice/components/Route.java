package m2h2.backoffice.components;

import java.util.ArrayList;


public class Route {
    private static ArrayList<Route> routes = new ArrayList<>();
    private static int IDCounter;

    public static ArrayList<Route> getRoutes(String status) {
        ArrayList<Route> r = new ArrayList<>();
        for (Route route : routes) {
            if (route.getStatus().equals(status)) {
                r.add(route);
            }
        }
        return r;
    }

    public static ArrayList<Route> getRoutes() {
        ArrayList<Route> r = new ArrayList<>();
        ArrayList<Route> oR = new ArrayList<>();
        for (Route route : routes) {
            if (route.getStatus() != null) {
                r.add(route);
            } else {
                oR.add(route);
            }
        }
        return r;
    }

    private int ID;
    private Bus bus;
    private String regio;
    private ArrayList<Order> orders;
    private String status;
    private Koerier koerier;

    //Routes met koerier (voltooide routes)
    public Route(Bus bus, String regio, String status, Koerier koerier) {
        orders = new ArrayList<>();

        setID();
        setBus(bus);
        setRegio(regio);
        setStatus(status);
        setKoerier(koerier);

        routes.add(this);
    }

    //Route aanmaken zonder koerier (onvoltooide routes)
    public Route(Bus bus, String regio, String status) {
        orders = new ArrayList<>();

        setID();
        setBus(bus);
        setRegio(regio);
        setStatus(status);

        routes.add(this);
    }

    public Koerier getKoerier() {
        return koerier;
    }

    public void setKoerier(Koerier koerier) {
        this.koerier = koerier;
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

    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public String toString() {
        String s = (
                "route-ID: " + ID + "\n" +
                        "Bus: " + bus + "\n" +
                        "regio: " + regio + "\n" +
                        "Koerier: Geen \n"
        );
        if (koerier != null) {
            s = (
                    "route-ID: " + ID + "\n" +
                            "Bus: " + bus + "\n" +
                            "regio: " + regio + "\n" +
                            "koerier: " + koerier + "\n"
            );
        }
        if (orders.size() == 0) {
            s = s + "geen orders";
        } else {
            for (Order order : orders) {
                s = s + order + "\n";
            }
        }
        return s;
    }
}

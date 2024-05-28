package m2h2.Backoffice.Components;

import m2h2.Algoritme.Orders_Met_Coordinaten;
import m2h2.Backoffice.Components.Database.DatabaseConnectie;

import java.sql.SQLException;
import java.util.ArrayList;

public class Route {
    private static ArrayList<Route> routes = new ArrayList<>();
    private static Integer IDCounter = (Integer) 1;

    public static ArrayList<Route> getRoutes(String status) {
        ArrayList<Route> r = new ArrayList<>();
        for (Route route : routes) {
            if (route.getStatus().equals(status)) {
                r.add(route);
            }
        }
        return r;
    }
    public static Route getRoute(Integer id){
        for(Route route: routes){
            if (route.getID().equals(id)) {
                return route;
            }
        }
        return null;
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

    public static ArrayList<Koerier> getRoutesKoerier(){
        ArrayList<Koerier> r = new ArrayList<>();
        for (Route route : routes) {
            r.add(route.getKoerierObj());
        }
        return r;
    }
    //Return alle bussen
    public static ArrayList<Bus> getRoutesBus(){
        DatabaseConnectie dbcon = new DatabaseConnectie();
        ArrayList<Bus> bussen = dbcon.getBeschikbareBussen();
        try{
            dbcon.getCon().close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return bussen;
    }

    private Integer ID;
    private Bus bus;
    private String regio;
    private ArrayList<Orders_Met_Coordinaten> orders;
    private String status;
    private Koerier koerier;

    //Routes met koerier (voltooide routes)
    public Route(int ID, Bus bus, String regio, String status, Koerier koerier) {
        this.ID = ID;
        orders = new ArrayList<>();
        setKoerier(koerier);
        setBus(bus);
        setRegio(regio);
        setStatus(status);

        routes.add(this);
    }
    public Object[][] getDescriptionTableData(){
        Object[][] tableData = {{getID() , getBus() , getSize() , getPostcodeRange()}};
        return tableData;
    }

    //Route zonder koerier en bus
    public Route(String regio, String status) {
        orders = new ArrayList<>();

        setRegio(regio);
        setStatus(status);

        routes.add(this);
    }


    public String getKoerier() {
        if (this.koerier == null) {
            return "-";
        }
        return koerier.getName();
    }
    public Koerier getKoerierObj(){
        return koerier;
    }

    public void setKoerier(Koerier koerier) {
        this.koerier = koerier;
    }

    public void setID() {
        if (ID == null) {
            IDCounter++;
            ID = IDCounter;
        } else {
            System.out.println("## ID al gezet! ##");
        }
    }

    public Integer getID() {
        return ID;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public String getBus() {
        if (bus == null){
            return "-";
        }
        return bus.getKenteken();
    }
    public Bus getBusObj(){
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

    public void addOrder(Orders_Met_Coordinaten order) {
        orders.add(order);
    }
    public Integer getSize(){
        return (Integer) orders.size();
    }

    public ArrayList<Orders_Met_Coordinaten> getOrders() {
        return orders;
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

    @Override
    public String toString() {
        String s = (
                "route-ID: " + ID + "\n" +
                        "Bus: " + bus + "\n" +
                        "regio: " + regio + "\n" +
                        "Koerier: " + koerier +"\n"
        );
        if (koerier != null) {
            s = (
                    "route-ID: " + ID + "\n" +
                            "Bus: " + bus + "\n" +
                            "regio: " + regio + "\n" +
                            "koerier: " + koerier.getName() + "\n"
            );

            if (orders.isEmpty()) {

                s = s + "geen orders";
            } else {
                for (Order order : orders) {
                    s = s + order + "\n";
                }
            }
        }
        return s;
    }
}
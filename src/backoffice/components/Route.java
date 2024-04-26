import java.util.ArrayList;

public class Route {
    private static int IDCounter;
    private int ID;
    private Bus bus;
    private String regio;
    private ArrayList<Order> orders;

    public Route(Bus bus ,String regio){
        orders = new ArrayList<Order>();
        setID();
        setBus(bus);
        setRegio(regio);
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
}

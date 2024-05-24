package m2h2.Backoffice.Components;


import java.util.ArrayList;
import java.util.List;

public class Bus {
    private  int busID;
    private String kenteken;
    private static List instances = new ArrayList();

    public Bus(String kenteken){
        setKenteken(kenteken);
        instances.add(this);
    }
    public Bus getBus(){
        return this;
    }
    public static List getInstances() {
        return instances;
    }

    public Bus(String kenteken, int busID){
        this(kenteken);
        setBusID(busID);
    }

    public void setKenteken(String kenteken) {
        this.kenteken = kenteken;
    }
    public void setBusID(int busID){
        this.busID = busID;
    }
    public String getKenteken() {
        return kenteken;
    }
    public int getBusID(){
        return busID;
    }
    @Override
    public String toString() {
        return kenteken;
    }
}

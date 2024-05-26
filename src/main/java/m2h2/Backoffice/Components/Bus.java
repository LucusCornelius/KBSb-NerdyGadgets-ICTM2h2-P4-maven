package m2h2.Backoffice.Components;


import java.util.ArrayList;
import java.util.List;

public class Bus {
    private String kenteken;
    private static List instances = new ArrayList();

    public Bus(String kenteken){
        setKenteken(kenteken);
        instances.add(this);
    }

    public static List getInstances() {
        return instances;
    }

    public void setKenteken(String kenteken) {
        this.kenteken = kenteken;
    }
    public String getKenteken() {
        return kenteken;
    }
    @Override
    public String toString() {
        return kenteken;
    }
}

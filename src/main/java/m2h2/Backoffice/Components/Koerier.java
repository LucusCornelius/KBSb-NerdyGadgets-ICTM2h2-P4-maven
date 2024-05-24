package m2h2.Backoffice.Components;

import java.util.ArrayList;
import java.util.List;

public class Koerier {
    private int koerierID;
    private String name;
    private static List instances = new ArrayList();

    public Koerier(String name) {
        setName(name);
        instances.add(this);
    }

    public static List getInstances() {
        return instances;
    }
    public Koerier(String name, int koerierID) {
        this(name);
        setKoerierID(koerierID);
    }

    public String getName() {
        return name;
    }

    public int getKoerierID() {
        return koerierID;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            this.name =  "-";
        } else {
            this.name = name;
        }
    }
    public void setKoerierID(int koerierID) {
        this.koerierID = koerierID;
    }

    @Override
    public String toString() {
        return name;
    }
}
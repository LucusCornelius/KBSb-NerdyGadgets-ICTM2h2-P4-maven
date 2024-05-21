package m2h2.Backoffice.Components;

import java.util.ArrayList;
import java.util.List;

public class Koerier {
    private String name;
    private static List instances = new ArrayList();

    public Koerier(String name) {
        setName(name);
        instances.add(this);
    }

    public static List getInstances() {
        return instances;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            this.name =  "-";
        } else {
            this.name = name;
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
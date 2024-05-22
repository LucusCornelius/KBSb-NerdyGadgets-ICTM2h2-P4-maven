package m2h2.Backoffice.Components;

public class Koerier {
    private int koerierID;
    private String name;

    public Koerier(String name) {
        setName(name);
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
}
package m2h2.Backoffice.Components;

public class Koerier {
    private String name;

    public Koerier(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            return;
        } else {
            this.name = name;
        }
    }
}

package m2h2.backoffice.components;

public class Bus {
    private String kenteken;

    public Bus(String kenteken){
        setKenteken(kenteken);
    }

    public void setKenteken(String kenteken) {
        this.kenteken = kenteken;
    }
    public String getKenteken() {
        return kenteken;
    }
}

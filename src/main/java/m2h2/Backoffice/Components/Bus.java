package m2h2.Backoffice.Components;



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
    @Override
    public String toString() {
        return kenteken;
    }
}
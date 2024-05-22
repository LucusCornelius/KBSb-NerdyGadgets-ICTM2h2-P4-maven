package m2h2.Backoffice.Components;



public class Bus {
    private  int busID;
    private String kenteken;

    public Bus(String kenteken){
        setKenteken(kenteken);
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

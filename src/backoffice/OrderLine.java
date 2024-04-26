public class OrderLine {
    private static int IDCounter;
    private int ID;
    private String sectie;
    private int aantal;
    private String beschrijving;


    public OrderLine(String sectie, int aantal, String beschrijving){
        setID();
        setSectie(sectie);
        setAantal(aantal);
        setBeschrijving(beschrijving);
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
    public void setSectie(String sectie) {
        this.sectie = sectie;
    }
    public String getSectie() {
        return sectie;
    }
    public void setAantal(int aantal) {
        this.aantal = aantal;
    }
    public int getAantal() {
        return aantal;
    }
    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }
    public String getBeschrijving() {
        return beschrijving;
    }
}

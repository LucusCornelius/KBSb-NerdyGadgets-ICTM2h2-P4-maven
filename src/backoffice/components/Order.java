import java.util.ArrayList;

public class Order {
    private static int IDCounter;
    private int ID;
    private String straatnaam;
    private int huisnummer;
    private String Postcode;
    private Arraylist<OrderLine> orderLines;
    private boolean bezorgd;

    public Order(String straatnaam, int huisnummer, String postcode, boolean bezorgd){
        orderLines = new ArrayList<OrderLine>();
        setID();
        setStraatnaam(straatnaam);
        setHuisnummer(huisnummer);
        setPostcode(postcode);
        setBezorgd(bezorgd);
    }

    public void setID(int iD) {
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
    public void setStraatnaam(String straatnaam) {
        this.straatnaam = straatnaam;
    }
    public String getStraatnaam() {
        return straatnaam;
    }
    public void setHuisnummer(int huisnummer) {
        this.huisnummer = huisnummer;
    }
    public int getHuisnummer() {
        return huisnummer;
    }
    public void setPostcode(String postcode) {
        if(postcode.length() == 6) {
            this.postcode = postcode;
        } else {
            this.postcode = "0001XX";
            System.out.println("ongeldige postcode");
        }
    }
    public String getPostcode() {
        return Postcode;
    }
    public void setBezorgd(boolean bezorgd) {
        this.bezorgd = bezorgd;
    }
    public boolean getBezorgd(){
        return bezorgd;
    }
}

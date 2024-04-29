package m2h2.Regios;

public class Orders_Met_Coordinaten {

    private int orderID;

    private String naam;

    private String straatnaam;

    private String postcode;

    private String plaatsnaam;

    private int huisnummer;

    private String order;


    private String Coordinaten;


    public Orders_Met_Coordinaten (int orderID, String naam, String straatnaam, String postcode, int huisnummer, String order) {
        this.orderID = orderID;
        this.naam = naam;
        this.straatnaam = straatnaam;
        this.postcode = postcode;
        this.huisnummer = huisnummer;
        this.order = order;
    }

    public void setCoordinaten(String coordinaten) {
        Coordinaten = coordinaten;
    }

    public int getOrderID() {
        return orderID;
    }

    public String getNaam() {
        return naam;
    }

    public String getStraatnaam() {
        return straatnaam;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getPlaatsnaam() {
        return plaatsnaam;
    }

    public int getHuisnummer() {
        return huisnummer;
    }

    public String getOrder() {
        return order;
    }

    public String getCoordinaten() {
        return Coordinaten;
    }

   public String getWriteToFile() {
        return "GefilterdeAdressen: {" +
                "orderID=" + orderID +
                " naam=' " + naam + '\'' +
                ", straatnaam='" + straatnaam + '\'' +
                ", postcode='" + postcode + '\'' +
                ", huisnummer=" + huisnummer +
                ", order='" + order + '\'' +
                ", Coordinaten='" + Coordinaten + '\'' +
                '}';
   }

    @Override
    public String toString() {
        return "GefilterdeAdressen: {" +
                "orderID=" + orderID +
                " naam=' " + naam + '\'' +
                ", straatnaam='" + straatnaam + '\'' +
                ", postcode='" + postcode + '\'' +
                ", huisnummer=" + huisnummer +
                ", order='" + order + '\'' +
                ", Coordinaten='" + Coordinaten + '\'' +
                '}';
    }
}

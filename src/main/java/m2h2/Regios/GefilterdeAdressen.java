package m2h2.Regios;

public class GefilterdeAdressen {

    private int orderID;

    private String naam;

    private String straatnaam;

    private String postcode;

    private int huisnummer;

    private String order;


    private String Coordinaten;


    public GefilterdeAdressen(int orderID, String naam, String straatnaam, String postcode, int huisnummer, String order) {
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

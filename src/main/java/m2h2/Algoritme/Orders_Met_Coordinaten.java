package m2h2.Algoritme;

public class Orders_Met_Coordinaten {

    private int orderID;

    private String naam;

    private String straatnaam;

    private String postcode;

    private String plaatsnaam;

    private int huisnummer;

    String toevoeging;
    private String huisletter;
    private String order;
    private String LatitudeGraden;
    private String LongitudeGraden;
    private String LatitudeMinuten;
    private String LongitudeMinuten;
    private double Coordinaten_RijksDriehoek_X, Coordinaten_RijksDriehoek_Y;
    private double Coordinaten_DecimalDegrees_X, Coordinaten_DecimalDegrees_Y;


    public Orders_Met_Coordinaten (int orderID, String naam, String straatnaam, String postcode, int huisnummer, String toevoeging, String huisletter, String order) {
        this.orderID = orderID;
        this.naam = naam;
        this.straatnaam = straatnaam;
        this.postcode = postcode;
        this.huisnummer = huisnummer;
        this.order = order;
        this.toevoeging = toevoeging;
    }

    public void setCoordinaten_DMS(
            String LatitudeGraden,
            String LatitudeMinuten,
            String LongitudeGraden,
            String LongitudeMinuten)
    {
        this.LatitudeGraden = LatitudeGraden;
        this.LatitudeMinuten = LatitudeMinuten;
        this.LongitudeGraden = LongitudeGraden;
        this.LongitudeMinuten = LongitudeMinuten;
    }


    public void setCoordinaten_RijksDriehoek(double x, double y) {
        Coordinaten_RijksDriehoek_X = x;
        Coordinaten_RijksDriehoek_Y = y;
    }

    public void setCoordinaten_DecimalDegrees(double x, double y) {
        Coordinaten_DecimalDegrees_X = x;
        Coordinaten_DecimalDegrees_Y = y;
    }


    public String getStraatnaam() {
        return straatnaam;
    }

    public String getPostcode() {
        return postcode;
    }

    public int getHuisnummer() {
        return huisnummer;
    }

    public String getOrder() {
        return order;
    }

    public String getCoordinaten_DMS() {
        return LatitudeGraden + "° " + LatitudeMinuten + ", " + LongitudeGraden + "° " + LongitudeMinuten;
    }
    public String getCoordinaten_OSMR() {
        return Coordinaten_DecimalDegrees_Y + "," + Coordinaten_DecimalDegrees_X + ";";
    }

    public double getCoordinaten_RijksDriehoek_X() {
        return Coordinaten_RijksDriehoek_X;
    }

    public double getCoordinaten_RijksDriehoek_Y() {
        return Coordinaten_RijksDriehoek_Y;
    }


    public String getWriteToFile() {
        return "{" +
                "orderID=" + orderID +
                " naam=' " + naam + '\'' +
                ", straatnaam='" + straatnaam + '\'' +
                ", postcode='" + postcode + '\'' +
                ", huisnummer=" + huisnummer +
                ", order='" + order + '\'' +
                ", Coordinaten_DMS='" + getCoordinaten_DMS() + '\'' +
                ", Coordinaten_DECIMAL_RIJKSDRIEHOEK='" + "X= " + Coordinaten_RijksDriehoek_X + " ||| " + "Y= " + Coordinaten_RijksDriehoek_Y + '\'' +
                ", Coordinaten_DECIMAL='" + "X= " + Coordinaten_DecimalDegrees_X + " ||| " + "Y= " + Coordinaten_DecimalDegrees_Y + '\'' +
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
                ", Coordinaten_DMS='" + getCoordinaten_DMS() + '\'' +
                ", Coordinaten_DECIMAL_RIJKSDRIEHOEK='" + "X= " + Coordinaten_RijksDriehoek_X + " ||| " + "Y= " + Coordinaten_RijksDriehoek_Y + '\'' +
                ", Coordinaten_DECIMAL='" + "X= " + Coordinaten_DecimalDegrees_X + " ||| " + "Y= " + Coordinaten_DecimalDegrees_Y + '\'' +
                '}';
    }
}

package m2h2.Regios;

import m2h2.Backoffice.Components.*;

public class Orders_Met_Coordinaten extends Order {

    public Orders_Met_Coordinaten(int ID, String naam, String straatnaam, String postcode, String plaatsnaam, int huisnummer) {
        super(ID, naam, straatnaam, postcode, plaatsnaam, huisnummer);
    }

    private int orderID;

    private String naam;

    private String straatnaam;

    private String postcode;

    private String plaatsnaam;

    private int huisnummer;

    private String order;

    private String LatitudeGraden;
    private String LongitudeGraden;
    private String LatitudeMinuten;
    private String LongitudeMinuten;

    private double Coordinaten_RijksDriehoek_X, Coordinaten_RijksDriehoek_Y;

    private double Coordinaten_DecimalDegrees_X, Coordinaten_DecimalDegrees_Y;

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

    public double getCoordinaten_DecimalDegrees_X() {
        return Coordinaten_DecimalDegrees_X;
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
                "orderID=" + super.getID() +
                " naam=' " + super.getNaam() + '\'' +
                ", straatnaam='" + super.getStraatnaam() + '\'' +
                ", postcode='" + super.getPostcode() + '\'' +
                ", huisnummer=" + super.getHuisnummer() +
                ", order='" + super.getBeschrijving() + '\'' +
                ", Coordinaten_DMS='" + getCoordinaten_DMS() + '\'' +
                ", Coordinaten_DECIMAL_RIJKSDRIEHOEK='" + "X= " + Coordinaten_RijksDriehoek_X + " ||| " + "Y= " + Coordinaten_RijksDriehoek_Y + '\'' +
                ", Coordinaten_DECIMAL='" + "X= " + Coordinaten_DecimalDegrees_X + " ||| " + "Y= " + Coordinaten_DecimalDegrees_Y + '\'' +
                '}';
    }
}

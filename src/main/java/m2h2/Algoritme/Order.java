package m2h2.Algoritme;

public class Order {

    private int orderID;

    private String naam;

    private String straatnaam;

    private String postcode;

    private String plaatsnaam;

    private int huisnummer;

    private String toevoeging = null;

    private String huisletter = null;

    private String order;

    public Order(int orderID, String naam, String straatnaam, String postcode, String plaatsnaam, int huisnummer, String toevoeging, String order) {
        this.orderID = orderID;
        this.naam = naam;
        this.straatnaam = straatnaam;
        this.plaatsnaam = plaatsnaam;

        if(postcode.length() == 6) {
            this.postcode = postcode;
        } else {
            this.postcode = "0001XX";
            System.out.println("ongeldige postcode");
        }

        if(!toevoeging.isEmpty()) {
            boolean isInteger = false;
            isInteger = isInteger(toevoeging);

            if(isInteger) {
                this.toevoeging = toevoeging;
            } else {
                this.huisletter = toevoeging.toUpperCase();
            }

        } else {
            this.toevoeging = null;
        }

        this.huisnummer = huisnummer;
        this.order = order;
    }


    private boolean isInteger(String toevoeging) {
        try {
            int toevoeging_number = Integer.parseInt(toevoeging);
            System.out.println("Toevoeging is een nummer");
            return true;

        } catch (NumberFormatException e) {
            System.out.println("Toevoeging is geen nummer");
            return false;
        }
    }



    public String getPostcode() {
        return postcode;
    }

    public String getNaam() {
        return naam;
    }

    public String getStraatnaam() {
        return straatnaam;
    }

    public int getHuisnummer() {
        return huisnummer;
    }

    public String getToevoeging() {
        return toevoeging;
    }

    public String getHuisletter() {
        return huisletter;
    }

    public String getOrder() {
        return order;
    }

    public int getOrderID() {
        return orderID;
    }

    public String getPlaatsnaam() {
        return plaatsnaam;
    }

    @Override
    public String toString() {
        return "Order{" +
                ", orderID=" + orderID +
                "naam='" + naam + '\'' +
                ", straatnaam='" + straatnaam + '\'' +
                ", postcode='" + postcode + '\'' +
                ", huisnummer=" + huisnummer +
                ", huisletter=" + huisletter +
                ", toevoeging=" + toevoeging +
                ", order='" + order + '\'' +
                ", plaatsnaam='" + plaatsnaam + '\'' +
                '}';
    }
}
package m2h2.Orders;

public class Order {

    private int orderID;


    private String naam;

    private String straatnaam;

    private String postcode;
    private int huisnummer;

    private String order;

    public Order(int orderID, String naam, String straatnaam, String postcode, int huisnummer, String order) {
        this.orderID = orderID;
        this.naam = naam;
        this.straatnaam = straatnaam;

        if(postcode.length() == 6) {
            this.postcode = postcode;
        } else {
            this.postcode = "0001XX";
            System.out.println("ongeldige postcode");
        }

        this.huisnummer = huisnummer;
        this.order = order;
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

    public String getOrder() {
        return order;
    }

    public int getOrderID() {
        return orderID;
    }

    @Override
    public String toString() {
        return "Order{" +
                ", orderID=" + orderID +
                "naam='" + naam + '\'' +
                ", straatnaam='" + straatnaam + '\'' +
                ", postcode='" + postcode + '\'' +
                ", huisnummer=" + huisnummer +
                ", order='" + order + '\'' +
                '}';
    }
}
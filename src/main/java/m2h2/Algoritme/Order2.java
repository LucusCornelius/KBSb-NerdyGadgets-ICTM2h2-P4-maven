//package m2h2.Algoritme;
//
//import m2h2.Backoffice.Components.OrderLine;
//
//import java.util.ArrayList;
//
//public class Order2 {
//
//    //Algoritme
//    private int orderID;
//
//    private String naam;
//
//    private String straatnaam;
//
//    private String postcode;
//
//    private String plaatsnaam;
//
//    private int huisnummer;
//
//    private String toevoeging = null;
//
//    private String huisletter = null;
//
//    private String order;
//
//
//    //Backoffice
//    private static int IDCounter;
//    private int ID;
//    private ArrayList<OrderLine> orderLines;
//    private boolean bezorgd;
//    private boolean opVoorraad;
//
//    //Algoritme
//    public Order2(int orderID, String naam, String straatnaam, String postcode, String plaatsnaam, int huisnummer, String toevoeging, String order, Boolean bezorgd) {
//        this.orderID = orderID;
//        this.naam = naam;
//        this.straatnaam = straatnaam;
//        this.plaatsnaam = plaatsnaam;
//        setBezorgd(bezorgd);
//
//        if(postcode.length() == 6) {
//            this.postcode = postcode;
//        } else {
//            System.out.println("ongeldige postcode..., Breaking...");
//            System.exit(1);
//
//        }
//
//        if(!toevoeging.isEmpty()) {
//            boolean isInteger = false;
//            isInteger = isInteger(toevoeging);
//
//            if(isInteger) {
//                this.toevoeging = toevoeging;
//            } else {
//                this.huisletter = toevoeging.toUpperCase();
//            }
//
//        } else {
//            this.toevoeging = null;
//        }
//
//        this.huisnummer = huisnummer;
//        this.order = order;
//    }
//
//
//    private boolean isInteger(String toevoeging) {
//        try {
//            int toevoeging_number = Integer.parseInt(toevoeging);
//            System.out.println("Toevoeging is een nummer");
//            return true;
//
//        } catch (NumberFormatException e) {
//            System.out.println("Toevoeging is geen nummer");
//            return false;
//        }
//    }
//
//
//
//    public String getPostcode() {
//        return postcode;
//    }
//
//    public String getNaam() {
//        return naam;
//    }
//
//    public String getStraatnaam() {
//        return straatnaam;
//    }
//
//    public int getHuisnummer() {
//        return huisnummer;
//    }
//
//    public String getToevoeging() {
//        return toevoeging;
//    }
//
//    public String getHuisletter() {
//        return huisletter;
//    }
//
//    public String getOrder() {
//        return order;
//    }
//
//    public int getOrderID() {
//        return orderID;
//    }
//
//    public String getPlaatsnaam() {
//        return plaatsnaam;
//    }
//
//
//
//    //Backoffice
//
//
//
//    public void setID() {
//        if (ID == 0) {
//            IDCounter++;
//            ID = IDCounter;
//        } else {
//            System.out.println("## ID al gezet! ##");
//        }
//    }
//    public int getID() {
//        return ID;
//    }
//    public void setStraatnaam(String straatnaam) {
//        this.straatnaam = straatnaam;
//    }
//    public void setHuisnummer(int huisnummer) {
//        this.huisnummer = huisnummer;
//    }
//    public void setPostcode(String postcode) {
//        if(postcode.length() == 6) {
//            this.postcode = postcode;
//        } else {
//            this.postcode = "0001XX";
//            System.out.println("ongeldige postcode");
//        }
//    }
//    public String getBeschrijving(){
//        if (orderLines.size() == 1) {
//            return orderLines.get(0).getBeschrijving();
//        }
//        //meerdere toevoegen
//        return "meerdere";
//    }
//    public Object[] getDataline(){
//        return getDataline(0);
//    }
//    public Object[] getDataline(int index){
//        OrderLine product = orderLines.get(index);
//        Object[] dataline = {ID, getOpVoorraad(), product.getID(), product.getAantal(), product.getSectie(), product.getBeschrijving()};
//        return dataline;
//    }
//
//    public Boolean getOpVoorraad(){
//        if (opVoorraad){
//            return Boolean.TRUE;
//        }
//        return Boolean.FALSE;
//    }
//
//
//    public int getPostcodeNummers(){
//        String nummerString = postcode.substring(0, 4);
//        try {
//            return Integer.parseInt(nummerString);
//        } catch (NumberFormatException e) {
//            System.out.println("### verkeerde postcodeformat! - getPostcodeNummers Order ###");
//            return -1;
//        }
//    }
//    public void setBezorgd(boolean bezorgd) {
//        this.bezorgd = bezorgd;
//    }
//    public boolean getBezorgd(){
//        return bezorgd;
//    }
//    public void addOrderline(OrderLine orderline){
//        orderLines.add(orderline);
//    }
//
//    @Override
//    public String toString() {
//        return "Order{" +
//                ", orderID=" + orderID +
//                "naam='" + naam + '\'' +
//                ", straatnaam='" + straatnaam + '\'' +
//                ", postcode='" + postcode + '\'' +
//                ", huisnummer=" + huisnummer +
//                ", huisletter=" + huisletter +
//                ", toevoeging=" + toevoeging +
//                ", order='" + order + '\'' +
//                ", plaatsnaam='" + plaatsnaam + '\'' +
//                '}';
//    }
//}
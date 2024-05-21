package m2h2.Backoffice.Components;

import java.util.*;

public class Order {
    private static int IDCounter;
    private int ID;
    private String straatnaam;
    private int huisnummer;
    private String postcode;
    private ArrayList<OrderLine> orderLines;
    private boolean bezorgd;
    private boolean opVoorraad;
    private int BezorgdTeller;
    private int NietBezorgd;

    public Order(String straatnaam, int huisnummer, String postcode, boolean bezorgd){
        orderLines = new ArrayList<>();
        setID();
        setStraatnaam(straatnaam);
        setHuisnummer(huisnummer);
        setPostcode(postcode);
        setBezorgd(bezorgd);
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

    public int getPostcodeNummers(){
        String nummerString = postcode.substring(0, 4);
        try {
            return Integer.parseInt(nummerString);
        } catch (NumberFormatException e) {
            System.out.println("### verkeerde postcodeformat! - getPostcodeNummers Order ###");
            return -1;
        }
    }

    public String getPostcodeLetters(){
        String letters = postcode.substring(4,6);
        letters.matches("[A-Z]{2}");
        return letters;
    }

    public String getPostcode(){
        return getPostcodeNummers() + getPostcodeLetters();
    }


    public String getAdres() {
        return straatnaam + huisnummer;
    }

    public void setBezorgd(boolean bezorgd) {
        this.bezorgd = bezorgd;
    }
    public boolean getBezorgd(){
        if (bezorgd){
            return Boolean.TRUE;
        } else{
            return Boolean.FALSE;
        }
    }
    public void addOrderline(OrderLine orderline){
        orderLines.add(orderline);
    }

    //    public String getBeschrijving(){
//        if (orderLines.size() == 1) {
//            return orderLines.get(0).getBeschrijving();
//        }
//        //meerdere toevoegen
//        return "meerdere";
//    }
    public Object[] getDataline(){
        return getDataline(0);
    }
    public Object[] getDataline(int index){
        OrderLine product = orderLines.get(index);
        Object[] dataline = {ID, getOpVoorraad(), product.getID(), product.getAantal(), product.getSectie(), product.getBeschrijving()};
        return dataline;
    }

    public Object[] getDatalineRoute(){
        return getDatalineRoute(0);
    }

    public Object[] getDatalineRoute(int index){
        OrderLine route = orderLines.get(index);
        Object[] datalineroute = {ID, getAdres(), getPostcode(), route.getAantal(), getBezorgd()};
        return datalineroute;
    }

    public Boolean getOpVoorraad(){
        if (opVoorraad){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
    /*
    public String getSectie(){
        return orderLines.get(0).getSectie();
    }
    public Integer getProuctId(){
        return (Integer) orderLines.get(0).getID();
    }
    public Integer getProductAantal(){
        return (Integer) orderLines.get(0).getAantal();
    }
    */
    public ArrayList<OrderLine> getOrderLines(){
        return orderLines;
    }
    /*
        public String getPostcode() {
            return postcode;
        }
        */

    @Override
    public String toString() {
        String s = (
                "order-ID: " + ID + "\n" +
                        "adres: " + straatnaam + " " + huisnummer + " " + postcode + "\n"
        );
        if (orderLines.size() != 0) {
            for(OrderLine orderLine: orderLines){
                s = s + orderLine + "\n";
            }
        }
        return s;
    }
}

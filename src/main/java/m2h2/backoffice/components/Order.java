package m2h2.Backoffice.Components;

import java.util.*;

public class Order {
    private static int IDCounter;
    private int ID;
    private String naam;
    private String straatnaam;
    private int huisnummer;
    private String postcode;
    private String plaatsnaam;
    private ArrayList<OrderLine> orderLines;
    private boolean bezorgd;
    private boolean opVoorraad;

    public Order(String straatnaam, int huisnummer, String postcode, boolean bezorgd){
        orderLines = new ArrayList<>();
        setID();
        setNaam("");
        setStraatnaam(straatnaam);
        setHuisnummer(huisnummer);
        setPostcode(postcode);
        setBezorgd(bezorgd);
    }
    public Order(String naam, String straatnaam, String postcode, String plaatsnaam, int huisnummer){
        orderLines = new ArrayList<>();
        setID();
        setNaam(naam);
        setStraatnaam(straatnaam);
        setHuisnummer(huisnummer);
        setPostcode(postcode);
        setPlaatsnaam(plaatsnaam);
        setBezorgd(false);
    }
    public Order(int ID, String naam, String straatnaam, String postcode, String plaatsnaam, int huisnummer){
        orderLines = new ArrayList<>();
        this.ID = ID;
        setNaam(naam);
        setStraatnaam(straatnaam);
        setHuisnummer(huisnummer);
        setPostcode(postcode);
        setPlaatsnaam(plaatsnaam);
        setBezorgd(false);
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

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setPlaatsnaam(String plaatsnaam) {
        this.plaatsnaam = plaatsnaam;
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

    public String getNaam() {
        return naam;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getPlaatsnaam() {
        return plaatsnaam;
    }

    public String getBeschrijving(){
        if (orderLines.size() == 1) {
            return orderLines.get(0).getBeschrijving();
        }
        //meerdere toevoegen
        return "meerdere";
    }
    public Object[] getDataline(){
        return getDataline(0);
    }
    public Object[] getDataline(int index){
        OrderLine product = orderLines.get(index);
        Object[] dataline = {ID, getOpVoorraad(), product.getID(), product.getAantal(), product.getSectie(), product.getBeschrijving()};
        return dataline;
    }
    public Object[] getDatalineRoute(){
        return getDataline(0);
    }
    public Object[] getDatalineRoute(int index){
        OrderLine product = orderLines.get(index);
        Object[] dataline = {ID, getOpVoorraad(), product.getID(), product.getAantal(), product.getSectie(), product.getBeschrijving()};
        return dataline;
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
    public int getPostcodeNummers(){
        String nummerString = postcode.substring(0, 4);
        try {
            return Integer.parseInt(nummerString);
        } catch (NumberFormatException e) {
            System.out.println("### verkeerde postcodeformat! - getPostcodeNummers Order ###");
            return -1;
        }
    }
    public void setBezorgd(boolean bezorgd) {
        this.bezorgd = bezorgd;
    }
    public boolean getBezorgd(){
        return bezorgd;
    }
    public void addOrderline(OrderLine orderline){
        orderLines.add(orderline);
    }
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

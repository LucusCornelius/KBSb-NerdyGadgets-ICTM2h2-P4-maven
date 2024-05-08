package m2h2.Regios;

import m2h2.Orders.Order;

import java.util.ArrayList;

public class Regios {

    private ArrayList<Order> regio_West_Postcodes = new ArrayList<>();
    private ArrayList<Order> regio_Noord_Postcodes = new ArrayList<>();
    private ArrayList<Order> regio_Oost_Postcodes = new ArrayList<>();
    private ArrayList<Order> regio_Zuid_Oost_Postcodes = new ArrayList<>();
    private ArrayList<Order> regio_Zuid_West_Postcodes = new ArrayList<>();


    public Regios(ArrayList<Order> orders) {
        for (int i = 0; i < orders.size(); i++) {
            setPostcodeOpRegio(orders.get(i).getPostcode(), orders.get(i));
        }
    }

    public void setPostcodeOpRegio(String postcode, Order orders) {
        try {

            int postcodesInt = Integer.parseInt(postcode.substring(0, postcode.length() - 4));

            if (postcodesInt >= 10 && postcodesInt <= 41) {
                regio_West_Postcodes.add(orders);
            }

            if (postcodesInt >= 79 && postcodesInt <= 99) {
                regio_Noord_Postcodes.add(orders);
            }

            if (postcodesInt >= 66 && postcodesInt <= 77 || postcodesInt >= 80 && postcodesInt <= 83 ) {
                regio_Oost_Postcodes.add(orders);
            }

            if (postcodesInt >= 53 && postcodesInt <= 65) {
                regio_Zuid_Oost_Postcodes.add(orders);
            }

            if (postcodesInt >= 42 && postcodesInt <= 52) {
                regio_Zuid_West_Postcodes.add(orders);
            }

        } catch (Exception e) {

        }
    }


    public ArrayList<Order> getRegio_West_Postcodes() {
        return regio_West_Postcodes;
    }

    public ArrayList<Order> getRegio_Noord_Postcodes() {
        return regio_Noord_Postcodes;
    }

    public ArrayList<Order> getRegio_Oost_Postcodes() {
        return regio_Oost_Postcodes;
    }

    public ArrayList<Order> getRegio_Zuid_Oost_Postcodes() {
        return regio_Zuid_Oost_Postcodes;
    }

    public ArrayList<Order> getRegio_Zuid_West_Postcodes() {
        return regio_Zuid_West_Postcodes;
    }
}
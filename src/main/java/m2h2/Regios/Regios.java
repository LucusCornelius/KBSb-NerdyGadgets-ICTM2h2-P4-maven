package m2h2.Regios;


import m2h2.Algoritme.GFG;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class Regios {

    boolean clearFiles = false;

    String writePath = "/Users/lucasvissers/IdeaProjects/KBSb-NerdyGadgets-ICTM2h2-P4-maven/src/main/java/m2h2/sqlite_queries_outputs/";

   private ArrayList<Orders_Met_Coordinaten> regio_West_Postcodes = new ArrayList<>();
   private ArrayList<Orders_Met_Coordinaten> regio_Noord_Postcodes = new ArrayList<>();
   private ArrayList<Orders_Met_Coordinaten> regio_Oost_Postcodes = new ArrayList<>();
   private ArrayList<Orders_Met_Coordinaten> regio_Zuid_Oost_Postcodes = new ArrayList<>();
   private ArrayList<Orders_Met_Coordinaten> regio_Zuid_West_Postcodes = new ArrayList<>();


   public Regios(ArrayList<Orders_Met_Coordinaten> ordersMetCoordinaten) {
      for (int i = 0; i < ordersMetCoordinaten.size(); i++) {
         setPostcodeOpRegio(ordersMetCoordinaten.get(i).getPostcode(), ordersMetCoordinaten.get(i));
      }
   }

   public void setPostcodeOpRegio(String postcode, Orders_Met_Coordinaten orders) {
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
          System.out.println(e);
      }
   }


    public ArrayList<Orders_Met_Coordinaten> getRegio_West_Postcodes() {
        return regio_West_Postcodes;
    }

    public ArrayList<Orders_Met_Coordinaten> getRegio_Noord_Postcodes() {
        return regio_Noord_Postcodes;
    }

    public ArrayList<Orders_Met_Coordinaten> getRegio_Oost_Postcodes() {
        return regio_Oost_Postcodes;
    }

    public ArrayList<Orders_Met_Coordinaten> getRegio_Zuid_Oost_Postcodes() {
        return regio_Zuid_Oost_Postcodes;
    }

    public ArrayList<Orders_Met_Coordinaten> getRegio_Zuid_West_Postcodes() {
        return regio_Zuid_West_Postcodes;
    }


}



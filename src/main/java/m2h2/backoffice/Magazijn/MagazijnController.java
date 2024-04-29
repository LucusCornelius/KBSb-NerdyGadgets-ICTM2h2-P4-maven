package m2h2.Backoffice.Magazijn;

import java.util.*;
import javax.swing.*;

import m2h2.Backoffice.Components.*;

public class MagazijnController {
    private ArrayList<Route> klaarVoorPicken;
    private ArrayList<Route> bezigMetPicken;
    private ArrayList<Route> klaarVoorversturen;

    public MagazijnController(){
        klaarVoorPicken = Route.getRoutes("klaar voor picken");
        bezigMetPicken = Route.getRoutes("bezig met picken");
        klaarVoorversturen = Route.getRoutes("klaar voor versturen");
    }
    public ArrayList<Route> getKlaarVoorPicken() {
        return klaarVoorPicken;
    }
    public ArrayList<Route> getBezigMetPicken() {
        return bezigMetPicken;
    }
    public ArrayList<Route> getKlaarVoorversturen() {
        return klaarVoorversturen;
    }

    public JScrollPane getTable(){
        String[][] data = {};

        

        String[] columnNames = {"ID-Route" , "Bus" , "Aantal orders" , "Postcodes" , "Status"};

        JTable table = new JTable(data, columnNames);
        table.setBounds(0, 0 , 600, 400);

        JScrollPane sp = new JScrollPane(table);
        return sp;
    }


    @Override
    public String toString() {
        String s = "klaarVoorPicken : ";
        if (klaarVoorPicken.size() != 0) {
            for(Route route : klaarVoorPicken){
                s = s + route + "\n";
            }
        }
        s = s + "bezigMetPicken: ";
        if (bezigMetPicken.size() != 0) {
            for(Route route : bezigMetPicken){
                s = s + route + "\n";
            }
        }
        s = s + "klaarVoorversturen: ";
        if (klaarVoorversturen.size() != 0) {
            for(Route route : klaarVoorversturen){
                s = s + route + "\n";
            }
        }
        return s;
    }
}

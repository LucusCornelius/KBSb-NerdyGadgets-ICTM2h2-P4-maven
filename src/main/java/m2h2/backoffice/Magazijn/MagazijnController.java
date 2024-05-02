package m2h2.Backoffice.Magazijn;

import m2h2.Backoffice.Components.*;
import m2h2.Backoffice.Components.Tables.JTableButtonRenderer;

import java.util.*;
import javax.swing.*;
import javax.swing.table.*;


public class MagazijnController {
    private ArrayList<Route> klaarVoorPicken;
    private ArrayList<Route> bezigMetPicken;
    private ArrayList<Route> klaarVoorversturen;

    private String kvp = "klaar voor picken";
    private String bmp = "bezig met picken";
    private String kvv = "klaar voor versturen";

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

    public JScrollPane getTable(MagazijnController mController, String status){
        TableCellRenderer tableRenderer;
        JTable table = new JTable(new MagazijnTableModel(mController, status));
        tableRenderer = table.getDefaultRenderer(JButton.class);
        table.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));
        table.setBounds(0, 0 , 600, 400);

        JScrollPane sp = new JScrollPane(table);
        return sp;
    }

    public Object[][] getTableData(String status){
        if (status.equals(kvp)) {
            Object[][] data = new Object[klaarVoorPicken.size()][5];
            for (int i = 0; i < klaarVoorPicken.size(); i++){
                JButton tableButton = new JButton("Aannemen");
                Object[] dataline = {
                    klaarVoorPicken.get(i).getID(), 
                    klaarVoorPicken.get(i).getBus(), 
                    klaarVoorPicken.get(i).getSize(), 
                    klaarVoorPicken.get(i).getPostcodeRange(),
                    tableButton 
                };
                data[i] = dataline;
            }
            return data;
        } 
        if (status.equals(bmp)) {
            Object[][] data = new Object[bezigMetPicken.size()][5];
            for (int i = 0; i < bezigMetPicken.size(); i++){
                Object[] dataline = {
                    bezigMetPicken.get(i).getID(), 
                    bezigMetPicken.get(i).getBus(), 
                    bezigMetPicken.get(i).getSize(), 
                    bezigMetPicken.get(i).getPostcodeRange(),
                    bmp 
                };
                data[i] = dataline;
            }
            return data;      
        }
        if (status.equals(kvv)) {
            Object[][] data = new Object[klaarVoorversturen.size()][5];
            for (int i = 0; i < klaarVoorversturen.size(); i++){
                JButton tableButton = new JButton("Versturen");
                Object[] dataline = {
                    klaarVoorversturen.get(i).getID(), 
                    klaarVoorversturen.get(i).getBus(), 
                    klaarVoorversturen.get(i).getSize(), 
                    klaarVoorversturen.get(i).getPostcodeRange(),
                    kvv 
                };
                data[i] = dataline;
            }
            return data;         
        } 
        System.out.println("### geen correcte status - getTableData MagazijnController ###");
        return null;
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

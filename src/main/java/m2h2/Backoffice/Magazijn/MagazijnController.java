package m2h2.Backoffice.Magazijn;

import m2h2.Backoffice.Components.*;
import m2h2.Backoffice.Components.Database.DatabaseConnectie;
import m2h2.Backoffice.Components.Tables.JTableButtonMouseListener;
import m2h2.Backoffice.Components.Tables.JTableButtonRenderer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class MagazijnController {
    private JPanel mainPanel;

    private ArrayList<Route> klaarVoorPicken;
    private ArrayList<Route> bezigMetPicken;
    private ArrayList<Route> klaarVoorversturen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel kvpLabel;
    private javax.swing.JLabel bmpLabel;
    private javax.swing.JLabel kvvLabel;
    private String kvp = "klaar voor picken";
    private String bmp = "bezig met picken";
    private String kvv = "klaar voor versturen";
//    private JLabel magazijnLabel = new JLabel("Magazijn");
//    private JLabel kvpLabel = new JLabel("klaar voor picken");
//    private JLabel bmpLabel = new JLabel("bezig met picken");
//    private JLabel kvvLabel = new JLabel("klaar voor versturen");

    private void initComponents() {
        jLabel1 = new JLabel();
        kvpLabel = new JLabel();
        bmpLabel = new JLabel();
        kvvLabel = new JLabel();
    }

    public MagazijnController(JPanel mainPanel){
        initComponents();
        this.mainPanel = mainPanel;
        updateStatus();
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
    public void updateStatus(){
        klaarVoorPicken = Route.getRoutes("klaar voor picken");
        bezigMetPicken = Route.getRoutes("bezig met picken");
        klaarVoorversturen = Route.getRoutes("klaar voor versturen");
    }

    public JScrollPane getTable(MagazijnController mController, String status){
        TableCellRenderer tableRenderer;
        JTable table = new JTable(new MagazijnTableModel(getTableData(status)));
        tableRenderer = table.getDefaultRenderer(JButton.class);
        table.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));
        table.setBounds(0, 0 , 600, 400);
        table.setRowHeight(table.getRowHeight()+10);

        table.addMouseListener(new JTableButtonMouseListener(table));

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0,0,600,200);
        return sp;
    }

    public Object[][] getTableData(String status){
        if (status.equals(kvp)) {
            Object[][] data = new Object[Route.getRoutes().size()][5];
            for (int i = 0; i < klaarVoorPicken.size(); i++){
                JButton tableButton = new JButton("bekijk route");

                tableButton.setActionCommand(i+"");
                tableButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("klik!");
                        int id;
                        try{
                            id = Integer.parseInt(e.getActionCommand());
                        } catch (NumberFormatException ex){
                            System.out.println("### hele gekke dingen - buttonAction getTableDate MagazijnController ###");
                            id = -1;
                        }
                        MagazijnRouteController mRouteController = new MagazijnRouteController(klaarVoorPicken.get(id).getID(), mainPanel);
                        klaarVoorPicken.get(id).setStatus(bmp);
                        DatabaseConnectie dbcon = new DatabaseConnectie();
                        dbcon.updateStatus(klaarVoorPicken.get(id).getID(), bmp);
                        try {
                            dbcon.getCon().close();
                        } catch (SQLException ex){
                            System.out.println(ex.getMessage());
                        }
                    }
                });

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
                JButton tableButton = new JButton("bekijk route");
                tableButton.setActionCommand(i+"");
                tableButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("klik!");
                        int id;
                        try{
                            id = Integer.parseInt(e.getActionCommand());
                        } catch (NumberFormatException ex){
                            System.out.println("### hele gekke dingen - buttonAction getTableDate MagazijnController ###");
                            id = -1;
                        }
                        MagazijnRouteController mRouteController = new MagazijnRouteController(bezigMetPicken.get(id).getID(), mainPanel);
                    }
                });
                Object[] dataline = {
                    bezigMetPicken.get(i).getID(), 
                    bezigMetPicken.get(i).getBus(), 
                    bezigMetPicken.get(i).getSize(), 
                    bezigMetPicken.get(i).getPostcodeRange(),
                    tableButton
                };
                data[i] = dataline;
            }
            return data;      
        }
        if (status.equals(kvv)) {
            Object[][] data = new Object[klaarVoorversturen.size()][5];
            for (int i = 0; i < klaarVoorversturen.size(); i++){
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
        Object[][] data = new Object[1][5];
        Object[] dataline = {"-" , "-" , "-" , "-" , "-"};
        data[1] = dataline;
        return data;
    }

    public void setMagazijnPanel() {
        updateStatus();
        mainPanel.setLayout(new GridLayout(7, 1));

        jLabel1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 24));
        jLabel1.setForeground(new Color(51, 51, 51));
        jLabel1.setText("Magazijn");

        mainPanel.setForeground(new Color(51, 51, 51));
        mainPanel.add(jLabel1);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 20));

        kvpLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
        kvpLabel.setForeground(new Color(51, 51, 51));
        kvpLabel.setText("Klaar voor picken");

        bmpLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
        bmpLabel.setForeground(new Color(51, 51, 51));
        bmpLabel.setText("Bezig met picken");

        kvvLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
        kvvLabel.setForeground(new Color(51, 51, 51));
        kvvLabel.setText("Klaar voor versturen");

        mainPanel.add(kvpLabel);
        mainPanel.add(getTable(this, kvp));

        mainPanel.add(bmpLabel);
        mainPanel.add(getTable(this, bmp));

        mainPanel.add(kvvLabel);
        mainPanel.add(getTable(this, kvv));
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

package m2h2.Backoffice.Overzicht;

import m2h2.Backoffice.Components.Bus;
import m2h2.Backoffice.Components.Database.DatabaseConnectie;
import m2h2.Backoffice.Components.Koerier;
import m2h2.Backoffice.Components.Route;
import m2h2.Backoffice.Components.Tables.JTableButtonMouseListener;
import m2h2.Backoffice.Components.Tables.JTableButtonRenderer;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OverzichtRouteController {
    private JPanel mainPanel;
    private Route route;
    private Integer id;
    private JLabel overzichtLabel;
    private Koerier selectedKoerier;
    private Bus selectedBus;

    public OverzichtRouteController(Route nVoltooideRoute, JPanel mainPanel){
        this.mainPanel = mainPanel;
        this.route = nVoltooideRoute;

        setOverzichtRoutePanel();
    }

    /******
     *
     * Scherm item toevoegen
     *
     */
    public void setOverzichtRoutePanel() {
        mainPanel.removeAll();
        mainPanel.setLayout(new GridLayout(8,1));

        JLabel Titel = new JLabel("Niet volledige routes");
        Titel.setFont(new Font("Segoe UI Semibold", 1, 20));
        mainPanel.add(Titel);

        JScrollPane sp = getTable();
        mainPanel.add(sp);

        selectedKoerier = this.route.getKoerierObj();
        selectedBus = this.route.getBusObj();

        if (selectedKoerier == null){
            JLabel koerierL = new JLabel("Selecteer koerier");
            koerierL.setFont(new Font("Segoe UI Semibold", 1, 20));
            mainPanel.add(koerierL);

            JComboBox jcbK = getKoerierDropdown();
            mainPanel.add(jcbK);

            selectedKoerier = (Koerier) jcbK.getSelectedItem();
            jcbK.addItemListener( new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        selectedKoerier = (Koerier) e.getItem();
                    }
                }
            });
        }

        if (selectedBus == null) {
            JLabel busL = new JLabel("Selecteer bus");
            busL.setFont(new Font("Segoe UI Semibold", 1, 20));
            mainPanel.add(busL);

            JComboBox jcbB = getBusDropdown();
            mainPanel.add(jcbB);

            selectedBus = (Bus) jcbB.getSelectedItem();
            jcbB.addItemListener( new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    selectedBus = (Bus) e.getItem();
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        selectedBus = (Bus) e.getItem();
                    }
                }
            });
                    }

        JButton terug = terugKnop();
        mainPanel.add(terug);

        JButton jbDoorstuur = doorstuurKnop();
        mainPanel.add(jbDoorstuur);

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    /*
    Tabel met data van route erin
     */

    public JScrollPane getTable(){
        TableCellRenderer tableCellRenderer;

        Object[][] row = {{
                this.route.getID(), this.route.getBus(), this.route.getRegio(), this.route.getKoerier()
        }};
        String[] col = {"Route nr", "Bus", "Regio", "Koerier"};

        JTable table = new JTable(new OverzichtTableModel(col, row));

        tableCellRenderer = table.getDefaultRenderer(JButton.class);
        table.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableCellRenderer));

        table.setBounds(0, 0 , 600, 400);
        table.setRowHeight(table.getRowHeight() + 15);

        table.addMouseListener(new JTableButtonMouseListener(table));

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0,0,600,600);
        return sp;
    }

    /****
     *
     * Alle code om Koerier te selecteren
     *
     */

    public JComboBox getKoerierDropdown(){
        ArrayList<Object> koeriers = new ArrayList<>();
        ArrayList<Koerier> routes = Route.getRoutesKoerier();

        for (int i = 0; i < Koerier.getInstances().size(); i++){
            koeriers.add(Koerier.getInstances().get(i));
        }
        //Filteren om alleen koeriers te krijgen die nog geen route hebben
        for(int i = 0; i<routes.size(); i++){
            if (koeriers.contains(routes.get(i))){
                for (int x = 0; x < koeriers.size(); x++ ){
                koeriers.remove(routes.get(i));
                }
            }
        }

        JComboBox comboBox = new JComboBox(koeriers.toArray());
        return comboBox;
    }

    public Koerier getSelectedKoerier() {
        return selectedKoerier;
    }

    /****
     *
     * Alle code om Bus te selecteren
     *
     */

    public JComboBox getBusDropdown(){
        ArrayList<Object> bussen = new ArrayList<>();
        ArrayList<Bus> routes = Route.getRoutesBus();

        for (int i = 0; i < Bus.getInstances().size(); i++){
            bussen.add(Bus.getInstances().get(i));
        }
        //Filteren om alleen koeriers te krijgen die nog geen route hebben
        for(int i = 0; i<routes.size(); i++){
            if (bussen.contains(routes.get(i))){
                for (int x = 0; x < bussen.size(); x++ ){
                    bussen.remove(routes.get(i));
                }
            }
        }

        JComboBox comboBox = new JComboBox(bussen.toArray());
        return comboBox;
    }

    public Bus getSelectedBus() {
        return selectedBus;
    }
    public Route getOverzichtRoute() {
        return route;
    }

    /****
     *
     * Aanmaken van knop om data doortesturen en toetevoegen aan route
     *
     */
    public JButton doorstuurKnop(){
        JButton doorstuurButton = new JButton("Doorsturen");
        doorstuurButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(getSelectedKoerier() == null){
                    JOptionPane.showMessageDialog(mainPanel, "Kies een Koerier");
                } else if (getSelectedBus() == null) {
                    JOptionPane.showMessageDialog(mainPanel, "Kies een Bus");
                } else {
                    route.setKoerier(getSelectedKoerier());
                    route.setBus(getSelectedBus());
                    System.out.println(getSelectedBus());
                    DatabaseConnectie dbcon = new DatabaseConnectie();
                    dbcon.updateBusKoerier(getSelectedBus(), null, getOverzichtRoute());

                    route.setStatus("klaar voor picken");
                    dbcon.updateStatus(route.getID(), "klaar voor picken");
                    try {
                        dbcon.getCon().close();
                    } catch (SQLException ex){
                        System.out.println(ex.getMessage());
                    }
                    OverzichtController overzichtController = new OverzichtController(mainPanel);
                    overzichtController.setOverzichtPanel();

                    mainPanel.revalidate();
                    mainPanel.repaint();
                }
            }
        });
        return doorstuurButton;
    }
    /***
     *
     * Ga terug knop
     *
     */
    public JButton terugKnop(){
        JButton terugButton = new JButton("Terug");
        terugButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OverzichtController overzichtController = new OverzichtController(mainPanel);
                overzichtController.setOverzichtPanel();

                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
        return terugButton;
    }
}

package m2h2.Backoffice.Overzicht;

import m2h2.Backoffice.Components.Bus;
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

        mainPanel.add(overzichtLabel = new JLabel("Niet volledige route"));
        JScrollPane sp = getTable();
        mainPanel.add(sp);

        selectedKoerier = this.route.getKoerier();
        selectedBus = this.route.getBus();

        if (selectedKoerier == null){
            mainPanel.add(overzichtLabel = new JLabel("Selecteer koerier"));
            JComboBox jcbK = getKoerierDropdown();
            mainPanel.add(jcbK);

            jcbK.addItemListener( new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        selectedKoerier = (Koerier) e.getItem();
                    }
                }
            });
        }

        if (selectedBus == null) {
            mainPanel.add(overzichtLabel = new JLabel("Selecteer bus"));
            JComboBox jcbB = getBusDropdown();
            mainPanel.add(jcbB);

            jcbB.addItemListener( new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
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
        Object koeriersString[] = new Koerier[Koerier.getInstances().size()];
        koeriersString[0] = null;
        for (int i = 1; i < Koerier.getInstances().size(); i++){
            koeriersString[i] = Koerier.getInstances().get(i);
        }

        JComboBox comboBox = new JComboBox(koeriersString);
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
        Object bussen[] = new Bus[Bus.getInstances().size()];
        bussen[0] = null;
        for (int i = 1; i < Bus.getInstances().size(); i++){
            bussen[i] = Bus.getInstances().get(i);
        }
        JComboBox comboBox = new JComboBox(bussen);
        return comboBox;
    }

    public Bus getSelectedBus() {
        return selectedBus;
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
                    route.setStatus("klaar voor picken");
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

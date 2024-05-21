package m2h2.Backoffice.Overzicht;

import m2h2.Backoffice.Components.*;
import m2h2.Backoffice.Components.Tables.JTableButtonMouseListener;
import m2h2.Backoffice.Components.Tables.JTableButtonRenderer;
import m2h2.Backoffice.Magazijn.MagazijnRouteController;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OverzichtController {
    //In controller alle routes ophalen
    //Voltooide routes en niet voltooide routes
    //niet voltooid is als geen bus of koerier is toegewezen
    private ArrayList<Route> voltooideRoutes;
    private ArrayList<Route> nVoltooideRoutes;
    private JPanel mainPanel;


    public OverzichtController(JPanel mainPanel) {
        this.mainPanel = mainPanel;
        voltooideRoutes = new ArrayList<>();
        nVoltooideRoutes = new ArrayList<>();
        ArrayList<Route> routes = new ArrayList<>();
        routes = Route.getRoutes();
        for (Route route : routes) {
            try {
                if (route.getKoerier() == null || route.getBus() == null) {
                    route.setStatus("onvoltooide route");
                    nVoltooideRoutes.add(route);
                } else  {
                    route.setStatus("klaar voor picken");
                    voltooideRoutes.add(route);
                }
            } catch (NullPointerException e) {
                String error = e.getMessage();
                System.out.println(error);
            }
        }
    }

    public void setOverzichtPanel(){
        mainPanel.removeAll();
        mainPanel.setBackground(new Color(255, 255, 255));

        JLabel Titel = new JLabel("Overzicht routes");
        Titel.setFont(new Font("Segoe UI Semibold", 1, 24));
        mainPanel.add(Titel);

        mainPanel.setLayout(new GridLayout(5,1));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.white, 10));

        JLabel ovRoutes = new JLabel("Onvoltooide routes");
        ovRoutes.setFont(new Font("Segoe UI Semibold", 1, 20));
        mainPanel.add(ovRoutes);
        mainPanel.add(getOnvoltooideRoutesOverzicht());

        JLabel vRoutes = new JLabel("Voltooide routes");
        vRoutes.setFont(new Font("Segoe UI Semibold", 1, 20));
        mainPanel.add(vRoutes);
        mainPanel.add(getVoltooideRoutesOverzicht());

    }

    public ArrayList<Route> getVoltooideRoutes() {
        return voltooideRoutes;
    }

    public ArrayList<Route> getNVoltooideRoutes() {
        return nVoltooideRoutes;
    }

    public JScrollPane getVoltooideRoutesOverzicht() {
        TableCellRenderer tableRenderer;

        Object[][] voltooideData = new Object[voltooideRoutes.size()][5];

        for (int i = 0; i < voltooideRoutes.size(); i++) {
            JButton tableButton = new JButton("Route bekijken");

            tableButton.setActionCommand(i+"");
            tableButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    int id;
                    try{
                        id = Integer.parseInt(e.getActionCommand());
                    } catch (NumberFormatException ex){
                        System.out.println("### hele gekke dingen - buttonAction getTableDate MagazijnController ###");
                        id = -1;
                    }
                    MagazijnRouteController mRouteController = new MagazijnRouteController(voltooideRoutes.get(id).getID(), mainPanel);
                    voltooideRoutes.get(id);
                }
            });

            Object[] row = {
                    voltooideRoutes.get(i).getID(),
                    voltooideRoutes.get(i).getRegio(),
                    voltooideRoutes.get(i).getKoerier().getName(),
                    voltooideRoutes.get(i).getBus(),
                    tableButton

            };
            voltooideData[i] = row;
        }

        String[] columnNames = {"Route nr.", "Regio", "Koerier", "Bus", "Route"};

        JTable table = new JTable(new OverzichtTableModel(columnNames, voltooideData));
        table.setBounds(30, 40, 200, 300);

        tableRenderer = table.getDefaultRenderer(JButton.class);
        table.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));
        table.addMouseListener(new JTableButtonMouseListener(table));
        table.setRowHeight(table.getRowHeight() + 10);

        JScrollPane scrollPane = new JScrollPane(table);
        return scrollPane;
    }

    /*
    ---------------- VANAF HIER ONVOLTOOIDE DEEL -----------------
     */

    public JScrollPane getOnvoltooideRoutesOverzicht(){
        TableCellRenderer tableRenderer;

        Object[][] nVoltooideData = new Object[nVoltooideRoutes.size()][5];

        for (int i = 0; i < nVoltooideRoutes.size(); i++) {
            JButton tableButton = new JButton("Route bekijken");

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
                    OverzichtRouteController overzichtRouteController = new OverzichtRouteController(nVoltooideRoutes.get(id), mainPanel);
                }
            });

            if (nVoltooideRoutes.get(i).getKoerier() == null && nVoltooideRoutes.get(i).getBus() != null) {
                Object[] row = {
                        nVoltooideRoutes.get(i).getID(),
                        nVoltooideRoutes.get(i).getRegio(),
                        "-",
                        nVoltooideRoutes.get(i).getBus(),
                        tableButton
                };
                nVoltooideData[i] = row;
            } else if (nVoltooideRoutes.get(i).getBus() == null && nVoltooideRoutes.get(i).getKoerier() != null) {
                Object[] row = {
                        nVoltooideRoutes.get(i).getID(),
                        nVoltooideRoutes.get(i).getRegio(),
                        nVoltooideRoutes.get(i).getKoerier().getName(),
                        "-",
                        tableButton
                };
                nVoltooideData[i] = row;
            } else if (nVoltooideRoutes.get(i).getKoerier() == null || nVoltooideRoutes.get(i).getBus() == null ) {
                Object[] row = {
                        nVoltooideRoutes.get(i).getID(),
                        nVoltooideRoutes.get(i).getRegio(),
                        "-",
                        "-",
                        tableButton
                };
                nVoltooideData[i] = row;
            } else {
                Object[] row = {
                        nVoltooideRoutes.get(i).getID(),
                        nVoltooideRoutes.get(i).getRegio(),
                        nVoltooideRoutes.get(i).getKoerier().getName(),
                        nVoltooideRoutes.get(i).getBus().getKenteken(),
                        tableButton
                };
                nVoltooideData[i] = row;
            }
        }
        String[] columns = {"Route nr.", "Regio", "Koerier", "Bus", "Route"};

        JTable oVTable = new JTable(new OverzichtTableModel(columns, nVoltooideData));
        oVTable.setBounds(30, 40, 200, 300);

        tableRenderer = oVTable.getDefaultRenderer(JButton.class);
        oVTable.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));

        oVTable.addMouseListener(new JTableButtonMouseListener(oVTable));
        oVTable.setRowHeight(oVTable.getRowHeight() + 10);

        JScrollPane oVScrollPane = new JScrollPane(oVTable);
        return oVScrollPane;
    }

    @Override
    public String toString() {
        String s = "Voltooide routes: ";
        if (voltooideRoutes.size() != 0) {
            for (Route route : voltooideRoutes) {
                s = s + route + "\n";
            }
        }
        s = s + "Onvoltooide routes: ";
        if (nVoltooideRoutes.size() != 0) {
            for (Route route : nVoltooideRoutes) {
                s = s + route + "\n";
            }
        }
        return s;
    }
}
package m2h2.backoffice.Overzicht;

import m2h2.backoffice.components.*;

import javax.swing.*;
import java.util.ArrayList;

public class OverzichtController {
    //In controller alle routes ophalen
    //Voltooide routes en niet voltooide routes
    //niet voltooid is als geen bus en koerier is toegewezen
    private ArrayList<Route> voltooideRoutes;
    private ArrayList<Route> nVoltooideRoutes;

    public OverzichtController() {
        voltooideRoutes = new ArrayList<>();
        nVoltooideRoutes = new ArrayList<>();
        ArrayList<Route> routes = new ArrayList<>();
        routes = Route.getRoutes();
        for (Route route : routes) {
            try {
                if (route.getKoerier() != null) {
                    voltooideRoutes.add(route);
                } else {
                    nVoltooideRoutes.add(route);
                }
            } catch (NullPointerException e) {
                String error = e.getMessage();
                System.out.println(error);
            }
        }
    }

    public ArrayList<Route> getVoltooideRoutes() {
        return voltooideRoutes;
    }

    public ArrayList<Route> getNVoltooideRoutes() {
        return nVoltooideRoutes;
    }

    public JScrollPane getOverzichtTable() {
        Object[][] data = new Object[voltooideRoutes.size() + nVoltooideRoutes.size()][5];

        int teller = 0;
        JButton jButton = new JButton("Route ophalen");
        for (int i = 0; i < voltooideRoutes.size(); i++) {
            teller++;
            Object[] row = {
                    voltooideRoutes.get(i).getID(),
                    voltooideRoutes.get(i).getRegio(),
                    voltooideRoutes.get(i).getKoerier(),
                    voltooideRoutes.get(i).getBus(),
                    jButton
            };
            data[i] = row;
        }

        for (int i = 0; i < nVoltooideRoutes.size(); i++) {
            Object[] row = {
                    nVoltooideRoutes.get(i).getID(),
                    nVoltooideRoutes.get(i).getRegio(),
                    " - ",
                    nVoltooideRoutes.get(i).getBus(),
                    jButton
            };
            data[teller] = row;
        }

        String[] columnNames = {"Route nr.", "Regio", "Koerier", "Bus", "Route"};

        JTable table = new JTable(data, columnNames);
        table.setBounds(30, 40, 200, 300);

        JScrollPane scrollPane = new JScrollPane(table);
        return scrollPane;
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

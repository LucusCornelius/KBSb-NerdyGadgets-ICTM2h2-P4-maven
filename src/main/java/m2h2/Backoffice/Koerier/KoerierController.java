package m2h2.Backoffice.Koerier;

import m2h2.Backoffice.Components.Route;
import m2h2.Backoffice.Components.Tables.JTableButtonRenderer;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class KoerierController {

    private ArrayList<Route> AannemenRoute;
    private String Aar = "Bekijk mijn order(s)";

    public KoerierController() {
        AannemenRoute = Route.getRoutes("Bekijk mijn order(s)");
    }

    public ArrayList<Route> getAannemenRoute() {
        return AannemenRoute;
    }

    public JScrollPane getTable(KoerierController kController, String status){
        TableCellRenderer tableRenderer;
        JTable table = new JTable(new KoerierTableModel(kController, status));
        tableRenderer = table.getDefaultRenderer(JButton.class);
        table.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));
        table.setBounds(0, 0 , 600, 200);
        table.setRowHeight(table.getRowHeight() + 15);

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0,0, 600,200);
        return sp;
    }

    public Object[][] getTableData(String status) {
        if (status.equals(Aar)) {
            Object[][] data = new Object[AannemenRoute.size()][6];
            for (int i = 0; i < AannemenRoute.size(); i++) {
                JButton tableButton = new JButton("Aannemen");

                //border moet kleur krijgen nu krijgt de cell de bordercolor
                tableButton.setBackground(new Color(250,250 ,140));
                tableButton.setBorder(new LineBorder(new Color(250,250,0)));

//                tableButton.setBorder(BorderFactory.createLineBorder(Color.green, 1,true));
//                tableButton.setFocusBorder();

                Object[] dataline = {
                        AannemenRoute.get(i).getID(),
                        AannemenRoute.get(i).getBus(),
                        AannemenRoute.get(i).getSize(),
                        AannemenRoute.get(i).getRegio(),
                        AannemenRoute.get(i).getPostcodeRange(),
                        tableButton
                };
                data[i] = dataline;
            }
            return data;
        }
        System.out.println("### Er is geen Route beschikbaar ###");
        return null;
    }
}
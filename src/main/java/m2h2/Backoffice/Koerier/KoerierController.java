package m2h2.Backoffice.Koerier;

import m2h2.Backoffice.Components.Route;
import m2h2.Backoffice.Components.Tables.JTableButtonMouseListener;
import m2h2.Backoffice.Components.Tables.JTableButtonRenderer;
import m2h2.Backoffice.Magazijn.MagazijnRouteController;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class KoerierController {

    private ArrayList<Route> AannemenRoute;
    private String Aar = "Aannemen order";

    private JPanel mainPanel;

    public KoerierController(JPanel mainPanel) {
        AannemenRoute = Route.getRoutes("Aannemen order");
        this.mainPanel = mainPanel;
    }

    public ArrayList<Route> getAannemenRoute() {
        return AannemenRoute;
    }

    public JScrollPane getTable(KoerierController kController, String status){
        TableCellRenderer tableRenderer;
        JTable table = new JTable(new KoerierTableModel(kController, status));
        tableRenderer = table.getDefaultRenderer(JButton.class);
        table.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));
        table.setBounds(0, 0 , 600, 300);
        table.setRowHeight(table.getRowHeight() + 10);
        table.addMouseListener(new JTableButtonMouseListener(table));

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0,0, 600,300);
        return sp;
    }

    public Object[][] getTableData(String status) {
        if (status.equals(Aar)) {
            Object[][] data = new Object[AannemenRoute.size()][6];
            for (int i = 0; i < AannemenRoute.size(); i++) {
                JButton tableButton = new JButton("Aannemen");

                tableButton.setActionCommand(i+"");
                //border moet kleur krijgen nu krijgt de cell de bordercolor
//                tableButton.setBackground(new Color(250,250 ,140));
//                tableButton.setBorder(new LineBorder(new Color(250,250,0)));

                tableButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("klik!");
                        int id;
                        try{
                            id = Integer.parseInt(e.getActionCommand());
                        } catch (NumberFormatException ex){
                            System.out.println("### buttonAction getTableDate KoerierController ###");
                            id = -1;
                        }
                        DeliveryController deliveryController = new DeliveryController(AannemenRoute.get(id).getID(), mainPanel);
                        AannemenRoute.get(id);
                    }
                });

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
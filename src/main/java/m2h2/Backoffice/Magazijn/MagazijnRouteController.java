package m2h2.Backoffice.Magazijn;

import m2h2.Backoffice.Components.Order;
import m2h2.Backoffice.Components.Route;
import m2h2.Backoffice.Components.Tables.JTableButtonMouseListener;
import m2h2.Backoffice.Components.Tables.JTableButtonRenderer;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MagazijnRouteController {
    private JPanel mainPanel;
    private JLabel magazijnLabel;
    private Route route;
    private ArrayList<Order> orders;
    private Integer id;

    public MagazijnRouteController(Integer routeID, JPanel mainPanel) {
        this.route = Route.getRoute(routeID);
        orders = route.getOrders();
        this.mainPanel = mainPanel;

        setMagazijnRoutePanel();

        System.out.println("ik werk! " + routeID);
    }

    public void setMagazijnRoutePanel(){
        mainPanel.removeAll();
        mainPanel.setLayout(new GridLayout(5,1));

        mainPanel.add(magazijnLabel = new JLabel("Magazijn"));
        JScrollPane sp = getTable();
        mainPanel.add(sp);

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public JScrollPane getTable(){
        TableCellRenderer tableRenderer;
        JTable table = new JTable(new MagazijnRouteTableModel(this));
        tableRenderer = table.getDefaultRenderer(JButton.class);
        table.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));
        tableRenderer = table.getDefaultRenderer(boolean.class);
        table.setDefaultRenderer(JCheckBox.class, new JTableButtonRenderer(tableRenderer));
        table.setBounds(0, 0 , 600, 400);
        table.setRowHeight(table.getRowHeight() + 15);

        table.addMouseListener(new JTableButtonMouseListener(table));

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0,0,600,600);
        return sp;
    }

    public Object[][] getTableData(){
        Object[][] data = new Object[orders.size()][6];
        for (int i = 0; i < orders.size(); i++){
            if (orders.get(i).getOrderLines().size() == 1){
                JCheckBox opVoorraadBox = new JCheckBox("",orders.get(i).getOpVoorraad());
                Object[] dataline = {
                        orders.get(i).getID(),
                        opVoorraadBox,
                        orders.get(i).getProuctId(),
                        orders.get(i).getProductAantal(),
                        orders.get(i).getSectie(),
                        orders.get(i).getBeschrijving()
                };
                data[i] = dataline;
            } else {
                Object[] dataline = {
                      orders.get(i).getID(),
                        "" ,
                        "" ,
                        "" ,
                        "" ,
                        orders.get(i).getBeschrijving()
                };
                data[i] = dataline;
            }
        }
        return data;
    }
}

package m2h2.Backoffice.Magazijn;

import m2h2.Backoffice.Components.*;
import m2h2.Backoffice.Components.Tables.*;

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
        JTable table = new JTable(new MagazijnRouteTableModel(this)){

            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {

                JComponent component = (JComponent) super.prepareRenderer(renderer, row, col);
                return component;
            }
        };

        TableCellRenderer tableRenderer;
        tableRenderer = table.getDefaultRenderer(JButton.class);
        table.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));

        table.setBounds(0, 0 , 600, 400);
        table.setRowHeight(table.getRowHeight() + 15);

        table.addMouseListener(new JTableButtonMouseListener(table));

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0,0,600,600);
        return sp;
    }

    public Object[][] getTableData(){
        Object[][] data = new Object[getOrdersTableSize()][6];
        int rowIndex = 0;
        for (int i = 0; i < orders.size(); i++){
            if (orders.get(i).getOrderLines().size() == 1){
                data[rowIndex] = orders.get(i).getDataline();
                System.out.println(data);
                rowIndex++;
            } else {
                for (int j = 0; j < orders.get(i).getOrderLines().size(); j++) {
                    data[rowIndex] = orders.get(i).getDataline(j);
                    rowIndex++;
                }
                System.out.println("extra datalines");
                System.out.println(data);
            }
        }
        return data;
    }
    private int getOrdersTableSize(){
        int size = orders.size();
        for (Order order : orders){
            if (order.getOrderLines().size() > 1){
                size = size + order.getOrderLines().size() - 1;
            }
        }
        return size;
    }
}

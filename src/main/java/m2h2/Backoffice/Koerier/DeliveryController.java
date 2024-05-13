package m2h2.Backoffice.Koerier;

import m2h2.Backoffice.Components.Order;
import m2h2.Backoffice.Components.Route;
import m2h2.Backoffice.Components.Tables.JTableButtonMouseListener;
import m2h2.Backoffice.Components.Tables.JTableButtonRenderer;
import m2h2.Backoffice.Magazijn.MagazijnRouteTableModel;
import m2h2.Regios.Orders_Met_Coordinaten;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.ArrayList;

public class DeliveryController {

    private JPanel mainPanel;
    private Route route;
    private javax.swing.JLabel jLabel1;
    private ArrayList<Orders_Met_Coordinaten> orders;
    private Integer id;

    private void initComponents() {
        jLabel1 = new JLabel();
    }

    public DeliveryController(Integer routeID, JPanel mainPanel) {
        this.mainPanel = mainPanel;
        initComponents();
        this.route = Route.getRoute(routeID);
        orders =route.getOrders();

        setDeliveryPanel();
    }

    public void setDeliveryPanel() {
        mainPanel.removeAll();
        mainPanel.setLayout(new GridLayout(5, 1));

        jLabel1.setFont(new Font("Segoe UI Semibold", 1, 24));
        jLabel1.setForeground(new Color(51, 51, 51));
        jLabel1.setText("Aangenomen routeID : " + route.getID());

        mainPanel.setForeground(new Color(51, 51, 51));
        mainPanel.add(jLabel1, BorderLayout.NORTH);

        JScrollPane sp = getTable();
        mainPanel.add(sp);

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public JScrollPane getTable() {
        JTable table = new JTable(new DeliveryTableModel(this)) {

            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {

                JComponent component = (JComponent) super.prepareRenderer(renderer, row, col);
                return component;
            }
        };

        TableCellRenderer tableRenderer;
        tableRenderer = table.getDefaultRenderer(JButton.class);
        table.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));

        table.setBounds(0, 0, 600, 400);
        table.setRowHeight(table.getRowHeight() + 15);

        table.addMouseListener(new JTableButtonMouseListener(table));

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 0, 600, 600);
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


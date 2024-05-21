package m2h2.Backoffice.Magazijn;

import  m2h2.Backoffice.Components.*;
import m2h2.Backoffice.Components.Tables.*;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MagazijnRouteController implements ActionListener {
    private JButton terugButton, doorsturenButton, printButton;
    private JPanel mainPanel, buttonPanel, topPanel;
    private JLabel magazijnLabel;
    private Route route;
    private MagazijnController mController;
    private ArrayList<Order> orders;
    private Integer id;

    public MagazijnRouteController(Integer routeID, JPanel mainPanel) {
        this.route = Route.getRoute(routeID);
        orders = route.getOrders();
        this.mainPanel = mainPanel;
        this.mController = mController;

        setMagazijnRoutePanel();

        System.out.println("ik werk! " + routeID);
    }

    public void setMagazijnRoutePanel(){
        mainPanel.removeAll();
        mainPanel.setLayout(new GridLayout(5,1));

        topPanel = new JPanel(new FlowLayout());
        magazijnLabel = new JLabel("Magazijn");
        printButton = new JButton("uitprinten");
        topPanel.add(magazijnLabel);
        topPanel.add(printButton);
        topPanel.setBackground(Color.white);
        mainPanel.add(topPanel);

        JScrollPane descriptionSPane = getDescriptiontable();
        mainPanel.add(descriptionSPane);

        JScrollPane sp = getTable();
        mainPanel.add(sp);

        terugButton = new JButton("terug");
        terugButton.addActionListener(this);
        doorsturenButton = new JButton("doorsturen");
        doorsturenButton.addActionListener(this);
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(terugButton);
        buttonPanel.add(doorsturenButton);
        mainPanel.add(buttonPanel);

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public JScrollPane getDescriptiontable(){
        JTable table = new JTable(new MagazijnTableModel(route));

        table.setBounds(0, 0 , 600, 400);
        table.setRowHeight(table.getRowHeight() + 15);

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0,0,600,600);
        return sp;
    }

    public JScrollPane getTable(){
        JTable table = new JTable(new MagazijnRouteTableModel(this)){
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
                JComponent component = (JComponent) super.prepareRenderer(renderer, row, col);
                if (getValueAt(row, 0) != null) {
                    //achtergrond van de route inzicht opbasis van of het ID even/ oneven. dit moet nog aangepast worden
                    if ((Integer) getValueAt(row, 0) % 2 == 0) {
                        component.setBackground(Color.WHITE);
                        component.setForeground(Color.BLACK);
                    } else {
                        component.setBackground(Color.LIGHT_GRAY);
                        component.setForeground(Color.BLACK);
                    }
                }
                return component;
            }
        };

        TableCellRenderer tableRenderer;
        tableRenderer = table.getDefaultRenderer(JButton.class);
        table.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));

        table.setDefaultEditor(Boolean.class, table.getDefaultEditor(Boolean.class));
        table.setDefaultRenderer(Boolean.class, table.getDefaultRenderer(Boolean.class));

        table.setBounds(0, 0 , 600, 400);
        table.setRowHeight(table.getRowHeight() + 15);

        table.addMouseListener(new JTableButtonMouseListener(table));

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0,0,600,600);
        return sp;
    }

    public Object[][] getTableData() {
        Object[][] data = new Object[getOrdersTableSize()][6];
        int rowIndex = 0;
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderLines().size() == 1) {
                data[rowIndex] = orders.get(i).getDataline();
                rowIndex++;
            } else {
                for (int j = 0; j < orders.get(i).getOrderLines().size(); j++) {
                    data[rowIndex] = orders.get(i).getDataline(j);
                    rowIndex++;
                }
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == terugButton){
            route.setStatus("klaar voor picken");
            mainPanel.removeAll();
            MagazijnController mController = new MagazijnController(mainPanel);
            mController.setMagazijnPanel();

            mainPanel.revalidate();
            mainPanel.repaint();
        }
        if (e.getSource() == doorsturenButton){
            route.setStatus("klaar voor versturen");
            mainPanel.removeAll();
            MagazijnController mController = new MagazijnController(mainPanel);
            mController.setMagazijnPanel();

            mainPanel.revalidate();
            mainPanel.repaint();
        }
    }
}

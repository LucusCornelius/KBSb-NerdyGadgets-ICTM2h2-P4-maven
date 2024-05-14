package m2h2.Backoffice.Overzicht;

import m2h2.Backoffice.Components.Order;
import m2h2.Backoffice.Components.Route;
import m2h2.Backoffice.Components.Tables.JTableButtonMouseListener;
import m2h2.Backoffice.Components.Tables.JTableButtonRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.ArrayList;

public class OverzichtRouteController {
    private JPanel mainPanel;
    private Route route;
    private Integer id;
    private JLabel overzichtLabel;
    private JTable j;

    public OverzichtRouteController(Route nVoltooideRoute, JPanel mainPanel){
        this.mainPanel = mainPanel;
        this.route = nVoltooideRoute;

        setOverzichtRoutePanel();

        System.out.println(this.route);
    }

    public void setOverzichtRoutePanel() {
        mainPanel.removeAll();
        mainPanel.setLayout(new GridLayout(5,1));

        mainPanel.add(overzichtLabel = new JLabel("Niet volledige route"));
        JScrollPane sp = getTable();
        mainPanel.add(sp);

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public JScrollPane getTable(){
        TableCellRenderer tableCellRenderer;

        Object[][] row = {{
                this.route.getID(), this.route.getBus(), this.route.getRegio(), this.route.getKoerier()
        }};
        String[] col = {"Route nr", "Regio", "Koerier", "Bus"};

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
    
}

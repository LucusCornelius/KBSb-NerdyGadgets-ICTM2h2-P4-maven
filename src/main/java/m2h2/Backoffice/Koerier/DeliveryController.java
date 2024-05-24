package m2h2.Backoffice.Koerier;

import m2h2.Backoffice.Components.Order;
import m2h2.Backoffice.Components.Route;
import m2h2.Backoffice.Components.Tables.JTableButtonMouseListener;
import m2h2.Backoffice.Components.Tables.JTableButtonRenderer;
import m2h2.Backoffice.Magazijn.MagazijnRouteTableModel;
import m2h2.Algoritme.Orders_Met_Coordinaten;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DeliveryController implements ActionListener {

    private JButton terugButton, routeVoltooien, uitprinten;
    private JPanel mainPanel, buttonPanel;
    private Route route;
    private javax.swing.JLabel jLabel1;
    private ArrayList<Orders_Met_Coordinaten> orders;
    private Integer id;
    private int deliveredCount = 0;
    private int returnedCount = 0;
    private JTextField ordersBezorgd;
    private JTextField ordersTerug;
    DeliveryController deliveryController;

    private void initComponents() {
        jLabel1 = new JLabel();
    }

    public DeliveryController(Integer routeID, JPanel mainPanel) {
        initComponents();
        this.mainPanel = mainPanel;
        this.route = Route.getRoute(routeID);
        orders = route.getOrders();

        setDeliveryPanel();
    }

    public void setDeliveryPanel() {
        mainPanel.removeAll();
        mainPanel.setLayout(new GridLayout(5, 1));

        jLabel1.setFont(new Font("Segoe UI Semibold", 1, 24));
        jLabel1.setForeground(new Color(51, 51, 51));
        jLabel1.setText("Aangenomen route");

        mainPanel.setForeground(new Color(51, 51, 51));
        mainPanel.add(jLabel1, BorderLayout.NORTH);

        JScrollPane DescriptionSP = getDescriptionHeaderTable();
        mainPanel.add(DescriptionSP);

        JScrollPane sp = getTable();
        mainPanel.add(sp);

        terugButton = new JButton("Ga Terug");
        terugButton.addActionListener(this);

        routeVoltooien = new JButton("Route voltooien");
        routeVoltooien.addActionListener(this);

        uitprinten = new  JButton("Uitprinten");
        uitprinten.addActionListener(this);

        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(Color.WHITE);

        //toevoegen
        buttonPanel.add(terugButton);
        buttonPanel.add(routeVoltooien);
        buttonPanel.add(uitprinten);
        mainPanel.add(buttonPanel);

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public JScrollPane getDescriptionHeaderTable(){
        JTable table = new JTable(new KoerierTableModel(route));
        table.setFont(new Font("Segoe UI", Font.PLAIN,14));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD,15));
        table.setRowHeight(40);

        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(50);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(50);

        DefaultTableCellRenderer linksZetten = new DefaultTableCellRenderer();
        linksZetten.setHorizontalAlignment(SwingConstants.LEFT);

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(linksZetten);
        }

        JScrollPane sp = new JScrollPane(table);
        return sp;
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

        table.setDefaultEditor(Boolean.class, table.getDefaultEditor(Boolean.class));
        table.setDefaultRenderer(Boolean.class, table.getDefaultRenderer(Boolean.class));

        table.setBounds(0, 0, 600, 400);
        table.setRowHeight(table.getRowHeight() + 15);
        table.addMouseListener(new JTableButtonMouseListener(table));

        table.addMouseListener(new JTableButtonMouseListener(table));

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 0, 600, 600);
        return sp;
    }

    public Object[][] getTableData() {
        Object[][] data = new Object[getOrdersTableSize()][5];
        int rowIndex = 0;
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderLines().size() == 1) {
                data[rowIndex] = orders.get(i).getDatalineRoute();
                if ((Boolean) data[rowIndex][4]) {
                    deliveredCount++;
                } else {
                    returnedCount++;
                }
                rowIndex++;
            } else {
                for (int j = 0; j < orders.get(i).getOrderLines().size(); j++) {
                    data[rowIndex] = orders.get(i).getDatalineRoute(j);
                    if ((Boolean) data[rowIndex][4]) {
                        deliveredCount++;
                    } else {
                        returnedCount++;
                    }
                    rowIndex++;
                }
            }
        }
        return data;
    }

    private int getOrdersTableSize() {
        int size = orders.size();
        for (Order order : orders) {
            if (order.getOrderLines().size() > 1) {
                size = size + order.getOrderLines().size() - 1;
            }
        }
        return size;
    }

    public void updateCounters(boolean newValue, boolean oldValue) {
        if (newValue != oldValue) {
            if (newValue) {
                deliveredCount++;
                returnedCount--;
            } else {
                deliveredCount--;
                returnedCount++;
            }
            updateDialog();
        }
    }

    private void updateDialog() {
        if (ordersBezorgd != null && ordersTerug != null) {
            ordersBezorgd.setText(String.valueOf(deliveredCount));
            ordersTerug.setText(String.valueOf(returnedCount));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == terugButton) {
            route.setStatus("Aannemen order");
            mainPanel.removeAll();
            KoerierController kController = new KoerierController(mainPanel);
            kController.setKoerierPanel();

            mainPanel.revalidate();
            mainPanel.repaint();
        } else if (e.getSource() == routeVoltooien) {
            showRouteCompleteDialog();
        } else if (e.getSource() == uitprinten) {
            printTableAsImage();
        }
    }

    private void showRouteCompleteDialog() {
        JDialog dialog = new JDialog((Frame) null, "Route voltooien", true);
        dialog.setUndecorated(true);
        dialog.setLayout(new GridBagLayout());
        dialog.getRootPane().setBorder(new LineBorder(Color.BLACK, 2));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel label1 = new JLabel("Aantal orders bezorgd: ");
        ordersBezorgd = new JTextField();
        ordersBezorgd.setEditable(false);
        ordersBezorgd.setBackground(Color.WHITE);
        ordersBezorgd.setText(String.valueOf(deliveredCount));

        JLabel label2 = new JLabel("Aantal orders terug naar magazijn: ");
        ordersTerug = new JTextField();
        ordersTerug.setEditable(false);
        ordersTerug.setBackground(Color.WHITE);
        ordersTerug.setText(String.valueOf(returnedCount));

        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.add(label1, BorderLayout.NORTH);
        panel1.add(ordersBezorgd, BorderLayout.CENTER);

        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.add(label2, BorderLayout.NORTH);
        panel2.add(ordersTerug, BorderLayout.CENTER);

        dialog.add(panel1);
        dialog.add(panel2);

        JButton terugButton = new JButton("Ga Terug");
//        terugButton.setBackground(new Color(255,204,204));
        terugButton.setOpaque(true);
        terugButton.setBorderPainted(false);
        terugButton.addActionListener(event -> dialog.dispose());

        JButton doorsturenButton = new JButton("Doorsturen");
//        doorsturenButton.setBackground(new Color(204,255,204));
        doorsturenButton.setOpaque(true);
        doorsturenButton.setBorderPainted(false);
        doorsturenButton.addActionListener(event -> {
            //gooi de actie hier in dat ie terug naar t magazijn gaat
            dialog.dispose();
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        dialog.add(label1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        dialog.add(ordersBezorgd, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        dialog.add(label2, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        dialog.add(ordersTerug, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15,0));
        buttonPanel.add(terugButton);
        buttonPanel.add(doorsturenButton);
        dialog.add(buttonPanel, gbc);

        dialog.setSize(400,200);
        dialog.setLocationRelativeTo(mainPanel);
        dialog.setVisible(true);
    }

    private void printTableAsImage() {
        JTable table = new JTable(new DeliveryTableModel(this));
        JScrollPane scroll = new JScrollPane(table);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scroll, BorderLayout.CENTER);

        //maakt n frame om de gegevens van de tabel in op te slaan
        JFrame tempFrame = new JFrame();
        tempFrame.setUndecorated(true);
        tempFrame.add(panel);
        tempFrame.pack();

        // Nu word de size van de de tabel in de image gezet
        Dimension d = panel.getPreferredSize();

        // maken van de afbeelding met de grootte
        BufferedImage bi = new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();
        panel.paint(g);
        g.dispose();

        //weggooien van het tijdelijke frame zodat alleen de tabel er in zit
        tempFrame.dispose();

        try {
            // opslaan van de image
            File outputfile = new File("routeID-" + route.getID() + ".png" );
            ImageIO.write(bi, "png", outputfile);
            JOptionPane.showMessageDialog(null, "De route is gedownload " + outputfile.getAbsolutePath());
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Het is niet gelukt om de route te downloaden " + ex.getMessage());
        }
    }
}



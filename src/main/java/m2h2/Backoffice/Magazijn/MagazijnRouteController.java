package m2h2.Backoffice.Magazijn;

import m2h2.Backoffice.Components.*;
import m2h2.Backoffice.Components.Database.DatabaseConnectie;
import m2h2.Backoffice.Components.Database.DatabaseRouteImport;
import m2h2.Backoffice.Components.Tables.*;
import m2h2.Algoritme.Orders_Met_Coordinaten;
import m2h2.Backoffice.Koerier.DeliveryTableModel;
import m2h2.Backoffice.Koerier.KoerierTableModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class MagazijnRouteController implements ActionListener {
    private JButton terugButton, doorsturenButton, printButton;
    private JPanel mainPanel, buttonPanel, topPanel;
    private JLabel magazijnLabel;
    private Route route;
    private javax.swing.JLabel jLabel1;
    private MagazijnController mController;
    private ArrayList<Orders_Met_Coordinaten> orders;
    private Integer id;

    private int nietBeschikbaar;
    private JLabel messageLabel;
    private void initComponents() {
        jLabel1 = new JLabel();
    }

    public MagazijnRouteController(Integer routeID, JPanel mainPanel) {
        initComponents();
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

        jLabel1.setFont(new Font("Segoe UI Semibold", 1, 24));
        jLabel1.setForeground(new Color(51, 51, 51));
        jLabel1.setText("Magazijn");

        mainPanel.setForeground(new Color(51, 51, 51));
        mainPanel.add(jLabel1, BorderLayout.NORTH);

        JScrollPane descriptionSPane = getDescriptiontable();
        mainPanel.add(descriptionSPane);

        JScrollPane sp = getTable();
        mainPanel.add(sp);

        terugButton = new JButton("terug");
        terugButton.addActionListener(this);

        doorsturenButton = new JButton("doorsturen");
        doorsturenButton.addActionListener(this);

        printButton = new JButton("uitprinten");
        printButton.addActionListener(this);

        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(Color.WHITE);

        buttonPanel.add(terugButton);
        buttonPanel.add(doorsturenButton);
        buttonPanel.add(printButton);
        mainPanel.add(buttonPanel);

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public JScrollPane getDescriptiontable(){
        JTable table = new JTable(new MagazijnTableModel(route));
        table.setFont(new Font("Segoe UI", Font.PLAIN,14));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD,15));
        table.setRowHeight(40);

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
//                    if ((Integer) getValueAt(row, 0) % 2 == 0) {
//                        component.setBackground(Color.WHITE);
//                        component.setForeground(Color.BLACK);
//                    } else {
//                        component.setBackground(Color.LIGHT_GRAY);
//                        component.setForeground(Color.BLACK);
//                    }
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
        for (int i = orders.size()-1; i >= 0 ; i--) {
            if (orders.get(i).getOrderLines().size() == 1) {
                data[rowIndex] = orders.get(i).getDataline();
                rowIndex++;
            } else {
                for (int j = orders.get(i).getOrderLines().size()-1; j >= 0 ; j--) {
                    data[rowIndex] = orders.get(i).getDataline(j);
                    rowIndex++;
                }
            }
        }
        return data;
    }

    public void updateCounters(boolean newValue, boolean oldValue) {
        if (newValue != oldValue) {
            if (newValue) {
                nietBeschikbaar++;
            } else {
                nietBeschikbaar--;
            }
            updateMessageLabel();
        }
    }

    private void updateMessageLabel() {
        if (messageLabel != null) {
            messageLabel.setText(String.valueOf(nietBeschikbaar));
        }
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
            DatabaseConnectie dbcon = new DatabaseConnectie();
            dbcon.updateStatus(route.getID(), "klaar voor picken");
            try {
                dbcon.getCon().close();
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
            mainPanel.removeAll();
            MagazijnController mController = new MagazijnController(mainPanel);
            mController.setMagazijnPanel();

            mainPanel.revalidate();
            mainPanel.repaint();
        }
        if (e.getSource() == doorsturenButton){
           //route.setStatus("klaar voor versturen");
//            mainPanel.removeAll();
            showRouteCompleteDialog();
//            MagazijnController mController = new MagazijnController(mainPanel);
//            mController.setMagazijnPanel();
//
//            mainPanel.revalidate();
//            mainPanel.repaint();
        }
        if (e.getSource() == printButton){
            printTableAsImage();
        }
    }

    private void showRouteCompleteDialog() {
        JDialog dialog = new JDialog((Frame) null, "Order voltooien", true);
        dialog.setUndecorated(true);
        dialog.setLayout(new GridBagLayout());
        dialog.getRootPane().setBorder(new LineBorder(Color.BLACK, 2));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel messageLabel = null;

        if (nietBeschikbaar == 0){
            messageLabel = new JLabel( "<html><div style='text-align: center;'>Klik op 'Doorsturen' om deze route naar de koerier te sturen.</div></html>");
        } else if (nietBeschikbaar == 1) {
            messageLabel = new JLabel( "<html><div style='text-align: center;'>Klik op 'Doorsturen' om deze route naar de koerier te sturen en het missende product bij te bestellen.</div></html>");
        } else {
            messageLabel = new JLabel( "<html><div style='text-align: center;'>Klik op 'Doorsturen' om deze route naar de koerier te sturen en de missende "+ nietBeschikbaar +" producten bij te bestellen.</div></html>");
        }
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton terugButton = new JButton("Ga Terug");
        terugButton.setOpaque(true);
        terugButton.setBorderPainted(false);
        terugButton.addActionListener(event -> dialog.dispose());

        JButton doorsturenButton = new JButton("Doorsturen");
        doorsturenButton.setOpaque(true);
        doorsturenButton.setBorderPainted(false);
        doorsturenButton.addActionListener(event -> {
            route.setStatus("klaar voor versturen");
            DatabaseConnectie dbcon = new DatabaseConnectie();
            dbcon.updateStatus(route.getID(), "klaar voor versturen");
            try {
                dbcon.getCon().close();
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
            mainPanel.removeAll();
            MagazijnController mController = new MagazijnController(mainPanel);
            mController.setMagazijnPanel();
            mainPanel.revalidate();
            mainPanel.repaint();

            dialog.dispose();
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        dialog.add(messageLabel, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        buttonPanel.add(terugButton);
        buttonPanel.add(doorsturenButton);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        dialog.add(buttonPanel, gbc);

        dialog.setSize(400, 200);
        dialog.setLocationRelativeTo(mainPanel);
        dialog.setVisible(true);
    }

    private void printTableAsImage() {
        JTable table = new JTable(new MagazijnRouteTableModel(this));
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
            File outputfile = new File("OrderID-" + route.getID() + ".png" );
            ImageIO.write(bi, "png", outputfile);
            JOptionPane.showMessageDialog(null, "De route is gedownload " + outputfile.getAbsolutePath());
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Het is niet gelukt om de route te downloaden " + ex.getMessage());
        }
    }
}

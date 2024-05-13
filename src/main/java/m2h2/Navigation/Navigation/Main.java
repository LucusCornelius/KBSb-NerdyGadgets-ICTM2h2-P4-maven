package m2h2.Navigation.Navigation;

import m2h2.Backoffice.Koerier.KoerierController;
import m2h2.Backoffice.TestCode.DummyData;
import m2h2.Backoffice.Magazijn.MagazijnController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import m2h2.Backoffice.Overzicht.OverzichtController;

public class Main extends javax.swing.JFrame implements ActionListener{

    private javax.swing.JButton Route;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton Menu;
    private javax.swing.JButton OrderPicker;
    private javax.swing.JButton Koerier;
    private javax.swing.JButton Login;
    private javax.swing.JPanel sidebar;
    private JScrollPane jScrollPane;

    SideMenuPanel sp;

    public Main() {
        DummyData Ddata = new DummyData();
        Ddata.setDummyData();
        initComponents();
        sp = new SideMenuPanel(this);
        sp.setMain(mainPanel);
        sp.setSide(sidebar);
        sp.setMinWidth(55);
        sp.setMaxWidth(150);
        sp.setMainAnimation(true);
        sp.setSpeed(4);
        sp.setResponsiveMinWidth(600);
    }

    private void initComponents() {
        jPanel1 = new JPanel();
        sidebar = new JPanel();
        OrderPicker = new JButton();
        Koerier = new JButton();
        Route = new JButton();
        Menu = new JButton();
        Login = new JButton();
        jLabel13 = new JLabel();
        mainPanel = new JPanel();
        jLabel1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        sidebar.setBackground(new Color(0, 64, 138));
        sidebar.setPreferredSize(new Dimension(90, 32));

        Login.setFont(new Font("Microsoft PhagsPa", 0, 14));
        Login.setForeground(new Color(255, 255, 255));
        Login.setIcon(new ImageIcon("src/main/java/m2h2/Navigation/Icon/Login.png"));
        Login.setText("Login");
        Login.setBorderPainted(false);
        Login.setContentAreaFilled(false);
        Login.setFocusPainted(false);
        Login.setHideActionText(true);
        Login.setHorizontalAlignment(SwingConstants.LEADING);
        Login.setHorizontalTextPosition(SwingConstants.RIGHT);
        Login.setIconTextGap(20);
        Login.setMargin(new Insets(2, 0, 2, 14));
        Login.setMinimumSize(new Dimension(200, 35));
        Login.setPreferredSize(new Dimension(50, 574));
        Login.addActionListener(this);

        Koerier.setFont(new Font("Microsoft PhagsPa", 0, 14));
        Koerier.setForeground(new Color(255, 255, 255));
        Koerier.setIcon(new ImageIcon("src/main/java/m2h2/Navigation/Icon/Koerier.png"));
        Koerier.setText("Koerier");
        Koerier.setBorderPainted(false);
        Koerier.setContentAreaFilled(false);
        Koerier.setFocusPainted(false);
        Koerier.setHideActionText(true);
        Koerier.setHorizontalAlignment(SwingConstants.LEADING);
        Koerier.setHorizontalTextPosition(SwingConstants.RIGHT);
        Koerier.setIconTextGap(20);
        Koerier.setMargin(new Insets(2, 0, 2, 14));
        Koerier.setMinimumSize(new Dimension(200, 35));
        Koerier.setPreferredSize(new Dimension(50, 574));
        Koerier.addActionListener(this);

        OrderPicker.setFont(new Font("Microsoft PhagsPa", 0, 14));
        OrderPicker.setForeground(new Color(255, 255, 255));
        OrderPicker.setIcon(new ImageIcon("src/main/java/m2h2/Navigation/Icon/picker-icon.png"));
        OrderPicker.setText("Magazijn");
        OrderPicker.setBorderPainted(false);
        OrderPicker.setContentAreaFilled(false);
        OrderPicker.setFocusPainted(false);
        OrderPicker.setHideActionText(true);
        OrderPicker.setHorizontalAlignment(SwingConstants.LEADING);
        OrderPicker.setHorizontalTextPosition(SwingConstants.RIGHT);
        OrderPicker.setIconTextGap(20);
        OrderPicker.setMargin(new Insets(2, 0, 2, 14));
        OrderPicker.setMinimumSize(new Dimension(200, 35));
        OrderPicker.setPreferredSize(new Dimension(50, 574));
        OrderPicker.addActionListener(this);

        Route.setFont(new Font("Microsoft PhagsPa", 0, 14));
        Route.setForeground(new Color(255, 255, 255));
        Route.setIcon(new ImageIcon("src/main/java/m2h2/Navigation/Icon/route-icon.png"));
        Route.setText("Route");
        Route.setBorderPainted(false);
        Route.setContentAreaFilled(false);
        Route.setHideActionText(true);
        Route.setHorizontalAlignment(SwingConstants.LEADING);
        Route.setHorizontalTextPosition(SwingConstants.RIGHT);
        Route.setIconTextGap(20);
        Route.setMargin(new Insets(2, 0, 2, 14));
        Route.setMinimumSize(new Dimension(200, 80));
        Route.setPreferredSize(new Dimension(50, 574));
        Route.addActionListener(this);

        Menu.setBackground(new Color(34, 40, 47));
        Menu.setFont(new Font("Microsoft PhagsPa", 0, 14));
        Menu.setIcon(new ImageIcon("src/main/java/m2h2/Navigation/Icon/Hamburger-icon.png"));
        Menu.setBorderPainted(false);
        Menu.setContentAreaFilled(false);
        Menu.setFocusPainted(false);
        Menu.setHideActionText(true);
        Menu.setHorizontalAlignment(SwingConstants.LEADING);
        Menu.setHorizontalTextPosition(SwingConstants.RIGHT);
        Menu.setIconTextGap(20);
        Menu.setMargin(new Insets(2, 0, 2, 14));
        Menu.setMinimumSize(new Dimension(200, 80));
        Menu.setPreferredSize(new Dimension(100, 574));
        Menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                menActionPerformed();
            }
        });

//onder aan de navigation
        jLabel13.setFont(new Font("Microsoft PhagsPa", 0, 10));
        jLabel13.setForeground(new Color(255, 255, 255));
        jLabel13.setText("<html>Backoffice NerdyGadgets</html>");
        jLabel13.setHorizontalTextPosition(SwingConstants.LEFT);

//Toevoegen en laten zien in de navigation bar
        //toevoegen
        //route staat nu als homepage(default) vast dit moet niet -> moet losse pagina zijn
        GroupLayout sidebarLayout = new GroupLayout(sidebar);
        sidebar.setLayout(sidebarLayout);
        sidebarLayout.setHorizontalGroup(
                sidebarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(Route, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(sidebarLayout.createSequentialGroup()
                                .addGroup(sidebarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(Menu, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                .addComponent(OrderPicker, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                                .addComponent(Koerier, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                                .addComponent(Login, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(sidebarLayout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        //positioneren
        sidebarLayout.setVerticalGroup(
                sidebarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(sidebarLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Menu, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Route, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(OrderPicker, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Koerier, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Login, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
        );
//einde toevoegen aan de navigation bar

// Homescherm met kleur
        mainPanel.setBackground(new Color(255, 255, 255));
        mainPanel.add(jLabel1, BorderLayout.NORTH);
        jLabel1.setFont(new Font("Segoe UI Semibold", 1, 24));
        jLabel1.setForeground(new Color(51, 51, 51));
        jLabel1.setText("Backoffice NerdyGadgets");

//Hier kan je wat toevoegen voor in de homepage(staat nu weergegeven op route)

// einde toevoegen voor de homepage


        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(sidebar, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(sidebar, GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                        .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void menActionPerformed() {
        sp.onSideMenu();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Route){
            mainPanel.removeAll();
            mainPanel.setBackground(new Color(255, 255, 255));
            jLabel1.setFont(new Font("Segoe UI Semibold", 1, 24));
            jLabel1.setForeground(new Color(51, 51, 51));
            jLabel1.setText("Route");
            mainPanel.add(jLabel1);
            mainPanel.setLayout(new GridLayout(7,1));

            OverzichtController oController = new OverzichtController(mainPanel);
            JScrollPane scrollPane = oController.getVoltooideRoutesOverzicht();
            JScrollPane ovScrollpane = oController.getOnvoltooideRoutesOverzicht();
            mainPanel.add(ovScrollpane);
            mainPanel.add(scrollPane);


            mainPanel.revalidate();
            mainPanel.repaint();
        }

        if (e.getSource() == OrderPicker){
            mainPanel.removeAll();
            mainPanel.setBackground(new Color(255, 255, 255));
            MagazijnController m = new MagazijnController(mainPanel);
            m.setMagazijnPanel();

            mainPanel.revalidate();
            mainPanel.repaint();
        }

        if (e.getSource() == Koerier){
            mainPanel.removeAll();

            jLabel1.setFont(new Font("Segoe UI Semibold", 1, 24));
            jLabel1.setForeground(new Color(51, 51, 51));
            jLabel1.setText("Koerier");

//            JLabel jLabel4 = new JLabel("Bekijk mijn route(s)");
//            jLabel4.setFont(new Font("Segoe UI Semibold",1,14));
//            jLabel4.setForeground(new Color(51,51,51));

            KoerierController kController = new KoerierController(mainPanel);
            JScrollPane sp = kController.getTable(kController, "Aannemen order");

            mainPanel.setLayout(new GridLayout(5,1));
            mainPanel.add(jLabel1, BorderLayout.NORTH);
//            mainPanel.add(jLabel4, BorderLayout.NORTH);
            mainPanel.add(sp, BorderLayout.CENTER);
            mainPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,20));

            mainPanel.revalidate();
            mainPanel.repaint();
        }

        if (e.getSource() == Login){
            mainPanel.setBackground(new Color(255, 255, 255));
            jLabel1.setFont(new Font("Segoe UI Semibold", 1, 24));
            jLabel1.setForeground(new Color(51, 51, 51));
            jLabel1.setText("Login");

            mainPanel.revalidate();
            mainPanel.repaint();
        }
    }
}
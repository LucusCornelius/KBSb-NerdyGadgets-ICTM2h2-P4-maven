package m2h2.Navigation.Navigation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends javax.swing.JFrame implements ActionListener{

    private javax.swing.JButton Route;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton Menu;
    private javax.swing.JButton OrderPicker;
    private javax.swing.JButton Koerier;
    private javax.swing.JButton Login;
    private javax.swing.JPanel sidebar;

    SideMenuPanel sp;

    public Main() {
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
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();

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
        Login.setMargin(new Insets(2, 2, 2, 14));
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
        Koerier.setMargin(new Insets(2, 2, 2, 14));
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
        OrderPicker.setMargin(new Insets(2, 2, 2, 14));
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
        Route.setMargin(new Insets(2, 2, 2, 14));
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
        Menu.setMargin(new Insets(2, 2, 2, 14));
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
        jLabel1.setFont(new Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel1.setForeground(new Color(51, 51, 51));
        jLabel1.setText("Backoffice NerdyGadgets");

//Hier kan je wat toevoegen voor in de homepage(staat nu weergegeven op route)

// einde toevoegen voor de homepage
        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(227, 227, 227)
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(48, 48, 48))
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                    .addGap(23, 23, 23)
                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel3))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                .addContainerGap())))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addComponent(jLabel3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(71, Short.MAX_VALUE))
        );

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

            mainPanel.setBackground(new Color(255, 255, 255));
            jLabel1.setFont(new Font("Segoe UI Semibold", 1, 24));
            jLabel1.setForeground(new Color(51, 51, 51));
            jLabel1.setText("Route");

            mainPanel.revalidate();
            mainPanel.repaint();
        }

        if (e.getSource() == OrderPicker){
            mainPanel.setBackground(new Color(255, 255, 255));
            jLabel1.setFont(new Font("Segoe UI Semibold", 1, 24));
            jLabel1.setForeground(new Color(51, 51, 51));
            jLabel1.setText("Magazijn");

            mainPanel.revalidate();
            mainPanel.repaint();
        }

        if (e.getSource() == Koerier){
            mainPanel.setBackground(new Color(255, 255, 255));
            jLabel1.setFont(new Font("Segoe UI Semibold", 1, 24));
            jLabel1.setForeground(new Color(51, 51, 51));
            jLabel1.setText("Koerier");

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
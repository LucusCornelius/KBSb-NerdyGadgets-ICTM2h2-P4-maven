package backoffice.Koerier;

import javax.swing.*;
import java.awt.*;

public class AannemenRoute extends JFrame{

    private int IDroute = 14123;
    private String Bus;
    private int AantalOrders = 120;
    private String Regio;
    private int Postcode;
    private JButton Aannemen;

    public AannemenRoute(){

        myFrame();
    }

    void myFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setTitle("Test");
        this.setLocationRelativeTo(null);

        String[] columnNames = {"ID-route", "Bus", "Aantal Orders", "Regio", "Postcode"};

        Object[][] data = {{IDroute, "VD-45-KT", AantalOrders, "Zuid-West", "4000 t/m 4999"}};

        JTable table = new JTable(data, columnNames);

        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.CENTER);

        this.add(table.getTableHeader(), BorderLayout.NORTH);

        this.setVisible(true);
    }



    public static void main(String[] args) {
        new AannemenRoute();
    }
}
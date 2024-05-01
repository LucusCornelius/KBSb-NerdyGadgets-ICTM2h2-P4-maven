package m2h2.backoffice.Magazijn;

import javax.swing.*;
import java.awt.*;

public class MagazijnFrame extends JFrame{
    private MagazijnController mController;

    private String title = "NerdyGadgets magazijn";
    private Dimension size = new Dimension(600, 400);

    private JButton button;
    private JTable table;

    public MagazijnFrame(MagazijnController mController){
        this.mController = mController;

        this.setTitle(title);
        this.setSize(size);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JScrollPane sp = mController.getTable();
        this.add(sp);
        
        this.setVisible(true);
    }
}

package m2h2.backoffice.Overzicht;

import javax.swing.*;
import java.awt.*;

public class OverzichtFrame extends JFrame {
    private OverzichtController oController;

    private String title = "Nerdygadgets overzicht";
    private Dimension size = new Dimension(600, 400);

    public OverzichtFrame(OverzichtController oController) {
        this.oController = oController;

        this.setTitle(title);
        this.setSize(size);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JScrollPane scrollPane = oController.getOverzichtTable();
        this.add(scrollPane);

        this.setVisible(true);
    }
}

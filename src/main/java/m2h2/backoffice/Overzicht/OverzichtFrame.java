package m2h2.backoffice.Overzicht;

import javax.swing.*;
import java.awt.*;

public class OverzichtFrame extends JFrame {
    private OverzichtController oController;

    private String title = "Nerdygadgets overzicht";
    private Dimension size = new Dimension(600, 400);

    public OverzichtFrame(OverzichtController oController) {
//        this.oController = new oController();

        this.setTitle(title);
    }
}

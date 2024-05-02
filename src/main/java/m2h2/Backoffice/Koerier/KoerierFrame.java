package m2h2.Backoffice.Koerier;

import javax.swing.*;
import java.awt.*;

public class KoerierFrame extends JFrame {

    private KoerierController kControlller;

    private Dimension size = new Dimension(600,400);

    public KoerierFrame(KoerierController kControlller){
        this.kControlller = kControlller;


        this.setSize(size);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }
}

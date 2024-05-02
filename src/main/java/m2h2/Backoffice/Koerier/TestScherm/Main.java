package m2h2.Backoffice.Koerier.TestScherm;

import m2h2.Backoffice.Components.Bus;
import m2h2.Backoffice.Components.Route;
import m2h2.Backoffice.Koerier.KoerierController;
import m2h2.Backoffice.Koerier.KoerierFrame;


public class Main {

    public static void main(String[] args) {


    KoerierController Kc = new KoerierController();
        System.out.println(Kc);

    KoerierFrame frame = new KoerierFrame(Kc);
    }
}

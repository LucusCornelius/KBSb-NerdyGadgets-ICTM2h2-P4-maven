package m2h2.backoffice.Magazijn;

import java.util.ArrayList;

import m2h2.backoffice.components.*;;

public class MagazijnController {
    private ArrayList<Route> klaarVoorPicken;
    private ArrayList<Route> bezigMetPicken;
    private ArrayList<Route> klaarVoorversturen;

    public MagazijnController(){
        klaarVoorPicken = Route.getRoutes("klaar voor picken");
        bezigMetPicken = Route.getRoutes("bezig met picken");
        klaarVoorversturen = Route.getRoutes("klaar voor versturen");
    }
    public ArrayList<Route> getKlaarVoorPicken() {
        return klaarVoorPicken;
    }
    public ArrayList<Route> getBezigMetPicken() {
        return bezigMetPicken;
    }
    public ArrayList<Route> getKlaarVoorversturen() {
        return klaarVoorversturen;
    }

    @Override
    public String toString() {
        String s = "klaarVoorPicken : ";
        if (klaarVoorPicken.size() != 0) {
            for(Route route : klaarVoorPicken){
                s = s + route + "\n";
            }
        }
        s = s + "bezigMetPicken: ";
        if (bezigMetPicken.size() != 0) {
            for(Route route : bezigMetPicken){
                s = s + route + "\n";
            }
        }
        s = s + "klaarVoorversturen: ";
        if (klaarVoorversturen.size() != 0) {
            for(Route route : klaarVoorversturen){
                s = s + route + "\n";
            }
        }
        return s;
    }
}

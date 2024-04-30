package m2h2.backoffice.Overzicht;

import m2h2.backoffice.components.*;

import java.util.ArrayList;

public class OverzichtController {
    //In controller alle routes ophalen
    //Voltooide routes en niet voltooide routes
    //niet voltooid is als geen bus en koerier is toegewezen
    private ArrayList<Route> voltooideRoutes;
    private ArrayList<Route> nVoltooideRoutes;

    public OverzichtController() {
        ArrayList<Route> routes = new ArrayList<>();
        routes = Route.getRoutes();
        for (Route route : routes) {
            if (route.getKoerier() != null){
                voltooideRoutes.add(route);
            } else {
                nVoltooideRoutes.add(route);
            }
        }
    }

    public ArrayList<Route> getVoltooideRoutes() {return voltooideRoutes;}
    public ArrayList<Route> getNVoltooideRoutes() {return nVoltooideRoutes;}

    @Override
    public String toString() {
        String s = "Voltooide routes: ";
        if (voltooideRoutes.size() != 0) {
            for (Route route : voltooideRoutes) {
                s = s + route + "\n";
            }
        }
        s = s + "Onvoltooide routes: ";
        if (nVoltooideRoutes.size() != 0) {
            for (Route route : nVoltooideRoutes) {
                s = s + route + "\n";
            }
        }
        return s;
    }
}

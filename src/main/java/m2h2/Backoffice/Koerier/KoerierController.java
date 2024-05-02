package m2h2.Backoffice.Koerier;

import m2h2.Backoffice.Components.Route;
import m2h2.Backoffice.Components.Tables.JTableButtonRenderer;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.ArrayList;

public class KoerierController{

    private ArrayList<Route>  AannemenRoute;
    private String Aar = "Bekijk mijn order(s)";

    public KoerierController(){
        AannemenRoute = Route.getRoutes("Bekijk mijn order(s)");
    }

    public ArrayList<Route> getAannemenRoute() {
        return AannemenRoute;
    }

    public Object[][] getTableData(String status){
        if (status.equals(Aar)){
            Object[][] data = new Object[AannemenRoute.size()][5];
            for (int i = 0; i < AannemenRoute.size(); i++) {
                JButton tableButton = new JButton("Aannemen");
                Object[] dataline = {
                        AannemenRoute.get(i).getID(),
                        AannemenRoute.get(i).getBus(),
                        AannemenRoute.get(i).getSize(),
                        AannemenRoute.get(i).getRegio(),
                        AannemenRoute.get(i).getPostcodeRange(),
                        tableButton
                };
                data[i] = dataline;
            }
            return data;
        } else {
            System.out.println("### Er is geen Route beschikbaar ###");
            return null;
        }
    }
}
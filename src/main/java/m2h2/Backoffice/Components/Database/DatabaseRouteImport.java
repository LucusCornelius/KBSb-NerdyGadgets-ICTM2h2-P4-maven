package m2h2.Backoffice.Components.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseRouteImport {
    private DatabaseConnectie con;
    public DatabaseRouteImport(DatabaseConnectie con) {
        this.con = con;
    }
    public void prepRoutesToday() {
        ArrayList<Integer> routeIDs = con.getRouteIDs();
        for (Integer routeID : routeIDs) {
            con.getRoute(routeID);

        }
    }
}

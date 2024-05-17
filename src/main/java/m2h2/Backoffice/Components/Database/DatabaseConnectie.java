package m2h2.Backoffice.Components.Database;

import m2h2.Backoffice.Components.*;
import m2h2.Regios.Orders_Met_Coordinaten;

import java.sql.*;

public class DatabaseConnectie {
    Connection con;
    String url;
    String username = "root";
    String password;

    /* --- bluelprint sqlquery ---
    try {
            Statement stmt = con.createStatement();
            String query = "";
            int result = stmt.executeUpdate(query);

            if (result > 0) {
                System.out.println("successfully executed query!");
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
     */

    public DatabaseConnectie() {
        con = null;
        url = "jdbc:mysql://localhost:3306/";
        username = "root";
        password = "";

        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        if (con == null) {
            System.out.println("Connection Failed! Check output console");
        } else {
            System.out.println("Connected!");
        }

    }
    public void insertOrder(Order order){
        try {
            Statement stmt = con.createStatement();
        String query = "INSERT INTO orders (" +
                "OrderID, " +
                "CustomerID, " +
                "SalepersonPersonID, " +
                "ContactPersonID, " +
                "OrderDate, " +
                "ExpectedDeliveryDate, " +
                "isUndersupplyBackordered, " +
                "LastEditedBy, " +
                "LastEditedWhen)";
        int result = stmt.executeUpdate(query);

            if (result > 0) {
                System.out.println("successfully inserted order");
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void insertOrder(Orders_Met_Coordinaten ordersMetCoordinaten){

    }
    public void insertOrderline(OrderLine orderLine){

    }

}

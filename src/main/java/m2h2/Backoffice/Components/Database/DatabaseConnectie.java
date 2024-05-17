package m2h2.Backoffice.Components.Database;

import m2h2.Backoffice.Components.*;
import m2h2.Regios.Orders_Met_Coordinaten;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.Calendar;

public class DatabaseConnectie {
    Connection con;
    String url;
    String username = "root";
    String password;

    int customerID = 1;
    int contactPersonID = 1234;
    Calendar timestamp = Calendar.getInstance();
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

        try {
            Statement statement = con.createStatement();
            Boolean result = statement.execute("use nerdygadgets;");
            if (result) {
                System.out.println("db: nerdygadgets wordt gebruikt");
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public void testdb(){
        try {
            PreparedStatement ps = con.prepareStatement("select * from people");

            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                if (rs.getString(2).equals("Rick")) {
                    System.out.println("check");
                } else {
                    System.out.println("not check");
                }
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }


    }
    public void insertOrder(Order order){
        try {
        String query = "INSERT INTO orders (" +
                "OrderID, " +
                "DeliveryPostalCode, " + //eerst customer aan maken
                "DeliveryLocation, " +
                "DeliveryAddressLine1, " + //straatnaam
                "DeliveryAddressLine2, " + // huisnummer
                "CustomerID, " +
                "SalepersonPersonID, " +
                "ContactPersonID, " +
                "OrderDate, " +
                "ExpectedDeliveryDate, " +
                "isUndersupplyBackordered, " +
                "LastEditedBy, " +
                "LastEditedWhen)" +
                "VALUES (" +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pQuery = con.prepareStatement(query);
        pQuery.setInt(1 , order.getID());
        pQuery.setString(2, order.getPostcode());
        pQuery.setString(3, order.getPlaatsnaam());
        pQuery.setString(4, order.getStraatnaam());
        pQuery.setString(5, order.getHuisnummer()+"");
        pQuery.setInt(6, customerID);
        pQuery.setInt(7, contactPersonID); //salesperson
        pQuery.setInt(8, contactPersonID); // contactperson
        pQuery.setString(9, timestamp.getTime()+"");
        pQuery.setString(10, timestamp.getTime()+"");
        pQuery.setBoolean(11, false);
        pQuery.setInt(12, contactPersonID);
        pQuery.setString(13, timestamp.getTime()+"");

        int result = pQuery.executeUpdate();

            if (result > 0) {
                System.out.println("successfully inserted order");
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void insertOrder(Orders_Met_Coordinaten order){
        try {
            String query = "INSERT INTO orders (" +
                    "OrderID, " +
                    "DeliveryPostalCode, " +
                    "DeliveryLocation, " +
                    "DeliveryAddressLine1, " + //straatnaam
                    "DeliveryAddressLine2, " + // huisnummer
                    "CustomerID, " +
                    "SalepersonPersonID, " +
                    "ContactPersonID, " +
                    "OrderDate, " +
                    "ExpectedDeliveryDate, " +
                    "isUndersupplyBackordered, " +
                    "LastEditedBy, " +
                    "LastEditedWhen)" +
                    "VALUES (" +
                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pQuery = con.prepareStatement(query);
            pQuery.setInt(1 , order.getID());
            pQuery.setString(2, order.getPostcode());
            pQuery.setString(3, order.getPlaatsnaam());
            pQuery.setString(4, order.getStraatnaam());
            pQuery.setString(5, order.getHuisnummer()+"");
            pQuery.setInt(6, customerID);
            pQuery.setInt(7, contactPersonID); //salesperson
            pQuery.setInt(8, contactPersonID); // contactperson
            pQuery.setString(9, timestamp.getTime()+"");
            pQuery.setString(10, timestamp.getTime()+"");
            pQuery.setBoolean(11, false);
            pQuery.setInt(12, contactPersonID);
            pQuery.setString(13, timestamp.getTime()+"");

            int result = pQuery.executeUpdate();

            if (result > 0) {
                System.out.println("successfully inserted order");
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }


}

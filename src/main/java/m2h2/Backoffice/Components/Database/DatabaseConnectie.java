package m2h2.Backoffice.Components.Database;

import m2h2.Backoffice.Components.*;
import m2h2.Regios.Orders_Met_Coordinaten;

import javax.xml.transform.Result;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatabaseConnectie {
    private static int customerIDCounter = 0;

    private Connection con;
    private String url;
    private String username = "root";
    private String password;

    private int OrderID;

    private int customerID = 1;
    private  int contactPersonID = 1234;
    private int packageTypeID = 7;


    String pattern = "yyyy-MM-dd";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    String date = simpleDateFormat.format(new Date());
    private String validTo = "2999-01-01";
    /* --- bluelprint sqlquery ---
    try {
            Statement stmt = con.createStatement();
            String query = "";
            int result = stmt.executeUpdate(query);

            if (result > 0) {
                System.out.println("successfully executed query!");
            }
            stmt.close();
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
    public int getNewCustomerID(){
        try {
            String query = "SELECT max(CustomerID) FROM customers";
            PreparedStatement pQuery = con.prepareStatement(query);

            ResultSet rs = pQuery.executeQuery();
            int maxID = -1;
            while (rs.next()){
                maxID = rs.getInt(customerID) + 1;
            }
            pQuery.close();
            return maxID;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return -1;
        }
    }
    public int getNewOrderID(){
        try {
            String query = "SELECT max(OrderID) FROM orders";
            PreparedStatement pQuery = con.prepareStatement(query);

            ResultSet rs = pQuery.executeQuery();
            int maxID = -1;
            while (rs.next()){
                try {
                    maxID = rs.getInt(OrderID) + 1;
                } catch (SQLException e) {
                    maxID = 1;
                }
            }
            pQuery.close();
            return maxID;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return -1;
        }
    }
    public int getNewOrderLineID(){
        try {
            String query = "SELECT max(OrderLineID) FROM orderLines";
            PreparedStatement pQuery = con.prepareStatement(query);

            ResultSet rs = pQuery.executeQuery();
            int maxID = -1;
            while (rs.next()){
                try {
                    maxID = rs.getInt(OrderID) + 1;
                } catch (SQLException e) {
                    maxID = 1;
                }
            }
            pQuery.close();
            return maxID;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return -1;
        }
    }
    public int customerExists(Order order){
        try {
            String query = "SELECT CustomerID FROM customers WHERE CustomerName = ?";
            PreparedStatement pQuery = con.prepareStatement(query);

            pQuery.setString(1, order.getNaam());

            ResultSet rs = pQuery.executeQuery();

            while (rs.next()){
                return rs.getInt("CustomerID");
            }
            pQuery.close();
            return -1;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return -1;
        }
    }
    //returnt customer ID
    public int insertCustomer(Order order){
        int customerID;
        int cExitst = customerExists(order);
        if (cExitst == -1){
            customerID = getNewCustomerID();
            try {if (customerID != -1) {
                //dummy customer, werk met de aangeleverde sql scripts. volledige implementatie binnen nerdygadgets omgeving nogsteeds mogelijk.
                String query = "INSERT INTO customers( CustomerID," +
                        "CustomerName," +
                        "BillToCustomerID," +
                        "CustomerCategoryID ," +
                        "PrimaryContactPersonID ," +
                        "AlternateContactPersonID," +
                        "DeliveryMethodID ," +
                        "DeliveryCityID ," +
                        "PostalCityID , " +
                        "CreditLimit," +
                        "AccountOpenedDate , " +
                        "StandardDiscountPercentage , " +
                        "IsStatementSent , " +
                        "IsOnCreditHold , " +
                        "PaymentDays , " +
                        "PhoneNumber ,  " +
                        "FaxNumber , " +
                        "WebsiteURL , " +
                        "DeliveryAddressLine1 , " +
                        "DeliveryPostalCode , " +
                        "PostalAddressLine1 , " +
                        "PostalPostalCode , " +
                        "LastEditedBy , " +
                        "ValidFrom , " +
                        "ValidTo" +
                        ")" +
                        "        VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement pQuery = con.prepareStatement(query);
                pQuery.setInt(1, customerID);
                pQuery.setString(2, order.getNaam());
                pQuery.setInt(3, customerIDCounter);
                pQuery.setInt(4, 1);
                pQuery.setInt(5, contactPersonID);
                pQuery.setInt(6, contactPersonID);
                pQuery.setInt(7, 1);
                pQuery.setInt(8, 1);
                pQuery.setInt(9, 1);
                pQuery.setInt(10, 0);
                pQuery.setString(11, date);
                pQuery.setInt(12, 0);
                pQuery.setBoolean(13, false);
                pQuery.setBoolean(14, false);
                pQuery.setInt(15, 0);
                pQuery.setString(16, "1234567890");
                pQuery.setString(17, "1234567890");
                pQuery.setString(18, "tempurl");
                pQuery.setString(19, order.getStraatnaam());
                pQuery.setString(20, order.getPostcode());
                pQuery.setString(21, order.getStraatnaam());
                pQuery.setString(22, order.getPostcode());
                pQuery.setInt(23, contactPersonID);
                pQuery.setString(24, date);
                pQuery.setString(25, this.validTo);

                int result = pQuery.executeUpdate();

                if (result > 0) {
                    System.out.println("successfully inserted order");
                }
                pQuery.close();
            } else {
                System.out.println("niewe customer niet inserted: ID niet geldig - DatabaseConnectie insertCustomer");
            }
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
        } else {
            customerID = cExitst;
        }
        return customerID;
    }
    public void insertOrderLine(OrderLine orderLine){
        try {
            Statement stmt = con.createStatement();
            String query = "INSERT INTO orderlines(" +
                    "OrderLineID, " +
                    "StockItemID, " +
                    "PickedQuantity, " +
                    "PackageTypeID, " +
                    "Description, " +
                    "Quantity, " +
                    "TaxRate, " +
                    "LastEditedBy, " +
                    "ValidFrom, " +
                    "ValidTo" +
                    ")" +
                    "VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pQuery = con.prepareStatement(query);
            pQuery.setInt(1, getNewOrderLineID());
            pQuery.setInt(2,);
            pQuery.setInt(3, 0);
            pQuery.setInt(4, packageTypeID);
            pQuery.setString(5,orderLine.getBeschrijving());
            pQuery.setInt(6,orderLine.getAantal());
            pQuery.setDouble(7,0);
            pQuery.setInt(8,contactPersonID);
            pQuery.setString(9,date);
            pQuery.setString(10,validTo);
            int result = stmt.executeUpdate(query);

            if (result > 0) {
                System.out.println("successfully executed query!");
            }
            stmt.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void insertOrder(Order order){
        int customerID = insertCustomer(order);
        int orderID = getNewOrderID();

        try {
        String query = "INSERT INTO orders (" +
                "OrderID, " +
                "CustomerID, " +
                "SalepersonPersonID, " +
                "ContactPersonID, " +
                "OrderDate, " +
                "ExpectedDeliveryDate, " +
                "isUndersupplyBackordered, " +
                "LastEditedBy, " +
                "LastEditedWhen)" +
                "VALUES (" +
                "?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pQuery = con.prepareStatement(query);
        pQuery.setInt(1 , orderID);
        pQuery.setInt(2, customerID);
        pQuery.setInt(3, contactPersonID); //salesperson
        pQuery.setInt(4, contactPersonID); // contactperson
        pQuery.setString(5, date);
        pQuery.setString(6, date);
        pQuery.setBoolean(7, false);
        pQuery.setInt(8, contactPersonID);
        pQuery.setString(9, date);

        int result = pQuery.executeUpdate();
            if (result > 0) {
                System.out.println("successfully inserted order");
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        if (order.getOrderLines() != null) {
            for (OrderLine orderLine : order.getOrderLines()) {
                insertOrderLine(orderLine);
            }
        }
    }
    public void insertRoute(Route route){
        try {
            Statement stmt = con.createStatement();
            String query = "";
            int result = stmt.executeUpdate(query);

            if (result > 0) {
                System.out.println("successfully executed query!");
            }

            stmt.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        for (Order order : route.getOrders()) {
            insertOrder(order);
        }
    }
    public ResultSet getRoutes(Route route){
        try {
            String query = "";
            PreparedStatement pQuery = con.prepareStatement(query);

            pQuery.setString();

            ResultSet rs = pQuery.executeQuery();

            while (rs.next()){

            }
            pQuery.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}

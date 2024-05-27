package m2h2.Backoffice.Components.Database;

import m2h2.Backoffice.Components.*;
import m2h2.Algoritme.Orders_Met_Coordinaten;

import javax.xml.transform.Result;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    private int contactPersonID = 1234;
    private int packageTypeID = 7;
    private int testStockItemID = 1;


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

    public Connection getCon() {
        return con;
    }

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
                maxID = rs.getInt(1) + 1;
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
                    maxID = rs.getInt(1) + 1;
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
                    maxID = rs.getInt(1) + 1;
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
    public int getNewRouteID(){
        try {
            String query = "SELECT max(RouteID) FROM route";
            PreparedStatement pQuery = con.prepareStatement(query);

            ResultSet rs = pQuery.executeQuery();
            int maxID = -1;
            rs.next();
                try {
                    maxID = rs.getInt(1) + 1;
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    maxID = -1;
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
            String query = "SELECT CustomerID FROM customers WHERE CustomerName = ? AND DeliveryAddressLine1 = ? AND DeliveryAddressLine2 = ? AND DeliveryPostalCode = ? AND DeliveryLocation = ?";
            PreparedStatement pQuery = con.prepareStatement(query);

            pQuery.setString(1, order.getNaam());
            pQuery.setString(2, order.getStraatnaam());
            pQuery.setString(3, order.getHuisnummer()+"");
            pQuery.setString(4, order.getPostcode());
            pQuery.setString(5, order.getPlaatsnaam());


            ResultSet rs = pQuery.executeQuery();

            rs.next();
            int x = rs.getInt(1);

            pQuery.close();
            return x;
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
                String query = "INSERT INTO customers( " +
                        "CustomerID," +
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
                        "DeliveryAddressLine2, " +
                        "DeliveryPostalCode , " +
                        "DeliveryLocation , " +
                        "PostalAddressLine1 , " +
                        "PostalPostalCode , " +
                        "LastEditedBy , " +
                        "ValidFrom , " +
                        "ValidTo" +
                        ")" +
                        "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement pQuery = con.prepareStatement(query);
                pQuery.setInt(1, customerID);
                pQuery.setString(2, order.getNaam());
                pQuery.setInt(3, 1);
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
                pQuery.setString(20, order.getHuisnummer()+"");
                pQuery.setString(21, order.getPostcode());
                pQuery.setString(22, order.getPlaatsnaam());
                pQuery.setString(23, order.getStraatnaam());
                pQuery.setString(24, order.getPostcode());
                pQuery.setInt(25, contactPersonID);
                pQuery.setString(26, date);
                pQuery.setString(27, this.validTo);

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
                System.out.println("customer: " + customerID);
            }
        } else {
            customerID = cExitst;
        }
        return customerID;
    }
    public void insertOrderLine(OrderLine orderLine, int orderID){
        try {
            String query = "INSERT INTO orderlines(" +
                    "OrderLineID, " +
                    "StockItemID, " +
                    "PickedQuantity, " +
                    "PackageTypeID, " +
                    "Description, " +
                    "Quantity, " +
                    "TaxRate, " +
                    "LastEditedBy, " +
                    "LastEditedWhen, " +
                    "OrderID , " +
                    "sectie , " +
                    "opVoorraad" +
                    ")" +
                    "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pQuery = con.prepareStatement(query);
            pQuery.setInt(1, getNewOrderLineID());
            pQuery.setInt(2, testStockItemID);
            pQuery.setInt(3, 0);
            pQuery.setInt(4, packageTypeID);
            pQuery.setString(5,orderLine.getBeschrijving());
            pQuery.setInt(6,orderLine.getAantal());
            pQuery.setDouble(7,0);
            pQuery.setInt(8,contactPersonID);
            pQuery.setString(9,date);
            pQuery.setInt(10, orderID);
            pQuery.setString(11, orderLine.getSectie());
            pQuery.setBoolean(12, orderLine.getOpVoorraad());
            int result = pQuery.executeUpdate();

            if (result > 0) {
                System.out.println("successfully executed query!");
            }
            pQuery.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());

            System.out.println("orderline:" + orderLine);
        }
    }
    public boolean orderExists(int orderID){
        try {
            String query = "SELECT OrderID FROM orders WHERE orderID = ?";
            PreparedStatement pQuery = con.prepareStatement(query);

            pQuery.setInt(1, orderID);

            ResultSet rs = pQuery.executeQuery();

            rs.next();
            rs.getInt(1);

            pQuery.close();
            return true;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public void insertOrder(Order order, int routeID, int routeIndex){
        if (!orderExists(order.getID())) {
            int customerID = insertCustomer(order);
            int orderID = getNewOrderID();

            try {
                String query = "INSERT INTO orders (" +
                        "OrderID, " +
                        "CustomerID, " +
                        "SalespersonPersonID, " +
                        "ContactPersonID, " +
                        "OrderDate, " +
                        "ExpectedDeliveryDate, " +
                        "isUndersupplyBackordered, " +
                        "LastEditedBy, " +
                        "LastEditedWhen, " +
                        "RouteID, " +
                        "routeIndex)" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
                PreparedStatement pQuery = con.prepareStatement(query);
                pQuery.setInt(1, orderID);
                pQuery.setInt(2, customerID);
                pQuery.setInt(3, contactPersonID); //salesperson
                pQuery.setInt(4, contactPersonID); // contactperson
                pQuery.setString(5, date);
                pQuery.setString(6, date);
                pQuery.setBoolean(7, false);
                pQuery.setInt(8, contactPersonID);
                pQuery.setString(9, date);
                pQuery.setInt(10, routeID);
                pQuery.setInt(11, routeIndex);

                int result = pQuery.executeUpdate();
                if (result > 0) {
                    System.out.println("successfully inserted order");
                }
                if (order.getOrderLines() != null) {
                    for (OrderLine orderLine : order.getOrderLines()) {
                        insertOrderLine(orderLine, orderID);
                    }
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                System.out.println("order:" + order);
            }
        } else {
            try {
                System.out.println("###");
                String query = "Update orders " +
                        "SET " +
                        "ExpectedDeliveryDate = ?, " +
                        "LastEditedBy = ?, " +
                        "LastEditedWhen = ?, " +
                        "RouteID = ?, " +
                        "routeIndex = ? " +
                        "Where orderID = ?";
                PreparedStatement pQuery = con.prepareStatement(query);
                pQuery.setString(1, date);
                pQuery.setInt(2, contactPersonID);
                pQuery.setString(3, date);
                pQuery.setInt(4, routeID);
                pQuery.setInt(5, routeIndex);
                pQuery.setInt(6, order.getOrderID());

                int result = pQuery.executeUpdate();
                if (result > 0) {
                    System.out.println("successfully updated order");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                System.out.println("order:" + order);
            }
        }

    }
    public void insertOrder(Order order){
        insertOrder(order, 0, -1);
    }
    public void insertOrder(Order order, int routeID){
        insertOrder(order, routeID, -1);
    }
    public int insertRoute(Route route){
        int routeID = getNewRouteID();
        if (routeID != -1) {
            try {
                String query = "INSERT INTO route (" +
                        "RouteID , " +
                        "koerierID , " +
                        "DeliveryVanID , " +
                        "status , " +
                        "regio " +
                        ") " +
                        "VALUES (?,?,?,?,?)";
                PreparedStatement pQuery = con.prepareStatement(query);
                pQuery.setInt(1, routeID);
                if (route.getKoerierObj() != null) {
                    pQuery.setInt(2, route.getKoerierObj().getKoerierID());
                } else {
                    pQuery.setInt(2, 0);
                }
                if (route.getBusObj() != null) {
                    pQuery.setInt(3, route.getBusObj().getBusID());
                } else {
                    pQuery.setInt(3, 0);
                }
                pQuery.setString(4, route.getStatus());
                pQuery.setString(5, route.getRegio());

                int result = pQuery.executeUpdate();

                if (result > 0) {
                    System.out.println("successfully executed query!");
                }

                pQuery.close();
                for (Orders_Met_Coordinaten order : route.getOrders()) {
                    insertOrder(order, routeID);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                System.out.println("route:" + route);
            }
        } else {
            System.out.println("oeps");
        }
        return routeID;

    }
    public Route getRoute(int routeID){
        Route route = null;
        try {

            String query = "select R.routeID, R.DeliveryVanID, D.kenteken, R.status, R.koerierID, R.regio, O.OrderID, O.routeIndex, CustomerName, C.DeliveryAddressLine1, C.DeliveryAddressLine2, C.DeliveryPostalCode, C.DeliveryLocation, description, orderlineID, Quantity, sectie, opvoorraad " +
                    "from route R " +
                    "LEFT JOIN DeliveryVans D on R.DeliveryVanID = D.DeliveryVanID " +
                    "LEFT JOIN orders O on o.routeID = R.routeID " +
                    "left join customers C on O.CustomerID = C.CustomerID " +
                    "left join orderlines OL on O.OrderID = OL.OrderID " +
                    "where R.routeID = ?";
            PreparedStatement pQuery = con.prepareStatement(query);

            pQuery.setInt(1, routeID);

            ResultSet rs = pQuery.executeQuery();
            boolean routeIsSet = false;
            int prevOrderID = -1;
            Orders_Met_Coordinaten prevOrder = null;
            while (rs.next()) {
                try{
                    if (!routeIsSet) {
                        Bus bus;
                        try {
                            if (!rs.getString("kenteken").isEmpty()) {
                                bus = new Bus(rs.getString("kenteken"), rs.getInt("R.DeliveryVanID"));
                            } else {
                                bus = null;
                            }
                        }catch (NullPointerException e){
                            bus = null;
                        }
                        Koerier koerier;
                        if (rs.getInt("R.koerierID") == 0){
                            koerier = null;
                        } else {
                            koerier = new Koerier("--naam koerier--", rs.getInt("R.koerierID"));
                        }
                        route = new Route(
                                rs.getInt("R.routeID"),
                                bus,
                                rs.getString("regio"),
                                rs.getString("status"),
                                koerier
                                );
                        routeIsSet = true;
                    }
                    if (rs.getInt("O.OrderID") != prevOrderID ){
                        int huisnummer;
                        try{
                            huisnummer = Integer.parseInt(rs.getString("C.DeliveryAddressLine2"));
                        } catch (NumberFormatException e){
                            System.out.println(e.getMessage());
                            huisnummer = -1;
                        }
                        Orders_Met_Coordinaten order = new Orders_Met_Coordinaten(
                                rs.getInt("O.OrderID"),
                                rs.getString("CustomerName"),
                                rs.getString("C.DeliveryAddressLine1"),
                                rs.getString("C.DeliveryPostalCode"),
                                rs.getString("C.DeliveryLocation"),
                                huisnummer,
                                "",
                                rs.getInt("O.routeIndex")
                        );
                        System.out.println(rs.getInt("O.OrderID"));
                        prevOrder = order;
                        route.addOrder(order);
                    }
                    int aantal;
                    try{
                        aantal = Integer.parseInt(rs.getString("Quantity"));
                    } catch (NumberFormatException e){
                        System.out.println(e.getMessage());
                        aantal = -1;
                    }
                    OrderLine orderLine = new OrderLine(
                        rs.getInt("orderlineID") ,
                        rs.getString("sectie"),
                        aantal,
                        rs.getString("description")
                    );
                    try {
                        prevOrder.addOrderline(orderLine);
                    } catch (NumberFormatException e){
                        System.out.println(e.getMessage());
                    }
                    prevOrderID = rs.getInt(5);
                } catch (SQLException e){
                    System.out.println(e.getMessage());
                }
                System.out.println(rs.getString("CustomerName"));
            }
            pQuery.close();
            //return rs;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return route;
    }
    public ArrayList<Integer> getRouteIDs(){
        try {
            String query = "SELECT RouteID FROM route WHERE RouteID IN (SELECT RouteID FROM orders where ExpectedDeliveryDate = ?)";
            PreparedStatement pQuery = con.prepareStatement(query);

            pQuery.setString(1, date);

            ResultSet rs = pQuery.executeQuery();
            ArrayList IDs = new ArrayList();
            while(rs.next()) {
                try {
                    IDs.add(rs.getInt(1));
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    IDs.add(null);
                }
            }
            pQuery.close();
            return IDs;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }
    public void updateStatus(int routeID, String status){
        try {
            String query = "update route set status = ? " +
                    "where RouteID = ?;";
            PreparedStatement pQuery = con.prepareStatement(query);

            pQuery.setString(1, status);
            pQuery.setInt(2, routeID);

            int result = pQuery.executeUpdate();

            if (result > 0) {
                System.out.println("successfully updated status!");
            }
            pQuery.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public boolean BusExixtst(Bus bus){
        try {
            String query = "SELECT DeliveryVanID FROM DeliveryVans WHERE DeliveryVanID = ? AND kenteken = ?";
            PreparedStatement pQuery = con.prepareStatement(query);

            pQuery.setInt(1, bus.getBusID());
            pQuery.setString(2, bus.getKenteken());

            ResultSet rs = pQuery.executeQuery();

            rs.next();
            rs.getInt(1);

            pQuery.close();
            return true;
        } catch (SQLException e){
            return false;
        }
    }
    public ArrayList<Bus> getBeschikbareBussen(){
        try {
            String query = "SELECT DeliveryVanID, kenteken FROM DeliveryVans  WHERE DeliveryVanID NOT IN (" +
                    "SELECT R.DeliveryVanID from route R  " +
                    "LEFT JOIN DeliveryVans V on V.DeliveryVanID = R.DeliveryVanID " +
                    ")";
            PreparedStatement pQuery = con.prepareStatement(query);

            ResultSet rs = pQuery.executeQuery();
            ArrayList<Bus> bussen = new ArrayList<>();
            while (rs.next()){
                try{
                    bussen.add(new Bus (rs.getString("kenteken"), rs.getInt("DeliveryVanID")));
                } catch (SQLException e){
                    System.out.println(e.getMessage());
                }
            }
            pQuery.close();

            return bussen;
        } catch (SQLException e){
            return new ArrayList<>();
        }
    }
    public void insertBus(Bus bus){
        try {
            String query = "INSERT INTO DeliveryVans (" +
                    "DeliveryVanID , " +
                    "kenteken " +
                    ") " +
                    "VALUES (?,?)";
            PreparedStatement pQuery = con.prepareStatement(query);

            pQuery.setInt(1, bus.getBusID());
            pQuery.setString(2, bus.getKenteken());

            int result = pQuery.executeUpdate();

            if (result > 0) {
                System.out.println("successfully executed query!");
            }

            pQuery.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateBusKoerier(Bus bus, Koerier koerier, Route route){
        if (bus != null){
            try {
                if (!BusExixtst(bus)){
                    insertBus(bus);
                }
                String query = "update route set DeliveryVanID = ? " +
                        "where RouteID = ?;";
                PreparedStatement pQuery = con.prepareStatement(query);

                pQuery.setInt(1, bus.getBusID());
                pQuery.setInt(2, route.getID());

                int result = pQuery.executeUpdate();

                if (result > 0) {
                    System.out.println("successfully updated status!");
                }
                pQuery.close();
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
        if (koerier != null){

        }
    }
    public ArrayList<Order> getOrdersToday() {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            String query = "select O.OrderID, CustomerName, C.DeliveryAddressLine1, C.DeliveryAddressLine2, C.DeliveryPostalCode, C.DeliveryLocation, description, orderlineID, Quantity, sectie, opvoorraad " +
                    "from orders O " +
                    "left join customers C on O.CustomerID = C.CustomerID " +
                    "left join orderlines OL on O.OrderID = OL.OrderID " +
                    "where O.ExpectedDeliveryDate = ? AND O.routeID = 0";
            PreparedStatement pQuery = con.prepareStatement(query);

            pQuery.setString(1, date);

            ResultSet rs = pQuery.executeQuery();
            int prevOrderID = -1;
            Order prevOrder = null;
            while (rs.next()) {

                try {

                    if (rs.getInt("O.OrderID") != prevOrderID) {
                        int huisnummer;
                        try {
                            huisnummer = Integer.parseInt(rs.getString("C.DeliveryAddressLine2"));
                        } catch (NumberFormatException e) {
                            System.out.println(e.getMessage());
                            huisnummer = -1;
                        }
                        Order order = new Order(
                                rs.getInt("O.OrderID"),
                                rs.getString("CustomerName"),
                                rs.getString("C.DeliveryAddressLine1"),
                                rs.getString("C.DeliveryPostalCode"),
                                rs.getString("C.DeliveryLocation"),
                                huisnummer,
                                "",
                                false
                        );
                        prevOrder = order;
                        orders.add(order);
                    }
                    int aantal;
                    try {
                        aantal = Integer.parseInt(rs.getString("Quantity"));
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                        aantal = -1;
                    }
                    OrderLine orderLine = new OrderLine(
                            rs.getInt("orderlineID"),
                            rs.getString("sectie"),
                            aantal,
                            rs.getString("description")
                    );
                    try {
                        prevOrder.addOrderline(orderLine);
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    }
                    prevOrderID = rs.getInt("O.OrderID");
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
            pQuery.close();
            //return rs;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return orders;
    }
}

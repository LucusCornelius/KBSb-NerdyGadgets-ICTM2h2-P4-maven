package m2h2.Backoffice.Components.Database;

import m2h2.Backoffice.Components.OrderLine;
import m2h2.Regios.Orders_Met_Coordinaten;

public class DatabaseTestFile {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver geladen");
        } catch (Exception e) {
            System.out.println("oepsie");
            System.out.println(e.getMessage());
        }

        DatabaseConnectie dbCon = new DatabaseConnectie();

        Orders_Met_Coordinaten O = new Orders_Met_Coordinaten("lucas", "Ambonplein", "1094PW", "Amsterdam", 59);
        OrderLine OL = new OrderLine("B", 2, "usb");
        O.addOrderline(OL);

        dbCon.testdb();

    }
}

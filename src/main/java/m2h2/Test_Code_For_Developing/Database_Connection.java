package m2h2.Test_Code_For_Developing;

import m2h2.Console_Color_Codes.ConsoleColorCodes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_Connection {
    public static void main(String[] args) {
        Connection connection = null;
        try {

            connection = DriverManager.getConnection(Credentials.url, Credentials.username, Credentials.password);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(ConsoleColorCodes.ANSI_YELLOW + "#### ----> De connectie was NIET succesvol." + ConsoleColorCodes.ANSI_RESET);
        } finally {

            // Connectie afsluiten
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println(ConsoleColorCodes.ANSI_GREEN + "----> De connectie was succesvol. Het wordt nu gesloten." + ConsoleColorCodes.ANSI_RESET);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
package m2h2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//opzetten bestand
import java.io.File;
import java.io.IOException;

//schrijven bestand
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors


public class PostcodeDataNederland {
    public static void main(String[] args) {

        //Database url
        String url = "";

        try (

                //Database connectie
                Connection connection = DriverManager.getConnection(url);
                Statement statement = connection.createStatement();
        ) {
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            //QUERIES
            ResultSet rs = statement.executeQuery("");

//
//            try {
//                File myObj = new File("/Users/lucasvissers/IdeaProjects/KBSb-NerdyGadgets-ICTM2h2-P4/src/sqlite_queries_outputs/sqlfile1.txt");
//                if (myObj.createNewFile()) {
//                    System.out.println("File created: " + myObj.getName());
//                } else {
//                    System.out.println("File already exists.");
//                }
//            } catch (IOException e) {
//                System.out.println("An error occurred.");
//                e.printStackTrace();
//            }


            while (rs.next()) {
                // Access data from the current row
//                System.out.println(ConsoleColorCodes.ANSI_YELLOW + "ID: " + rs.getString(1) + " "
//                        + ConsoleColorCodes.ANSI_RESET + ConsoleColorCodes.ANSI_BLUE + "MIN_X: " +  rs.getString(2) + " " +
//                        ConsoleColorCodes.ANSI_RESET + ConsoleColorCodes.ANSI_BLUE + "MAX_X: " + rs.getString(3) +
//                        " " + ConsoleColorCodes.ANSI_RESET + ConsoleColorCodes.ANSI_GREEN  + "MIN_Y: " + rs.getString(4) + " " + ConsoleColorCodes.ANSI_RESET +
//                        ConsoleColorCodes.ANSI_GREEN  + "MAX_Y: " + rs.getString(5) + ConsoleColorCodes.ANSI_RESET);
                System.out.println(true);
                try {
                    FileWriter myWriter = new FileWriter("/Users/lucasvissers/IdeaProjects/KBSb-NerdyGadgets-ICTM2h2-P4/src/sqlite_queries_outputs/sqlfile1.txt", true); // Note the second argument `true` for appending
                    myWriter.write("ID: " + rs.getString(1) + "MIN_X: " +  rs.getString(2) + "MAX_X: " + rs.getString(3) + "MIN_Y: " + rs.getString(4) + "MAX_Y: " + rs.getString(5) + "\n"); // Add a newline character at the end
                    myWriter.close();
                    System.out.println("Successfully wrote to the file.");
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }

            System.out.println("Connectie geslaagd");
        } catch (SQLException e) {

            e.printStackTrace(System.err);
        } catch (Exception a) {
            System.out.println("fout: " + a);
        }
    }
}
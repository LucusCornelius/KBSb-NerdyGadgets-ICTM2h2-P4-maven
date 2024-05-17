package m2h2.Backoffice.Components.Database;

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
    }
}

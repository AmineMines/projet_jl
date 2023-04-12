import base_de_donnée.H2DatabaseConnection;
import orowan.OrowanLauncher;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, SQLException {
       //OrowanLauncher a = new OrowanLauncher();
       //a.launch();
        H2DatabaseConnection db = new H2DatabaseConnection();
        db.connection();
        db.ComputeOrowan(20);
       db.closeDatabase();
    }
}
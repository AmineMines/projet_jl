import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2DatabaseConnection {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Chargement du pilote JDBC H2
            Class.forName("org.h2.Driver");

            // Connexion à la base de données
            String url = "jdbc:h2:tcp://localhost/~/test";
            String user = "projetGL";
            String password = "afa";
            conn = DriverManager.getConnection(url, user, password);

            System.out.println("Connexion à la base de données H2 réussie.");
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la base de données H2.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement du pilote JDBC H2.");
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture de la connexion à la base de données H2.");
                e.printStackTrace();
            }
        }
    }
}
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CSVReader {
    public static void main(String[] args) {
        String csvFile = "Fichiers/Krakov/1939351_F2.txt";
        String line = "";
        String csvSeparator = ";";

        try {
            Class.forName("org.h2.Driver").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:tcp://159.31.79.43:8082//~/test");

////            Statement stat = connection.createStatement();
//            stat.executeUpdate("create database MaBD");
//            Statement stat2 = connection.createStatement();
//            //stat.executeUpdate("use MaBD");
//            //sélection de la base de données
//            stat2.executeUpdate("create table ouvrage(id integer primary key, titre char(100) not null, nb_exemplaire integer not null)");
//            stat2.executeUpdate("create table abonne(id integer primary key,nom char(50), prenom char(50), nb_emprunts integer)");
//            stat2.executeUpdate("create table emprunt(ouvrage_id integer not null references ouvrage(id), abonne_id integer not null references abonne(id), date Date not null, primary key(ouvrage_id,abonne_id))");
//            PreparedStatement stat3 = connection.prepareStatement("insert into abonne values(?,?,?,?,?,?,?,?,?,?,?)");


            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(csvSeparator);
                    // Utilisez les données comme vous le souhaitez ici
                    // Par exemple, vous pouvez imprimer chaque valeur dans la console :
    //                for (int i=0; i<data.length;i++) {
     //                   System.out.print(data[i] + " ");
     //                   stat3.setFloat(i, Float.parseFloat(data[i]));
      //                  stat3.executeUpdate();

                    }
                    System.out.println();
                }
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }

    }
}
package orowan;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class OrowanLauncher {

    public  OrowanLauncher(){

    }

    public void launch() throws IOException, InterruptedException {
        try {
            // Lancer le fichier "monfichier.exe"
            Process process = Runtime.getRuntime().exec("src/orowan/Orowan_x64.exe.exe");

            // Obtenir le flux d'entrée du fichier .exe
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));

            // Envoyer une entrée au fichier .exe
            process.getOutputStream().write("i".getBytes());

            // Récupérer la sortie du fichier .exe
            String sortie = "";
            String ligne;
            while ((ligne = in.readLine()) != null) {
                sortie += ligne + "\n";
            }

            // Attendre la fin de l'exécution du fichier .exe
            int exitValue = process.waitFor();
            System.out.println("Le fichier .exe a été exécuté avec le code de sortie : " + exitValue);

            // Afficher la sortie du fichier .exe
            System.out.println("Sortie du fichier .exe : \n" + sortie);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


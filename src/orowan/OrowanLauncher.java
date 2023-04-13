package orowan;
import java.io.*;


public class OrowanLauncher {

    public OrowanLauncher() {

    }

    public void launch(String path) throws IOException, InterruptedException {
        //String arguments = "src/orowan/Orowan_x64.exe.exe";
        String executablePath = "path/to/OrowanConsole_x64.exe";
        String[] arguments = {"src/orowan/Orowan_x64.exe.exe", "i", "c",path, "tv.txt"};

        try {
            // Créer un processus pour l'exécutable
            ProcessBuilder builder = new ProcessBuilder(arguments);

            // Rediriger la sortie standard et d'erreur vers la console
            builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            builder.redirectError(ProcessBuilder.Redirect.INHERIT);

            // Démarrer le processus
            Process process = builder.start();
            // Obtenir le flux de sortie de l'exécutable
            OutputStream stdin = process.getOutputStream();

            // Écrire la commande "i" sur le flux stdin
            String input = "i";
            stdin.write(input.getBytes());
            stdin.write(System.lineSeparator().getBytes());
            stdin.flush();

// Écrire la commande "c" sur le flux stdin
            input = "c";
            stdin.write(input.getBytes());
            stdin.write(System.lineSeparator().getBytes());
            stdin.flush();

            input = path;
            stdin.write(input.getBytes());
            stdin.write(System.lineSeparator().getBytes());
            stdin.flush();

            input = "1.txt";
            stdin.write(input.getBytes());
            stdin.write(System.lineSeparator().getBytes());
            stdin.flush();

// Attendre 10 secondes
            Thread.sleep(5000);

            // Forcer la fermeture de l'exécutable
            process.destroy();

            // Attendre que le processus se termine
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("L'exécutable s'est terminé avec succès.");
            } else {
                System.err.println("L'exécutable s'est terminé avec une erreur. Code de sortie : " + exitCode);
            }

        } catch (IOException e) {
            System.err.println("Erreur lors de l'exécution de l'exécutable : " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Le processus a été interrompu : " + e.getMessage());
        }
    }
}


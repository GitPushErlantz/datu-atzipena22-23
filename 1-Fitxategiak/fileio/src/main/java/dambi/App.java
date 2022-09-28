package dambi;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String input;
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Sartu direktorioaren ruta: ");
            input = in.next();
            Path path = Paths.get(input);
            if(Files.exists(path)) {
                System.out.println("Direktorioa existitzen da!");
            } else {
                System.out.println("Direktorioa ez da existitzen!");
            }
        } catch(Exception e) {
            System.out.println("Errore bat gertatu da");
        }
    }
}

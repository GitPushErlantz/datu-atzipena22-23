package dambi;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //TODO: menu bat gehitu
        int aukera = 9;
        while (aukera != 0) {
            try(Scanner uwu = new Scanner(System.in)) {
                System.out.println("MENUA");
                System.out.println("1. Direktorioa existitzen den begiratu");
                aukera = uwu.nextInt();
                switch(aukera) {
                    case 1:
                        existitzenDa();
                        break;
                    case 2:
                        //TODO
                        break;
                    default:
                        System.out.println("Agur!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("uwu");
            }
         }
    }

    public static void existitzenDa() {
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

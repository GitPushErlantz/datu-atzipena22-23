package dambi;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MainMenua {
    public static void main(String[] args) {
        int aukera = 9;
        Scanner in = new Scanner(System.in);
        System.out.println("* /sys/ Attempting to read file...");
        ArrayList<String> taula = new ArrayList<String>(); //Create the ArrayList so it can be detected everywhere
        try (FileReader inputStream = new FileReader("Mendiak.csv")) { //Try finding the file and creating the FileReader
            System.out.println("* /sys/ File successfully read!");
            //ArrayListera hitzak sartu
            //TODO: ReadLine erabili letraz letra egin ordez
            int ch;
            String word = "";
            while ((ch = inputStream.read()) != -1) {
                if((char)ch != ';' && (char)ch != '\n'){
                    word = word + (char)ch;
                }
                else{
                    taula.add(word);
                    word = "";
                }
            }
            taula.add(word);
        } catch (FileNotFoundException e) {
            System.out.println("* /sys/ File not found");
            System.out.println("* /help/ You're here: " + new File("").getAbsoluteFile()); //helps debugging
            aukera = 0; //not to enter the menu
        } catch (IOException e) {
            System.out.println("* /sys/ An error has occurred.");
        }

        if (aukera != 0) { //to prevent FileNotFoundException
            do {
                System.out.println("MENDIEN MENUA");
                System.out.println("==============================");
                System.out.println("1. Mendien zerrenda ikusi (taula formatuan)");
                System.out.println("2. Mendirik altuena bistaratu");
                System.out.println("3. Mendiak esportatu (Araba.csv, Bizkaia.csv, Gipuzkoa.csv)");
                System.out.println("4. ...");
                System.out.println("0. IRTEN");
                System.out.println();
                System.out.print("Aukeratu zenbaki bat: ");
                aukera = in.nextInt();
                switch (aukera) {
                    case 1:
                        //TODO: zerrenda ikusi
                        zerrenda(taula);
                        break;
                    case 2:
                        //TODO: altuena bistaratu
                        //altuena(taula);
                        break;
                    case 3:
                        //TODO: esportatu
                        //esportatu(taula);
                        break;
                    case 4:
                        break;
                    case 0:
                        //atera
                        System.out.println("Eskerrik asko programa hau erabiltzeagatik.");
                        break;
                    default:
                        System.out.println("Aukera okerra. Saiatu berriz.");
                }
            } while (aukera != 0);
            in.close();
        }
    }

    public static void zerrenda(ArrayList<String> taula) {
        //TODO: Zerrenda formatu onean jarri
    }
}

package dambi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MainMenua {
    public static void main(String[] args) {
        int aukera = 9;
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("* /sys/ Attempting to read file...");
            FileReader InputStream = new FileReader("Mendiak.csv");
            System.out.println("* /sys/ File successfully read!");
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("* /sys/ File not found");
            System.out.println("* /help/ You're here: " + new File("").getAbsoluteFile());
            aukera = 0; //not to enter the menu
        }
        if (aukera != 0) { //to prevent FileNotFoundException
            ArrayList<String> taula = new ArrayList<String>();
            //TODO: ArrayListera datuak sartu
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
        //TODO: ArrayList taula irakurri eta printf batean sartu
    }
}

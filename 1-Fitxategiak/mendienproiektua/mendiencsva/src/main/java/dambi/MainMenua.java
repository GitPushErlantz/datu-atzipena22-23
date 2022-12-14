package dambi;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MainMenua {
    public static void main(String[] args) {
        int aukera = 9;
        Scanner in = new Scanner(System.in);
        //System.out.println("* /sys/ Attempting to read file..."); //TODO: Verbosea kendu
        ArrayList<String> taula = new ArrayList<>(); //Create the ArrayList so it can be detected everywhere
        try (FileReader fr = new FileReader("Mendiak.csv")) { //Try finding the file and creating the FileReader
            //ArrayListera hitzak sartu
            BufferedReader br = new BufferedReader(fr);
            String line;
            line = br.readLine();
            while (line != null) { //while there are new lines
                String[] gehitu; //new array of strings (mendi baten datu denak)
                gehitu = line.split(";");
                Collections.addAll(taula, gehitu);
                line = br.readLine();
            }
            //System.out.println("* /sys/ File successfully read!"); //TODO: Verbosea kendu
        } catch (FileNotFoundException e) {
            System.out.println("* /sys/ File not found");
            System.out.println("* /help/ You're here: " + new File("").getAbsoluteFile()); //helps debugging
            aukera = 0; //not to enter the menu
        } catch (IOException e) {
            System.out.println("* /sys/ An error has occurred.");
        }

        while (aukera != 0) { //to prevent FileNotFoundException
                System.out.println("MENDIEN MENUA");
                System.out.println("==============================");
                System.out.println("1. Mendien zerrenda ikusi (taula formatuan)");
                System.out.println("2. Mendirik altuena bistaratu");
                System.out.println("3. Mendiak esportatu (Araba.csv, Bizkaia.csv, Gipuzkoa.csv)");
                System.out.println("0. IRTEN");
                System.out.println();
                System.out.print("Aukeratu zenbaki bat: ");
                aukera = in.nextInt();
                System.out.println();
            switch (aukera) {
                case 1 -> zerrenda(taula);
                case 2 -> altuena(taula);
                case 3 -> esportatu(taula);
                case 0 ->
                    //atera
                        System.out.println("Agur eta eskerrik asko :)");
                default -> System.out.println("Aukera okerra, saiatu berriz.");
            }
                System.out.println();
            }
            in.close();
        }

    public static void zerrenda(ArrayList<String> taula) {
        for (int i = 0; i < taula.size(); i += 3) { //grabs groups of 3
            for (int j = 0; j <= 2; ++j) { //prints the group of 3
                System.out.printf("%15s", taula.get(i + j));
            }
            System.out.println(); //newline after the group is printed
        }
    }

    public static void altuena(ArrayList<String> taula) {
        int tallest = 0;
        int tallestID = 0;
        for (int i = 3; i < taula.size(); i += 3) { //grabs groups of 3, also skips the title
            if (Integer.parseInt(taula.get(i + 1)) > tallest) {
                tallest = Integer.parseInt(taula.get(i + 1));
                tallestID = i;
            }
        }
        System.out.printf("Mendi altuena %s da %d-eko altuerarekin. \n", taula.get(tallestID), tallest);
    }

    public static void esportatu(ArrayList<String> taula) {
        ArrayList<String> araba = new ArrayList<>();
        ArrayList<String> bizkaia = new ArrayList<>();
        ArrayList<String> gipuzkoa = new ArrayList<>();
        for (int i = 3; i < taula.size(); i += 3) { //grabs groups of 3, also skips the title
                switch (taula.get(i + 2).toLowerCase()) { //separates into arraylists, adds names
                    case "araba" -> araba.add(taula.get(i) + "; " + taula.get(i+1) + "; " + taula.get(i+2)); //Grab name, height, province
                    case "bizkaia" -> bizkaia.add(taula.get(i) + "; " + taula.get(i+1) + "; " + taula.get(i+2));
                    case "gipuzkoa" -> gipuzkoa.add(taula.get(i) + "; " + taula.get(i+1) + "; " + taula.get(i+2));
                }
        }
            idatziBanaka("araba.csv", araba);
            idatziBanaka("gipuzkoa.csv", gipuzkoa);
            idatziBanaka("bizkaia.csv", bizkaia);
    }

    public static void idatziBanaka(String fileName, ArrayList<String> probintzia){
        File csvFile = new File(fileName);
        try (PrintWriter csvWriter = new PrintWriter(new FileWriter(csvFile))) {
            for(int i = 1; i < probintzia.size(); ++i) {
                csvWriter.println(probintzia.get(i));
            }
            System.out.println(fileName + " esportatua!");
        } catch (IOException e) {
            System.out.println("* /sys/ Error (idatziBanaka)");
        }
    }
}

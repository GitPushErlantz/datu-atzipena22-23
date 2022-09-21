package twr;

import java.io.*;
import java.util.Scanner;

//BufferedReader bat erabiliz xanadu.txt irakurriko du eta hitzez hitz erakutsiko du, hitz bakoitza bere lerroan.

public class ScanXan {
    public static void main(String[] args) throws IOException {
        Scanner s = null;

        try {
            s = new Scanner(new BufferedReader(new FileReader("xanadu.txt")));

            while (s.hasNext()) {
                System.out.println(s.next());
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
}
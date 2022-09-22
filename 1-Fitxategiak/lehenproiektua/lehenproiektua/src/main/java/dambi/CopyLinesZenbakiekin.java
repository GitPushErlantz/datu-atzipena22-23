package dambi;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

//CopyLines, baina lerro bakoitzaren hasieran lerro zenbakia jarriko du.

public class CopyLinesZenbakiekin {
    public static void main(String[] args) throws IOException {

        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("xanadu.txt"));
            outputStream = new PrintWriter(new FileWriter("characteroutput.txt"));

            int lineNum = 1;
            String l;
            while ((l = inputStream.readLine()) != null) {
                outputStream.println(lineNum + " " + l);
                ++lineNum;
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}

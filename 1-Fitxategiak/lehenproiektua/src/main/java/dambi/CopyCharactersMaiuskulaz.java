package dambi;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//CopyCharacters, baina kopiako karaktere guztiak maiuskulaz egongo dira.

public class CopyCharactersMaiuskulaz {
    public static void main(String[] args) throws IOException {

        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("./xanadu.txt");
            outputStream = new FileWriter("characteroutput.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
                if (c > 96 && c < 123) {
                    outputStream.write(c - 32);
                } else {
                    outputStream.write(c);
                }
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
package dambi;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//CopyCharacters, baina kopiako "a" guztiak "o"-ren gatik aldatuta egongo dira.

public class CopyCharactersOrdezkatuz {
    public static void main(String[] args) throws IOException {

        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("./xanadu.txt");
            outputStream = new FileWriter("characteroutput.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
                if (c == 97) {
                    outputStream.write(111);
                } else if (c == 65) {
                    outputStream.write(79);
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
package dambi;

import javax.json.Json;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonFitxategiaIrakurri {
    public static void main(String[] args) {
        try {
            JsonReader reader = Json.createReader(new FileReader("data/test.json"));
            JsonStructure jsonst = reader.read();
            System.out.println(jsonst);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}

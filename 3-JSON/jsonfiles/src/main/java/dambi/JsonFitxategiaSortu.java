package dambi;

import javax.json.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class JsonFitxategiaSortu {
    public static void main(String[] args) {
        JsonObject model = Json.createObjectBuilder()
                .add("firstName", "Erlantz")
                .add("lastName", "Garate")
                .add("age", 19)
                .add("streetAddress", "123 Nere etxia")
                .add("city", "Nere herria")
                .add("state", "EH")
                .add("postalCode", "12345")
                .add("phoneNumbers", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                                .add("type", "mobile")
                                .add("number", "688123456"))
                        .add(Json.createObjectBuilder()
                                .add("type", "home")
                                .add("number", "943123456")))
                .build();
        System.out.println(model);
        try(JsonWriter jsonWriter = Json.createWriter(new FileOutputStream("./data/irteera.json"))) {
            jsonWriter.writeObject(model);
        } catch (FileNotFoundException e) {
            System.out.println("errore bat egon da");
        }
    }
}

package za.co.dispenser.utils;

import java.io.StringReader;
import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class JsonUtils {

    public JsonObject getJsonObject(Response response) {
        JsonReader reader = Json.createReader(new StringReader(response.readEntity(String.class)));
        JsonObject jsonObject = reader.readObject();
        reader.close();

        return jsonObject;
    }
}

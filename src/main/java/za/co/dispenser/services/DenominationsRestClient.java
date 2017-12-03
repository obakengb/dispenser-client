package za.co.dispenser.services;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import za.co.dispenser.utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.core.Response;

@Stateless
public class DenominationsRestClient {

    private static final String HOST = "localhost";
    private static final String PORT = "8080";
    private static final String URI = "dispenser-server/rest/DenominationDispenserService/getChangeDenominations";

    private ResteasyWebTarget resteasyWebTarget;

    @Inject
    private JsonUtils jsonUtils;

    public List<String> getDenominations(String change) {
        List<String> strings = new ArrayList<>();
        Response response = getResponse(change);
        JsonObject responseBody = jsonUtils.getJsonObject(response);
        JsonArray jsonArray = responseBody.getJsonArray("denominations");

        for(int i = 0; i < jsonArray.size(); i++) {
            strings.add(jsonArray.get(i).toString());

        }
        return strings;
    }

    private Response getResponse(String change) {
        return getResteasyWebTarget(change).request()
                .get();
    }

    private ResteasyWebTarget getResteasyWebTarget(String change) {

        return new ResteasyClientBuilder()
                .build()
                .target(getServerUrl(change));

    }

    private String getServerUrl(String change) {
        return String.format("http://%s:%s/%s/%s",HOST, PORT,URI,change);
    }

}

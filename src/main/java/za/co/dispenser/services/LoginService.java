package za.co.dispenser.services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

@Singleton
public class LoginService {

    private Map<String,String> users;
    private Set<String> loggedInUsers;

    @PostConstruct
    public void init() {
        users = new HashMap<>();
        loggedInUsers = new HashSet<>();

        users.put("fnbconnect", "connectfnb");
    }

    public boolean loginUser(String username, String password) {
        String user = users.get(username);

        if(user != null) {
            if(user.equals(password)) {
                loggedInUsers.add(username);
                return true;
            }
        }

        return false;
    }
}

package za.co.dispenser.managedbeans;

import za.co.dispenser.services.LoginService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@ManagedBean
@ViewScoped
public class LoginBean {

    private String username;
    private String password;

    @Inject
    private LoginService loginService;

    public String login() {
        if(loginService.loginUser(username, password)) {
            return "/pages/capture_denomination.xhtml";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Please enter the correct credentials"));
            return "";
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

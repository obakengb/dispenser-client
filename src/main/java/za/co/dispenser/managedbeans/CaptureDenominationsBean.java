package za.co.dispenser.managedbeans;

import org.slf4j.Logger;
import za.co.dispenser.services.DenominationsRestClient;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@ManagedBean
@ViewScoped
public class CaptureDenominationsBean {

    private String selectedItem;
    private String selectedRand;
    private String selectedCoin;

    private List<String> denominations;
    private Double change;

    @Inject
    private Logger logger;
    @Inject
    private DenominationsRestClient denominationsRestClient;

    @PostConstruct
    public void init() {
        denominations = new ArrayList<>();
        denominations.add("Make your purchase");
    }

    public void dispenseCash() {
        logger.info("selectedItem = {}, selectedRand = {}, selectedCoin = {}",  selectedItem, selectedRand, selectedCoin);
        change = getChangeAmount();
        if(change > 0) {
            denominations = denominationsRestClient.getDenominations(Double.toString(change));
        } else {
            denominations.add("R0");
        }

    }

    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }

    public String getSelectedRand() {
        return selectedRand;
    }

    public void setSelectedRand(String selectedRand) {
        this.selectedRand = selectedRand;
    }

    public String getSelectedCoin() {
        return selectedCoin;
    }

    public void setSelectedCoin(String selectedCoin) {
        this.selectedCoin = selectedCoin;
    }

    public List<String> getDenominations() {
        return denominations;
    }

    public Double getChange() {
        return change;
    }

    private double getChangeAmount() {
        double price = Double.valueOf(selectedItem.split("@R")[1]);

        double randDenomination = Double.valueOf(selectedRand.split("R")[1]);
        double coinDenomination = 0;

        if(selectedCoin != null && !selectedCoin.isEmpty()) {
             coinDenomination = Double.valueOf(selectedCoin.split("R")[1]);
        }

        if(price > (randDenomination + coinDenomination)) {
            String message = "Amount entered is less than the purchace price. Put in amount greater or equal to your purchase items";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
            return 0;
        } else {
            return (randDenomination + coinDenomination) - price;
        }
    }

}

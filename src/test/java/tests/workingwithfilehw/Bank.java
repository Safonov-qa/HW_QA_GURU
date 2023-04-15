package tests.workingwithfilehw;

import java.util.Map;


public class Bank {
    public String nameClient;
    public String loginClient;
    private Map<String, Object> cards;

    public Map<String, Object> getCards() {
        return cards;
    }
    public void getCards (Map<String, Object> cards) {
        this.cards = cards;
    }
}



package com.bank.app.account;

import com.bank.app.ui.BankApp;
import com.bank.dbactions.DatabaseActions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class LoginVerification {
    public static void verifyCredentials(String accNumber, String pin) {
        JSONArray jsonArr = DatabaseActions.fetchCustomers();

        boolean isCustomer = false;

        for (Object obj : jsonArr) {
            JSONObject jsonObj = (JSONObject) obj;
            String acc = (String)jsonObj.get("accountNumber");
            String myPin = (String)jsonObj.get("pin");

            if(acc.equals(accNumber) && myPin.equals(pin)) {
                isCustomer = true;
                break;
            }
        }

        if(!isCustomer) {
            System.out.println("Incorrect credentials");
            BankApp.menu();
        }
    }
}

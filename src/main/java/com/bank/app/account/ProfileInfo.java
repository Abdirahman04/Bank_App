package com.bank.app.account;

import com.bank.dbactions.DatabaseActions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.text.NumberFormat;

public class ProfileInfo {
    public static void profileInfo(String accNumber) {
        JSONArray jsonArr = DatabaseActions.fetchCustomers();
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        String acc="*****",name="name",email="email";
        double amount = 0;
        String newAmount = "0";

        for (Object obj : jsonArr) {
            JSONObject jsonObj = (JSONObject) obj;
            acc = (String) jsonObj.get("accountNumber");

            if(acc.equals(accNumber)) {
                name = (String)jsonObj.get("name");
                email = (String)jsonObj.get("email");
                amount = Double.parseDouble((String) jsonObj.get("amount"));
                newAmount = formatter.format(amount);
                break;
            }
        }

        System.out.println("Name:  " + name);
        System.out.println("Email:  " + email);
        System.out.println("Account Number:  " + acc);
        System.out.println("Amount:  " + newAmount);
    }
}

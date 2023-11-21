package com.bank.app.ui;

import com.bank.dbactions.DatabaseActions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.text.NumberFormat;

public class PreviousTransactions {
    public static void viewTransactions(String accNUmber) {
        JSONArray jArr = DatabaseActions.fetchTransactions();
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        int count = 1;

        for(Object obj : jArr) {
            JSONObject jObj = (JSONObject) obj;
            if(jObj.get("accountNumber").equals(accNUmber)) {
                System.out.println(count + ". >>");
                System.out.println("     +--------------------------------------+");
                System.out.println("     |  Transaction Type: " + jObj.get("TransactionType"));
                System.out.println("     |  Amount: " + formatter.format(Double.parseDouble((String) jObj.get("amount"))));
                System.out.println("     +--------------------------------------+");
                count++;
            }
        }
        Profile.profile(accNUmber);
    }
}

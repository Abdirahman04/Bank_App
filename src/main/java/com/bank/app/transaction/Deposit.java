package com.bank.app.transaction;

import com.bank.dbactions.DatabaseActions;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class Deposit {
    public static void depositMoneyHandler(double amount, String accNumber) {
        JSONArray transactArr = DatabaseActions.fetchTransactions();
        JSONArray jsonArr = DatabaseActions.fetchCustomers();
        JSONArray newJsonArr = new JSONArray();

        for(Object obj : jsonArr) {
            JSONObject jObj = (JSONObject) obj;
            if(jObj.get("accountNumber").equals(accNumber)) {
                String oldAmount = (String) jObj.get("amount");
                jObj.remove("amount");
                String newAmount = Double.toString(amount + Double.parseDouble(oldAmount));
                jObj.put("amount", newAmount);
                newJsonArr.add(jObj);
                continue;
            }
            newJsonArr.add(jObj);
        }

        JSONObject transactObj = new JSONObject();
        transactObj.put("TransactionType","deposit");
        transactObj.put("amount",Double.toString(amount));
        transactObj.put("accountNumber",accNumber);

        transactArr.add(transactObj);

        DatabaseActions.writeJsonFile(newJsonArr);
        DatabaseActions.writeTransactionsFile(transactArr);
    }
}

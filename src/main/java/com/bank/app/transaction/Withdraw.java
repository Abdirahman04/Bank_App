package com.bank.app.transaction;

import com.bank.dbactions.DatabaseActions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Withdraw {
    public static void withdrawMoneyHandler(double amount, String accNumber) {
        JSONArray transactArr = DatabaseActions.fetchTransactions();
        JSONArray jsonArr = DatabaseActions.fetchCustomers();
        JSONArray newJsonArr = new JSONArray();

        for(Object obj : jsonArr) {
            JSONObject jObj = (JSONObject) obj;
            if(jObj.get("accountNumber").equals(accNumber)) {
                String oldAmount = (String) jObj.get("amount");
                jObj.remove("amount");
                String newAmount = Double.toString(Double.parseDouble(oldAmount) - amount);
                jObj.put("amount", newAmount);
                newJsonArr.add(jObj);
                continue;
            }
            newJsonArr.add(jObj);
        }

        JSONObject transactObj = new JSONObject();
        transactObj.put("TransactionType","withdrawal");
        transactObj.put("amount",Double.toString(amount));
        transactObj.put("accountNumber",accNumber);

        transactArr.add(transactObj);

        DatabaseActions.writeJsonFile(newJsonArr);
        DatabaseActions.writeTransactionsFile(transactArr);
    }
}

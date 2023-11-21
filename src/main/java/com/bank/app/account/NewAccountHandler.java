package com.bank.app.account;

import com.bank.app.models.Customer;
import com.bank.dbactions.DatabaseActions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class NewAccountHandler {
    @SuppressWarnings("unchecked")
    public static void newAccount( Customer user){
        JSONArray jsonArr = DatabaseActions.fetchCustomers();

        JSONObject obj = new JSONObject();
        obj.put("accountNumber", user.getAccountNumber());
        obj.put("name", user.getName());
        obj.put("email", user.getEmail());
        obj.put("pin", user.getPin());
        obj.put("amount", Double.toString(user.getAmount()));

        jsonArr.add(obj);

        DatabaseActions.writeJsonFile(jsonArr);

    }
}
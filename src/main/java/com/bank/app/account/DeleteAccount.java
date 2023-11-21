package com.bank.app.account;

import com.bank.dbactions.DatabaseActions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DeleteAccount {
    public static void deleteThisAccount(String accNumber) {
        JSONArray jArr = DatabaseActions.fetchCustomers();
        JSONArray transactionArr = DatabaseActions.fetchTransactions();

        for(Object obj : jArr) {
            JSONObject jObj = (JSONObject) obj;
            if(jObj.get("accountNumber").equals(accNumber)) {
                jArr.remove(obj);
                for(Object obj2 : transactionArr) {
                    JSONObject jObj2 = (JSONObject) obj;
                    if(jObj2.get("accountNumber").equals(accNumber)) {
                        transactionArr.remove(obj2);
                    }
                }
                break;
            }
        }

        DatabaseActions.writeJsonFile(jArr);
    }
}

package com.bank.app.transaction;

import com.bank.dbactions.DatabaseActions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Transfer {
    public static void transferFunction(Double amount,String accNumber,int recipientAccNumber) {
        String recipient = Integer.toString(recipientAccNumber);
        JSONArray jArr = DatabaseActions.fetchCustomers();
        JSONArray transactArr = DatabaseActions.fetchTransactions();
        JSONArray newJsonArr = new JSONArray();

        for(Object obj : jArr) {
            JSONObject jObj = (JSONObject) obj;
            if(jObj.get("accountNumber").equals(accNumber)) {
                for(Object secondObj : jArr) {
                    JSONObject secondJObj = (JSONObject) secondObj;
                    if(secondJObj.get("accountNumber").equals(recipient)) {
                        String oldAmount1 = (String) jObj.get("amount");
                        jObj.remove("amount");
                        String newAmount1 = Double.toString(Double.parseDouble(oldAmount1) - amount);
                        jObj.put("amount", newAmount1);

                        String oldAmount2 = (String) secondJObj.get("amount");
                        secondJObj.remove("amount");
                        String newAmount2 = Double.toString(Double.parseDouble(oldAmount2) + amount);
                        secondJObj.put("amount", newAmount2);

                        newJsonArr.add(jObj);
                        newJsonArr.add(secondObj);

                        continue;
                    }
                }
            } else if (jObj.get("accountNumber").equals(recipient)) {
                continue;
            }

            JSONObject transactObj1 = new JSONObject();
            transactObj1.put("TransactionType","sent");
            transactObj1.put("amount",Double.toString(amount));
            transactObj1.put("accountNumber",accNumber);

            JSONObject transactObj2 = new JSONObject();
            transactObj2.put("TransactionType","received");
            transactObj2.put("amount",Double.toString(amount));
            transactObj2.put("accountNumber",recipient);

            transactArr.add(transactObj1);
            transactArr.add(transactObj2);

            DatabaseActions.writeJsonFile(newJsonArr);
            DatabaseActions.writeTransactionsFile(transactArr);
        }
    }
}

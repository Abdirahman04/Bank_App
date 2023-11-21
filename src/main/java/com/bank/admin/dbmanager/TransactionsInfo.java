package com.bank.admin.dbmanager;

import com.bank.dbactions.DatabaseActions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TransactionsInfo {
    public static ArrayList<Map<String,String>> getData() {
        JSONArray dataArr = DatabaseActions.fetchTransactions();
        ArrayList<Map<String,String>> transactions = new ArrayList<>();

        for(Object obj : dataArr) {
            JSONObject jObj = (JSONObject) obj;
            Map<String,String> transactionInfo = new HashMap<>();
            transactionInfo.put("accountNumber",(String)jObj.get("accountNumber"));
            transactionInfo.put("transaction",(String)jObj.get("TransactionType"));
            transactionInfo.put("amount",(String)jObj.get("amount"));

            transactions.add(transactionInfo);
        }

        return transactions;
    }
}

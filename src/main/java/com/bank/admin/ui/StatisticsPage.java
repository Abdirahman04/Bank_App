package com.bank.admin.ui;

import com.bank.dbactions.DatabaseActions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.text.NumberFormat;

public class StatisticsPage {
    public static void viewStatistics() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        System.out.println(">>>>>     STATISTICS     <<<<<");

        JSONArray jArr = DatabaseActions.fetchCustomers();
        int customerCount = 0;
        double totalAmount = 0;

        for (Object obj : jArr) {
            JSONObject jObj = (JSONObject) obj;
            totalAmount += Double.parseDouble((String) jObj.get("amount"));

            customerCount++;
        }
        String totalMoney = formatter.format(totalAmount);

        JSONArray transactionArr = DatabaseActions.fetchTransactions();
        int withdrawCount = 0;
        int depositCount = 0;
        int transferCount = 0;

        for(Object obj : transactionArr) {
            JSONObject jObj = (JSONObject) obj;
            if(jObj.get("TransactionType").equals("withdrawal")) withdrawCount++;
            if(jObj.get("TransactionType").equals("deposit")) depositCount++;
            if(jObj.get("TransactionType").equals("sent")) transferCount++;
        }

        System.out.println("+-----------------------------------------------------");
        System.out.println("|                                                    |");
        System.out.println("|  Total number of customers: " + customerCount);
        System.out.println("|");
        System.out.println("|  Total amount of money in the bank: " + totalMoney);
        System.out.println("|");
        System.out.println("|  Total withdrawals made: " + withdrawCount);
        System.out.println("|");
        System.out.println("|  Total deposits made: " + depositCount);
        System.out.println("|");
        System.out.println("|  Total transfers made: " + transferCount);
        System.out.println("|                                                    |");
        System.out.println("+-----------------------------------------------------");
    }
}

package com.bank.admin.ui;

import com.bank.admin.dbmanager.CustomersInfo;
import com.bank.admin.dbmanager.TransactionsInfo;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Map;

public class TransactionsInfoPage {
    public static void displayTransactionsInfo() {
        System.out.println(">>>>>     TRANSACTIONS INFORMATION     <<<<<");
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        ArrayList<Map<String,String>> transactionsArray = TransactionsInfo.getData();
        int count = 1;

        for(Map<String,String> map : transactionsArray) {
            System.out.println(count + ". >>>");
            System.out.println("     +--------------------------------------+");
            System.out.println("     |  Account Number: " + map.get("accountNumber"));
            System.out.println("     |  Transaction Type: " + map.get("transaction"));
            System.out.println("     |  Amount: " + formatter.format(Math.floor(Double.parseDouble(map.get("amount")))));
            System.out.println("     +--------------------------------------+");
            count++;
        }
    }
}

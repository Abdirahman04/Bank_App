package com.bank.admin.ui;

import com.bank.admin.dbmanager.CustomersInfo;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Map;

public class CustomersInfoPage {
    public static void displayCustomersInfo() {
        System.out.println(">>>>>     CUSTOMERS INFORMATION     <<<<<");
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        ArrayList<Map<String,String>> customersArray = CustomersInfo.handleCustomers();
        int count = 1;

        for(Map<String,String> map : customersArray) {
            System.out.println(count + ". >>>");
            System.out.println("     +--------------------------------------+");
            System.out.println("     |  Account Number: " + map.get("accountNumber"));
            System.out.println("     |  Name: " + map.get("name"));
            System.out.println("     |  Email: " + map.get("email"));
            System.out.println("     |  Amount: " + formatter.format(Math.floor(Double.parseDouble(map.get("amount")))));
            System.out.println("     |  Pin: " + map.get("pin"));
            System.out.println("     +--------------------------------------+");
            count++;
        }
    }
}

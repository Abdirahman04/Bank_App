package com.bank.admin.ui;

import com.bank.app.ui.BankApp;

import java.util.Scanner;

public class AdminPage {
    public static void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println(">>>>>     BANK DATABASE MANAGER     <<<<<\n");
        System.out.println("1. <Customers Information>");
        System.out.println("2. <Transactions Information>");
        System.out.println("3. <Statistics>");
        System.out.println("4. <Switch to Bank App>");

        System.out.print(">>>>>    ");
        String ans = sc.nextLine();

        if(ans.equals("1")) CustomersInfoPage.displayCustomersInfo();
        if(ans.equals("2")) TransactionsInfoPage.displayTransactionsInfo();
        if(ans.equals("3")) StatisticsPage.viewStatistics();
        if(ans.equals("4")) BankApp.menu();
        if(ans.equals("exit")) System.exit(0);
        else menu();
        BankApp.menu();
    }
}

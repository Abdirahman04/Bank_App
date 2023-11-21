package com.bank.app.ui;

import com.bank.admin.ui.AdminPage;

import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        System.out.println("WELCOME TO THE NATIONAL BANK OF KENYA");

        menu();
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println(">>>>>     BANK APP     <<<<<\n");
        System.out.println("1. <Login>");
        System.out.println("2. <Create New Account>");
        System.out.println("3. <Switch to Database Manager>");
        System.out.println("4. <Help>");
        System.out.print(">>>>>>>>>>    ");

        String ans = sc.nextLine();

        if(ans.equals("1")) Login.login();
        if(ans.equals("2")) CreateAccount.createAccount();
        if(ans.equals("3")) AdminPage.menu();
        if(ans.equals("exit")) System.exit(0);
        if(ans.equals("4")) {
            System.out.println("Enter \"exit\" to terminate the program\n\n");
            menu();
        }
        else menu();
    }
}

package com.bank.app.ui;

import com.bank.app.transaction.Deposit;

import java.util.Scanner;

public class DepositMoney {
    public static void depositCash(String accNumber) {
        System.out.println(">>>>>     DEPOSIT MONEY     <<<<<");
        System.out.println("How much do you want to deposit?");
        System.out.print(">>>>>     ");

        Scanner sc = new Scanner(System.in);
        double amount = sc.nextDouble();

        Deposit.depositMoneyHandler(amount,accNumber);
        System.out.println("Money deposited successfully!");
        HomePage.displayHomepage(accNumber);
    }
}

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

        if(amount <= 20) {
            System.out.println("!!!  The amount deposited should not be less than 20  !!!");
            depositCash(accNumber);
        }

        Deposit.depositMoneyHandler(amount,accNumber);
        System.out.println("Money deposited successfully!");
        HomePage.displayHomepage(accNumber);
    }
}

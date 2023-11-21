package com.bank.app.ui;

import com.bank.app.transaction.Deposit;
import com.bank.app.transaction.Withdraw;

import java.util.Scanner;

public class WithdrawMoney {
    public static void withdrawCash(String accNumber) {
        System.out.println(">>>>>     DEPOSIT MONEY     <<<<<");
        System.out.println("How much do you want to deposit?");
        System.out.print(">>>>>     ");

        Scanner sc = new Scanner(System.in);
        double amount = sc.nextDouble();

        Withdraw.withdrawMoneyHandler(amount,accNumber);
        System.out.println("Money deposited successfully!");
        HomePage.displayHomepage(accNumber);
    }
}

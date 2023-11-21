package com.bank.app.ui;

import com.bank.app.transaction.Withdraw;
import com.bank.dbactions.DatabaseActions;
import org.json.simple.JSONObject;

import java.util.Scanner;

public class WithdrawMoney {
    public static void withdrawCash(String accNumber) {
        System.out.println(">>>>>     DEPOSIT MONEY     <<<<<");
        System.out.println("How much do you want to deposit?");
        System.out.print(">>>>>     ");

        Scanner sc = new Scanner(System.in);
        double amount = sc.nextDouble();

        JSONObject jObj = DatabaseActions.getSingleCustomer(accNumber);

        if(amount > Double.parseDouble((String) jObj.get("amount"))) {
            System.out.println("The amount is more than what you have!!");
            withdrawCash(accNumber);
        }

        Withdraw.withdrawMoneyHandler(amount,accNumber);
        System.out.println("Money deposited successfully!");
        HomePage.displayHomepage(accNumber);
    }
}

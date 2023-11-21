package com.bank.app.ui;

import java.util.Scanner;

public class HomePage {
    public static void displayHomepage(String accNumber) {
        Scanner sc = new Scanner(System.in);
        System.out.println("     1. <Profile>");
        System.out.println("     2. <Deposit money>");
        System.out.println("     3. <Withdraw money>");
        System.out.println("     4. <Send money>");
        System.out.println("     5. <Go back to main menu>");
        System.out.print(">>>>>>>>>>    ");

        String ans = sc.nextLine();

        if(ans.equals("1")) Profile.profile(accNumber);
        if(ans.equals("2")) DepositMoney.depositCash(accNumber);
        if(ans.equals("3")) WithdrawMoney.withdrawCash(accNumber);
        if(ans.equals("4")) TransferMoney.sendCash(accNumber);
        if(ans.equals("5")) BankApp.menu();
        else displayHomepage(accNumber);
    }
}

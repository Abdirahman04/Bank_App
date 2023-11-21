package com.bank.app.ui;

import com.bank.app.account.DeleteAccount;
import com.bank.app.account.ProfileInfo;

import java.util.Scanner;

public class Profile {
    public static void profile(String accNumber) {
        System.out.println(">>>>>     PROFILE     <<<<<\n");
        ProfileInfo.profileInfo(accNumber);
        System.out.println("1.  <View previous transactions>");
        System.out.println("2.  <Delete account>");
        System.out.println("3.  <Back>");

        Scanner sc = new Scanner(System.in);
        String ans = sc.nextLine();

        if(ans.equals("1")) PreviousTransactions.viewTransactions(accNumber);
        else if(ans.equals("3")) HomePage.displayHomepage(accNumber);
        else if(ans.equals("2")) {
            System.out.println("Are you sure you want to delete your account! [y/n]");
            System.out.print(">>>>    ");

            String deleteAns = sc.nextLine();

            if(deleteAns.equals("y")) {
                DeleteAccount.deleteThisAccount(accNumber);
                System.out.println("Account deleted successfully");
                BankApp.menu();
            }
        }
    }
}

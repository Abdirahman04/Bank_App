package com.bank.app.ui;

import com.bank.app.account.LoginVerification;
import com.bank.validation.InputValidator;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Login {
    public static void login() {
        Scanner sc = new Scanner(System.in);

        System.out.println(">>>>>>>>>>  LOGIN  <<<<<<<<<<");
        System.out.println("Enter your account number and pin");

        System.out.print("Enter account number: ");
        String accountNumber = accNum(sc);

        System.out.print("Enter a PIN: ");
        String pin = pin(sc);

        LoginVerification.verifyCredentials(accountNumber, pin);
        System.out.println("Login successful!");
        HomePage.displayHomepage(accountNumber);
    }

    public static String accNum(@NotNull Scanner sc) {
        String accNum = sc.nextLine();
        while (!InputValidator.isNumber(accNum) || (accNum.length() < 8 || accNum.length() > 10)) {
            System.out.println("!!!!  Not a number/Account number should be 8-10 digits long  !!!!");
            System.out.print("Enter your account number: ");
            accNum = sc.nextLine();
        }
        return accNum;
    }
    public static String pin(@NotNull Scanner sc) {
        String pin = sc.nextLine();
        while (!InputValidator.isNumber(pin) || pin.length() != 4) {
            System.out.println("!!!!  Not a number/Your pin should be 4 digits long  !!!!");
            System.out.print("Enter your pin: ");
            pin = sc.nextLine();
        }
        return pin;
    }
}

package com.bank.app.ui;

import com.bank.app.account.NewAccountHandler;
import com.bank.app.models.Customer;
import com.bank.validation.InputValidator;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class CreateAccount {
    public static void createAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println(">>>>>>>>>>  Create new account  <<<<<<<<<<");

        System.out.print("Enter your name: ");
        String name = name(sc);

        System.out.print("Enter your email address: ");
        String email = email(sc);

        System.out.print("Enter account number: ");
        String accountNumber = accNum(sc);

        System.out.print("Enter a PIN: ");
        String pin = pin(sc);

        Customer user = new Customer();
        user.setAccountNumber(accountNumber);
        user.setName(name);
        user.setEmail(email);
        user.setPin(pin);

        NewAccountHandler.newAccount(user);
        System.out.println("New account created successfully!");
        HomePage.displayHomepage(accountNumber);
    }
    public static String name(@NotNull Scanner sc) {
        String name = sc.nextLine();
        return name;
    }
    public static String email(@NotNull Scanner sc) {
        String email = sc.nextLine();
        while(!InputValidator.isValidEmail(email) || InputValidator.emailExists(email)) {
            System.out.println("!!!!  Not a valid email/Email already exists  !!!!");
            System.out.print("Enter your email address: ");
            email = sc.nextLine();
        }
        return email;
    }
    public static String accNum(@NotNull Scanner sc) {
        String accNum = sc.nextLine();
        while (!InputValidator.isNumber(accNum) || (accNum.length() < 8 || accNum.length() > 10) || InputValidator.accountNumberExists(accNum)) {
            System.out.println("!!!!  Not a number/Account number should be 8-10 digits long/Account number already exists  !!!!");
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

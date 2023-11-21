package com.bank.app.ui;

import com.bank.app.transaction.Transfer;

import java.util.Scanner;

public class TransferMoney {
    public static void sendCash(String accNumber) {
        System.out.println(">>>>>     TRANSFER MONEY     <<<<<\n");

        Scanner sc = new Scanner(System.in);

        System.out.println("How much do you want to transfer?");
        System.out.print(">>>>>     ");
        double amount = sc.nextDouble();

        System.out.println("Who are you transferring to?");
        System.out.print(">>>>>     ");
        int recipientAccNumber = sc.nextInt();

        Transfer.transferFunction(amount,accNumber,recipientAccNumber);

        System.out.println("Money sent successfully!");
        HomePage.displayHomepage(accNumber);
    }
}

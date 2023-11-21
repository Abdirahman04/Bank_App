package com.bank.app.ui;

import com.bank.app.transaction.Transfer;
import com.bank.dbactions.DatabaseActions;
import org.json.simple.JSONObject;

import java.util.Scanner;

public class TransferMoney {
    public static void sendCash(String accNumber) {
        System.out.println(">>>>>     TRANSFER MONEY     <<<<<\n");

        Scanner sc = new Scanner(System.in);

        System.out.println("How much do you want to transfer?");
        System.out.print(">>>>>     ");
        double amount = sc.nextDouble();

        JSONObject jObj = DatabaseActions.getSingleCustomer(accNumber);

        if(amount > Double.parseDouble((String) jObj.get("amount"))) {
            System.out.println("You do not have enough funds to send!!");
            sendCash(accNumber);
        }

        System.out.println("Who are you transferring to?");
        System.out.print(">>>>>     ");
        int recipientAccNumber = sc.nextInt();

        Transfer.transferFunction(amount,accNumber,recipientAccNumber);

        System.out.println("Money sent successfully!");
        HomePage.displayHomepage(accNumber);
    }
}

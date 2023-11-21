package com.bank.dbactions;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DatabaseActions {
    public static JSONArray fetchCustomers() {
        JSONParser parser = new JSONParser();
        JSONArray jsonArr = new JSONArray();
        try {
            Object newArr = parser.parse(new FileReader("src//main//resources//bankdb//CustomersInfo.json"));
            jsonArr = (JSONArray) newArr;
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

        return jsonArr;
    }

    public static void writeJsonFile(JSONArray jArr) {
        try (FileWriter file = new FileWriter("src//main//resources//bankdb//CustomersInfo.json")){
            file.write(jArr.toString());
            file.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONArray fetchTransactions() {
        JSONParser parser = new JSONParser();
        JSONArray jsonArr = new JSONArray();
        try {
            Object newArr = parser.parse(new FileReader("src//main//resources//bankdb//TransactionsInfo.json"));
            jsonArr = (JSONArray) newArr;
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

        return jsonArr;
    }

    public static void writeTransactionsFile(JSONArray jArr) {
        try (FileWriter file = new FileWriter("src//main//resources//bankdb//TransactionsInfo.json")){
            file.write(jArr.toString());
            file.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

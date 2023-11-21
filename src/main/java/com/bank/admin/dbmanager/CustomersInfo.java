package com.bank.admin.dbmanager;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CustomersInfo {
    public static ArrayList<Map<String,String>> handleCustomers() {
        JSONParser parser = new JSONParser();
        JSONArray jsonArr = new JSONArray();
        ArrayList<Map<String,String>> customers = new ArrayList<>();
        try {
            Object newArr = parser.parse(new FileReader("src//main//resources//bankdb//CustomersInfo.json"));
            jsonArr = (JSONArray) newArr;
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

        for (Object obj : jsonArr) {
            JSONObject jObj = (JSONObject) obj;
            Map<String,String> customersInfo = new HashMap<>();
            customersInfo.put("accountNumber",(String)jObj.get("accountNumber"));
            customersInfo.put("name",(String)jObj.get("name"));
            customersInfo.put("email",(String)jObj.get("email"));
            customersInfo.put("amount",(String)jObj.get("amount"));
            customersInfo.put("pin",(String)jObj.get("pin"));

            customers.add(customersInfo);
        }

        return customers;
    }
}

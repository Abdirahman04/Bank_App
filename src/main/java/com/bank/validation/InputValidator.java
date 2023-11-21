package com.bank.validation;

import com.bank.dbactions.DatabaseActions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);
    public static boolean isValidEmail(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public static boolean emailExists(String email) {
        boolean exists = false;

        JSONArray jArr = DatabaseActions.fetchCustomers();

        for(Object obj : jArr) {
            JSONObject jObj = (JSONObject) obj;
            if(jObj.get("email").equals(email)) {
                exists = true;
                break;
            }
        }

        return exists;
    }
    public static boolean accountNumberExists(String accNumber) {
        boolean exists = false;

        JSONArray jArr = DatabaseActions.fetchCustomers();

        for(Object obj : jArr) {
            JSONObject jObj = (JSONObject) obj;
            if(jObj.get("accountNumber").equals(accNumber)) {
                exists = true;
                break;
            }
        }

        return exists;
    }

    public static boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}

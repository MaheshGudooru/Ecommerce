package com.techouts.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public final class HashPasswordUtil {

    private HashPasswordUtil() {}

    public static String getHashedPassword(String userPassword) {

        try{

            MessageDigest digest = MessageDigest.getInstance ("SHA-256");
            byte[] hashedPasswordBytes = digest.digest (userPassword.getBytes ());

            return Base64.getEncoder ().encodeToString (hashedPasswordBytes);

        } catch (NoSuchAlgorithmException e) {
            System.err.println ("Exception in HashPasswordUtil class");
            System.err.println (e);
        }

        return userPassword;

    }

    public static boolean verifyUserPassword(String userInputPassword, String DBHashedPassword) {

        return DBHashedPassword.equals (getHashedPassword (userInputPassword));

    }

    public static boolean isValidPassword(String password) {

        if(password.length() < 6) return false;

        String specialChars = "!@#$%^&*";

        boolean hasUpperCase = false;
        boolean hasSpecialChar = false;
        boolean hasNumber = false;

        for(char c : password.toCharArray()) {

            if(Character.isUpperCase(c)) {
                hasUpperCase = true;
            }

            if(Character.isDigit(c)) {
                hasNumber = true;
            }

            if(specialChars.contains(c + "")) {
                hasSpecialChar = true;
            }

        }

        return hasUpperCase && hasNumber && hasSpecialChar;

    }
}

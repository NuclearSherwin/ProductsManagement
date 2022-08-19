/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsmanagement.upgrade;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 *
 * @author phong
 */
public class Validator {

    // checking name when user input
    public static boolean checkName(JTextField feild, StringBuilder stringBuilder, String message) {
        // create variable validata for update status
        boolean isValidate = true;

        if (!checkEmpty(feild, stringBuilder, "Name is not empty!")) {
            return false;
        }

        try {
            String name = feild.getText();
            Pattern pattern = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
            Matcher matcher = pattern.matcher(name);
            boolean isSpecial = matcher.find();

            char[] chars = name.toCharArray();
            for (char c : chars) {
                if (Character.isDigit(c)) {
                    stringBuilder.append("Name does not contains number!");
                    stringBuilder.append(message).append("\n");
                    feild.setBackground(new Color(214, 0, 0, 116));
                }
            }
            // for special characters
            if (isSpecial) {
                stringBuilder.append("Name does not contains special characters!");
                stringBuilder.append(message).append("\n");
                feild.setBackground(new Color(214, 0, 0, 116));
            }

        } catch (Exception e) {
            stringBuilder.append("The value of name is not type of string!");
            System.out.println("Name error: " + e.getMessage());
            isValidate = false;
        }

        if (isValidate) {
            feild.setBackground(Color.white);
        }

        return isValidate;
    }

    // checking Quanitty when user input
    public static boolean checkQuantity(JTextField feild, StringBuilder stringBuilder) {
        boolean isValidate = true;

        if (!checkEmpty(feild, stringBuilder, "Quanity is not empty!")) {
            return false;
        }

        try {
            int quantity = Integer.parseInt(feild.getText());
            feild.setBackground(new Color(204, 0, 0, 21));

            if (quantity <= 0) {
                stringBuilder.append("The quantity can not smaller than 1");
                feild.setBackground(new Color(204, 0, 0, 21));
                isValidate = false;
            }

        } catch (Exception e) {
            stringBuilder.append("The value of Quanity must be a number!");
            System.out.println("Quanity error: " + e.getMessage());
            isValidate = false;
        }

        if (isValidate) {
            feild.setBackground(Color.white);
        }

        return isValidate;
    }

    // checking Description when user input
    public static boolean checkDescription(JTextField feild, StringBuilder stringBuilder) {
        boolean isValidate = true;

        if (!checkEmpty(feild, stringBuilder, "Description is not empty!")) {
            return false;
        }

        try {
            String description = feild.getText();
            feild.setBackground(new Color(204, 0, 0, 21));

        } catch (Exception e) {
            stringBuilder.append("Description is not empty");
            System.out.println("Description error: " + e.getMessage());
            isValidate = false;
        }

        if (isValidate) {
            feild.setBackground(Color.white);
        }

        return isValidate;
    }

    // checking cetegory when user input
    public static boolean checkCategory(JTextField feild, StringBuilder stringBuilder) {
        boolean isValidate = true;

        if (!checkEmpty(feild, stringBuilder, "Category is not empty!")) {
            return false;
        }

        try {
            String category = feild.getText();
            feild.setBackground(new Color(204, 0, 0, 21));

        } catch (Exception e) {
            stringBuilder.append("The value of category must be a string!");
            System.out.println("Category error: " + e.getMessage());
            isValidate = false;
        }

        if (isValidate) {
            feild.setBackground(Color.white);
        }

        return isValidate;
    }

    // checking shop when user input
    public static boolean checkShop(JTextField feild, StringBuilder stringBuilder) {
        boolean isValidate = true;

        if (!checkEmpty(feild, stringBuilder, "Shop is not empty!")) {
            return false;
        }

        try {
            String shopName = feild.getText();
            feild.setBackground(new Color(204, 0, 0, 21));

        } catch (Exception e) {
            stringBuilder.append("The value of shop must be a string!");
            System.out.println("Shop name error: " + e.getMessage());
            isValidate = false;
        }

        if (isValidate) {
            feild.setBackground(Color.white);
        }

        return isValidate;
    }
    // checking production when user input

    public static boolean checkProductionDate(JTextField feild, StringBuilder stringBuilder) {
        boolean isValidate = true;

        if (!checkEmpty(feild, stringBuilder, "Production date is not empty!")) {
            return false;
        }

        try {
            String productionDate = feild.getText();
            feild.setBackground(new Color(204, 0, 0, 21));

        } catch (Exception e) {
            stringBuilder.append("The production date must be like 2022-03-01 or 20220301!");
            System.out.println("Production date  error: " + e.getMessage());
            isValidate = false;
        }

        if (isValidate) {
            feild.setBackground(Color.white);
        }

        return isValidate;
    }

    // check price
    public static boolean checkProductPrice(JTextField feild, StringBuilder stringBuilder) {
        boolean isValidate = true;

        if (!checkEmpty(feild, stringBuilder, "Price is not empty!")) {
            return false;
        }

        try {
            double price = Integer.parseInt(feild.getText());
            feild.setBackground(new Color(204, 0, 0, 21));

        } catch (Exception e) {
            stringBuilder.append("Price is have to number!");
            System.out.println("Production date  error: " + e.getMessage());
            isValidate = false;
        }

        if (isValidate) {
            feild.setBackground(Color.white);
        }

        return isValidate;
    }

    // checking empty when user input
    public static boolean checkEmpty(JTextField feild, StringBuilder stringBuilder, String message) {
        boolean isValidate = true;
        if (feild.getText().equals("")) {
            stringBuilder.append(message).append("\n");
            feild.setBackground(new Color(214, 0, 0, 116));
            isValidate = false;
        } else {
            feild.setBackground(Color.white);
        }
        return isValidate;
    }
}
package org.example.util;

import java.math.BigDecimal;

public class Utils {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static String[] parseString(String source) {
        String[] dest = source.split("; ");
        String[] temp = dest[0].split(" ");
        dest[0] = temp[temp.length - 1];
        return dest;
    }

    public static boolean checkInputStringValue(String source) {
        source = source.trim();
        boolean res;
        if (source.equals("")) {
            System.out.println(ANSI_RED + "Parameter value can't be empty" + ANSI_RESET);
            res = false;
        } else {
            res = true;
        }
        return res;
    }

    public static boolean checkInputIntegerValue(String source) {
        boolean temp = checkInputStringValue(source);
        if (temp) {
            int res = 0;
            try {
                res = Integer.parseInt(source);
                if (res < 0) {
                    System.out.println(ANSI_RED + "The value can't be negative" + ANSI_RESET);
                    temp = false;
                } else {
                    temp = true;
                }
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "The value must be a number format" + ANSI_RESET);
                temp = false;
            }
        }
        return temp;
    }

    public static boolean checkInputBooleanValue(String source) {
        boolean temp = checkInputStringValue(source);
        if (temp) {
            if (source.equalsIgnoreCase("true") || source.equalsIgnoreCase("false")) {
                temp = true;
            } else {
                System.out.println(ANSI_RED + "The value must be TRUE or FALSE" + ANSI_RESET);
                temp = false;
            }
        }
        return temp;
    }

    public static boolean checkInputBigIntegerValue(String source) {
        boolean temp = checkInputStringValue(source);
        if (temp) {
            BigDecimal price = null;
            try {
                price = new BigDecimal(source);
                if (price.compareTo(BigDecimal.ZERO) > 0) {
                    temp = true;
                } else {
                    System.out.println(ANSI_RED + "The value can't be negative" + ANSI_RESET);
                    temp = false;
                }
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "The value must be a number format" + ANSI_RESET);
                temp = false;
            }

        }
        return temp;
    }
}

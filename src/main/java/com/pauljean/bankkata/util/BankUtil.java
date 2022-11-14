package com.pauljean.bankkata.util;

import java.util.Random;

public class BankUtil {

    public static final String STATEMENT_HEADER = "OPERATION | DATE | AMOUNT | BALANCE";
    public static long USER_ID = 1000l;


    /**
     * allow to generate random number
     * @return
     */
    public static long random() {
        Random random = new Random();

        return random.longs(500, USER_ID).findFirst().getAsLong();
    }

    /**
     * check number is positive or negative
     *
     * @param value
     * @return
     */
    public static boolean checkPositive(double value) {

        boolean result = false;

        if (value > 0) {
            result = true;
        }

        return result;
    }

}

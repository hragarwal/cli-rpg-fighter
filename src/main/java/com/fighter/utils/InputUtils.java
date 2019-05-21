package com.fighter.utils;

import java.io.BufferedReader;
import java.io.IOException;

public class InputUtils {

    public static String waitForUserInputToProceed(BufferedReader inputTaker) throws IOException {
        return inputTaker.readLine();
    }
}

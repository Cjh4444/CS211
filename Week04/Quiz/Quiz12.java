package Week04.Quiz;

import java.math.BigInteger;
import java.util.Scanner;

/*
 * Camden Harris
 * Winter 2024, C211, William Iverson
 * 01/30/24
 * Chapter 12 Quiz
 * Problem Solution for Chapter 12 Quiz
 */

public class Quiz12 {

    public static void main(String[] args) {}

    public static String compress(String string) {
        int length = string.length();

        if (length == 0) return "";
        if (length == 1) return "" + string.charAt(0);

        return (string.charAt(0) == string.charAt(1) ? "" : string.charAt(0))
                + compress(string.substring(1, length));
    }

    public static String compress2(String string) {
        return compress2(string, '\0');
    }
    public static String compress2(String string, char letter) {
        if (string.length() == 0) return "";
        if (string.length() == 1) return "" + string.charAt(0);

        char firstLetter = string.charAt(0);
        return firstLetter == letter 
                ? compress2(string.substring(1), firstLetter) 
                : letter + compress2(string.substring(1), firstLetter); 
    }
}

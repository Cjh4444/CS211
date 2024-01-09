package Week02.Assignment;

import java.util.ArrayList;

/*
 * Camden Harris
 * Winter 2024, C211, William Iverson
 * 01/7/24
 * Chapter 10 Assignment
 * Collection of Practice-It solutions for Chapter 10
 */

public class Exercises10 {
    
    public static void main(String[] args) {
        
    }

    // Exercise 10.2 largestAbsVal
    // swaps the positions of pairs of strings in an arraylist
    public static void swapPairs( ArrayList<String> list ) {
        if (list.size() == 0) {
            return;
        }
        
        String temp;
        for (int i = 1; i < list.size(); i += 2) {
            temp = list.get(i);
            list.remove(i);
            list.add(i - 1, temp);
        }
    }

    // Exercise 10.6 minToFront
    // brings the earliest date in an array list to the 0th position
    public static void minToFront( ArrayList<CalendarDate> list ) {
        if (list.size() == 0) {
            return;
        }

        int minIndex = 0;
        CalendarDate minDate = list.get(0);

        CalendarDate currentDate;
        for (int i = 1; i < list.size(); i++) {
            currentDate = list.get(i);
            if( currentDate.compareTo(minDate) < 0 ) {
                minDate = currentDate;
                minIndex = i;
            }
        }
    
        list.remove(minIndex);
        list.add(0, minDate);
    }

    // Exercise 10.7 removeDuplicates
    // removes all the duplicate instances in an arraylist
    public static void removeDuplicates( ArrayList<CalendarDate> list ) {
        if (list.size() == 0) {
            return;
        }

        CalendarDate checkedWord = list.get(0);
        CalendarDate currentWord;
        for (int i = 1; i < list.size(); i++) {
            currentWord = list.get(i);
            if (checkedWord.equals(currentWord)) {
                list.remove(i);
                i--;
            } else {
                checkedWord = currentWord;
            }    
        }
    }

    // Exercise 10.12 markLength4
    // adds a "****" before each 4 letter word in an array list
    public static void markLength4( ArrayList<String> list ) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
                i++;
            }
        }
    }

    // Exercise 10.18 markLength4
    // adds a mirror of an arraylist to the end of itself
    public static void mirror( ArrayList<String> list ) {
        for (int i = list.size() - 1; i >= 0; i--) {
            list.add(list.get(i));
        }
    }
}

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
    
    public static void main(String[] alot587) {
	    
        // Initialize an array of Strings, then load into a String List:
        String[] arrayS = {"four", "score", "and", "seven", "years", "ago"};
        ArrayList<String> testListS = new ArrayList<String>(); 
        ArrayList<String> testListSempty = new ArrayList<String>();
        for (String s: arrayS) testListS.add(s);
        
        // Use Iverson's CalendarDate, so we MUST use compareTo concept
        ArrayList<CalendarDate> testListC = new ArrayList<CalendarDate>();
        ArrayList<CalendarDate> testListCempty = new ArrayList<CalendarDate>();
        testListC.add(new CalendarDate(10,12,1314));  testListC.add(new CalendarDate(10,12,1314));
        testListC.add(new CalendarDate(2,14,2022));  testListC.add(new CalendarDate(3,21,2022));
         
        // Exercise 10.2
        System.out.println(testListS);
        swapPairs(testListS);
        swapPairs(testListSempty);
        System.out.println("10.2 swapPairs: "+ testListS); 
        System.out.println();
        
        // Exercise 10.6
        System.out.println(testListC);
        minToFront(testListC);
        minToFront(testListCempty);
        System.out.println("10.6 minToFront: " + testListC);
        System.out.println();
        
        // Exercise 10.7
        System.out.println(testListC);
        removeDuplicates(testListC);
        removeDuplicates(testListCempty);
        System.out.println("10.7 removeDuplicates: " + testListC);
        System.out.println();
        
        // Exercise 10.12
        System.out.println(testListS);
        markLength4(testListS);
        markLength4(testListSempty);
        System.out.println("10.12 markLength4: " + testListS);
        System.out.println();
    
        // Exercise 10.18
        System.out.println(testListS);
        mirror(testListS);
        mirror(testListSempty);
        System.out.println("10.18 mirror: " + testListS);
        System.out.println();
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
            if( minDate.compareTo(currentDate) < 0 ) {
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

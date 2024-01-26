package Week03.Quiz;

import java.util.*;

/*
 * Camden Harris
 * Winter 2024, C211, William Iverson
 * 01/23/24
 * Chapter 11 Quiz
 * Problem Solution for Chapter 11 Quiz
 */

public class Quiz11 {
    public static void main(String[] args302) {
        ArrayList<CalendarDate> list1 = new ArrayList<CalendarDate>(512);
        System.out.println(yearMode(list1)); //   0 is returned when list is empty
        list1.add(new CalendarDate(5, 5, 2018));
        list1.add(new CalendarDate(1, 2, 2018));
        list1.add(new CalendarDate(5, 5, 2018));
        list1.add(new CalendarDate(10, 7, 1907));
        list1.add(new CalendarDate(5, 5, 2018));
        System.out.println(yearMode(list1)); //   4 times we have the year 2018
    }

    // solutions go below here:
    public static int yearMode(List<CalendarDate> quiz) {
        if (quiz.isEmpty()) return 0;

        Iterator<CalendarDate> iterator = quiz.iterator();

        HashMap<Integer, Integer> map = new HashMap<>();

        int currentYear;
        int count;
        int maxNum = 0;

        while (iterator.hasNext()) {
            currentYear = iterator.next().getYear();
            count = map.containsKey(currentYear) ? map.get(currentYear) : 0;
            map.put(currentYear, count + 1);
            if (map.get(currentYear) > maxNum) maxNum = map.get(currentYear);
        }

        return maxNum;
    }
}
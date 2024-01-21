import java.util.ArrayList;

import Week02.Assignment.CalendarDate;

/*
 * Camden Harris
 * Winter 2024, C211, William Iverson
 * 01/16/24
 * Chapter 10 Quiz
 * Problem solution for chapter 10 quiz
 */

public class Quiz10 {
    public static void main(String[] a572) {
        ArrayList<CalendarDate> dates = new ArrayList<CalendarDate>(22);
        dates.add(new CalendarDate(5, 5, 2018));
        dates.add(new CalendarDate(10, 5, 2018));
        dates.add(new CalendarDate(5, 7, 2017));
        dates.add(new CalendarDate(10, 5, 2020));
        System.out.println("Before: " + dates); // 4 items in list
        removeOddMonths(dates);
        System.out.println(" After: " + dates); // now fewer items
    }

    public static void removeOddMonths( ArrayList<CalendarDate> months ) {
        for (int i = 0; i < months.size(); i++) {
            if (months.get(i).getMonth() % 2 == 1) {
                months.remove(i);
                i--;
            }
        }
    }
}

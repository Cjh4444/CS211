package Week10.Assignment;

import Week02.Assignment.CalendarDate;

public class Testing {
    public static void main(String[] args) {
        HashSet<CalendarDate> test1 = new HashSet<CalendarDate>();
        HashSet<CalendarDate> test2 = new HashSet<CalendarDate>();

        test1.add(new CalendarDate(1,1,2021));
        test1.add(new CalendarDate(12,12,2016));
        test1.add(new CalendarDate(1,5,2023));
        test2.add(new CalendarDate(1,5,2023));
        test2.add(new CalendarDate(1,5,2023));

        System.out.println("test 1: " + test1.toString());
        System.out.println("test 2: " + test2.toString());

        System.out.println("test1 contains test 2: " + test1.containsAll(test2));
        System.out.println("test1 equals test 2: " + test1.equals(test2));

        System.out.println("removeall");
        test1.removeAll(test2);
        System.out.println(test1.toString());

        System.out.println("retainall");
        test1.retainAll(test2);
        System.out.println(test2.toString());
    }
}

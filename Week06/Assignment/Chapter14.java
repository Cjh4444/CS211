package Week06.Assignment;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Camden Harris
 * Winter 2024, C211, William Iverson
 * 02/12/24
 * Chapter 14 Assignments
 * Exercise Solutions for Chapter 14 Quiz
 */

public class Chapter14 {

    // returns a queue from a stack in the same order, preserves original stack
    private static Queue<CalendarDate> getAuxStorage( Stack<CalendarDate> stack ) {
        Queue<CalendarDate> queue = new LinkedList<>();
        Stack<CalendarDate> tempStack = new Stack<>();

        while (!stack.empty()) tempStack.push(stack.pop());

        while (!tempStack.empty()) {
            CalendarDate element = tempStack.pop();
            queue.add(element);
            stack.push(element);
        }

        return queue;
    }

    // Exercise 14.2 stutter
    // returns a new stack with each value duplicated, preserves original stack
    public static Stack<CalendarDate> stutter( Stack<CalendarDate> stack ) {
        if (stack.empty()) return stack;

        Queue<CalendarDate> list = getAuxStorage(stack);
        Stack<CalendarDate> returnStack = new Stack<>();

        if (stack.empty()) return returnStack;

        for (CalendarDate date : list) {
            returnStack.push(date);
            returnStack.push(date);
        }

        return returnStack;
    }

    // Exercise 14.5 equals
    // returns if two stacks are equal, preserves original stacks
    public static boolean equals( Stack<CalendarDate> stack1, Stack<CalendarDate> stack2 ) {
        if (stack1.equals(stack2)) return true;
        if (stack1.size() != stack2.size()) return false;
        if (stack1.empty() && stack2.empty()) return true;

        Stack<CalendarDate> auxStack = new Stack<>();
        boolean isEqual = true;

        CalendarDate date1, date2;
        for (int i = stack1.size(); i != 0; i--) {
            date1 = stack1.peek();
            date2 = stack2.peek();
            if (date1.equals(date2)) {
                auxStack.push(date1);
                stack1.pop();
                stack2.pop();
            } else {
                isEqual = false;
                break;
            }
        }

        CalendarDate temp;
        while (!auxStack.empty()) {
            temp = auxStack.pop();

            stack1.push(temp);
            stack2.push(temp);
        }

        return isEqual;
    }

    // Exercise 14.15 isSorted
    // returns if a stack is sorted, preserves original stack
    public static boolean isSorted( Stack<CalendarDate> stack ) {
        if (stack.size() < 2) return true;

        CalendarDate lastDate, currentDate;
        Stack<CalendarDate> auxStack = new Stack<>();
        boolean isSorted = true;

        lastDate = stack.pop();
        auxStack.push(lastDate);

        while( !stack.empty() ) {
            currentDate = stack.pop();
            auxStack.push(currentDate);

            if (currentDate.compareTo(lastDate) < 0) {
                isSorted = false;
                break;
            }
            lastDate = currentDate;
        }

        while (!auxStack.empty()) stack.push(auxStack.pop());

        return isSorted;
    }

    // Exercise 14.19 removeMin
    // returns the minimum value in a stack and returns the stack without that value, does not preserve original stack
    public static CalendarDate removeMin( Stack<CalendarDate> stack ) {
        if (stack.empty()) return null;
        if (stack.size() == 1) return stack.pop();

        Queue<CalendarDate> queue = getAuxStorage(stack);
        CalendarDate minDate, currentDate;

        minDate = stack.pop();
        while (!stack.empty()) {
            currentDate = stack.pop();        
            if (currentDate.compareTo(minDate) < 0) minDate = currentDate;
        }

        CalendarDate queueValue;
        while (!queue.isEmpty()) {
            queueValue = queue.poll();
            if (!queueValue.equals(minDate)) stack.push(queueValue);
        }

        return minDate;
    }

}

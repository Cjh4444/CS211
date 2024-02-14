package Week06.Quiz;

/*
 * Camden Harris
 * Winter 2024, C211, William Iverson
 * 02/13/24
 * Chapter 14 Quiz
 * Problem Solution for Chapter 14 Quiz
 */

public class Quiz14 {
    
    public static void main(String[] arg796) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1); stack.push(8);  stack.push(7);  stack.push(2); 
        stack.push(9); stack.push(18); stack.push(2*68); stack.push(0); 
        
        System.out.println("bottom " + stack.toString() + " top");
        removeEvenNumbers(stack);
        System.out.println("bottom " + stack.toString() + " top");
    }

    public static void removeEvenNumbers(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<Integer>();

        while (!stack.empty()) {
            Integer value = stack.pop();
            if (value % 2 == 1) temp.push(value);
        }

        while (!temp.empty()) stack.push(temp.pop());
    }
}

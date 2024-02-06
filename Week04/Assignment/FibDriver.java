package Week04.Assignment;

/*
 * Camden Harris
 * Winter 2024, C211, William Iverson
 * 02/05/24
 * Chapter 13 Assignment
 * Big O Analysis
 */

public class FibDriver {
    // copyright Bellevue College
    public static void main(String[] args) {
        // for (int i = 0; i < 44; i++) {
        //     Fibonacci test = new Fibonacci(i); // constructor overload
        // //System.out.println(test.fibForLoop()); // Chapter 2 code not used this week 
        //     long time1 = System.currentTimeMillis();
        //     test.fibonacci(); // slow version in text
        //     long time2 = System.currentTimeMillis();
        //     System.out.println("(" + i + "," + (time2-time1) + ")" );
        //     // System.out.println();
        // }
        
        // After numerous tests, and analysis of code, and considerable thought:
        // I conclude that fibonacci() is very slow with Big-O complexity of O(2^N)
        // This comes from the fact that the amount of time increased by 2x every time the nth fibonacci number is requested
        // This is also clear in the fact that each call to the slow fibonacci call creates 2 new calls to the method
        
        for (int i = 0; i < 35000; i+=100) {
            Fibonacci test = new Fibonacci(i); // constructor overload
            long time1 = System.currentTimeMillis();
            //System.out.println(test.bigFib()); // same as above, but use BigInteger
            test.bigFastFib(); // same as above, but MUCH faster
            long time2 = System.currentTimeMillis();
            System.out.println("(" + i + "," + (time2-time1) + ")" );
            // System.out.println();
        }
        // After numerous tests, and analysis of code, and considerable thought:
        // I conclude that bigFastFib() is very fast with Big-O complexity of O(N)
        // this comes from the fact that the time seems to increase linearly as the nth fibonacci number is requested
        // this is further confirmed by the fact that each fibonacci call only makes an singular new method call, so the number of calls is always N+1, simplified to N
    }
}
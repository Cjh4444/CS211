package Week04.Assignment;

public class FibDriver {
    static int count = 1000;
    static Fibonacci test = new Fibonacci(25000);
    public static void main(String[] args) {
         // only needed for overload
        //  System.out.println(test.fibForLoop()); // CS210 version in text. Chapter 2
        //  System.out.println(test.fibonacci()); // recursive int version, Chapter 12
        //  System.out.println(test.bigFib()); // same as above, but using BigIntegers
        // System.out.println(test.bigFastFib()); // same as above, but MUCH faster
        // System.out.println(test.bigFastFibVictor());
        // System.out.println(test.bigFastFib());
        System.out.println(test.bigFastFib());
    }
}
package Week04.Assignment;

import java.math.BigInteger;
/*
 * Camden Harris
 * Winter 2024, C211, William Iverson
 * 01/30/24
 * Chapter 12 Assignment
 * Fast Recursive Fibonacci Sequence
 */
public class Fibonacci {
    // fields, ONE is in any version of Java already
    // but BigInteger.TWO requires Java 9 or higher, so I make one here
    private static final BigInteger TWO = new BigInteger("2");
    private static final BigInteger ONE = new BigInteger("1");
    private int n; // the boring old 32-bit limited int

    // only one constructor needed
    public Fibonacci(int number) {
        n = number;
    }

    // make this private as right now I cannot think of why we need to allow
    @SuppressWarnings("unused")
    private Fibonacci() {
        this(1);
    }

    // Chapter 12, Exercise 2, code from page 128-9.
    public int fibForLoop() {
        int n1 = 1;
        int n2 = 1;
        for (int i = 3; i <= n; i++) {
            int n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        return n2;
    }

    // Chapter 12, same exercise
    // public accessor into recursive helper
    public int fibonacci() {
        return fibonacci(n);    
    }

    // private recursive helper given in text
    // Chapter 12, page 830 (5th ed.)
    private int fibonacci(int n) {
        if (n<=2) {
            return 1;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

    public int fastFib() {
        return fastFib(n, 0, 1);
    } 

    private int fastFib(int n, int num1, int num2) {
        if (n == 0) return num1;
        if (n == 1) return num2;

        return fastFib(--n, num2, num1 + num2);
    } 

    // Exactly the same concept as above, but using BigInteger
    // This allows us to go up to any size integer
    public BigInteger bigFib() {
        return bigFib(new BigInteger(Integer.toString(n)));
    }

    // recursive helper
    private BigInteger bigFib(BigInteger n) {
        if (n.compareTo(TWO)<=0) {
            return ONE;
        } else {
            return bigFib(n.subtract(ONE)).add(bigFib(n.subtract(TWO)));
        }
    }

    public BigInteger bigFastFib( ) {
        return bigFastFib(n, new BigInteger("0"), ONE);
    } 

    public BigInteger bigFastFib( int n, BigInteger bigNum1, BigInteger bigNum2 ) {
        if (n == 0) return bigNum1;
        if (n == 1) return bigNum2;

        return bigFastFib(--n, bigNum2, bigNum1.add(bigNum2));
    }

}

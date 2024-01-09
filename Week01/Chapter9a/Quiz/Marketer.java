package Quiz;

/*
 * Camden Harris
 * Winter 2024, C211, William Iverson
 * 1/5/24
 * Chapter 9a Quiz
 * Data structure class for a Marketer
 */

public class Marketer extends Employee {
    
    // default constructor
    public Marketer() {
        super();
    }

    // Marketers get paid 10k more than employees
    public double getSalary() {
        return super.getSalary() + 10000;
    }

    // Marketer catchphrase
    public String toString() {
        return "Act now, while supplies last!";
    }
}

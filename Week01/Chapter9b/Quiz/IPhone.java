package Week01.Chapter9b.Quiz;

/*
 * Camden Harris
 * Winter 2023, C211, William Iverson
 * 1/9/24
 * Chapter 9b Quiz
 * Data structure class for a IPhone Asset
 */

public class IPhone implements Asset {
    public static final double ANNUAL_DEPRECIATION = 0.2; // fraction decline each year
    
    private double originalCost; // in US dollars, fixed for each object
    private int currentAge;  // in years

    //default constructor
    public IPhone() {
        this(500, 5);
    }

    // parameter constructor
    public IPhone(double originalCost, int currentAge) {
        this.originalCost = originalCost;
        this.currentAge = currentAge;
    }

    // gets the market value, which is the original cost multiplied by an exponential depreciation
    @Override
    public double getMarketValue() {
        return originalCost * Math.pow(1 - ANNUAL_DEPRECIATION, currentAge);
    }

    // gets the profit of the phone, which is always negative due to depreciation
    @Override
    public double getProfit() {
        return getMarketValue() - originalCost;
    }

    public String toString() {
        return "IPhone ( " + currentAge + " years old )";
    }
}

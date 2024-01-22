package Week01.Chapter9b.Quiz;

// Represents an amount of money held by an investor.
public class Cash implements Asset {
    private double amount;   // amount of money held
    
    // Constructs a cash investment of the given amount.
    public Cash(double amount) {
        this.amount = amount;
    }
    
    // for console output, added by W.P. Iverson
    public String toString() {
    	return "Cash ( $ " + amount + " )";
    }
    
    // Returns this cash investment's market value, which
    // is equal to the amount of cash.
    public double getMarketValue() {
        return amount;
    }
    
    // Since cash is a fixed asset, it never has any profit.
    public double getProfit() {
        return 0.0;
    }
    
    // Sets the amount of cash invested to the given value.
    public void setAmount(double amount) {
        this.amount = amount;
    }
} // code above exactly as provided from BJP text supplements

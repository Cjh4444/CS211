/*
 * Camden Harris
 * Fall 2023, C210, William Iverson
 * 1/3/24
 * Chapter 9a Assignment
 * Data structure class for a Discount Bill
 */

public class DiscountBill extends GroceryBill {
    // data fields
    private boolean isPreferred;
    private int discountCount;
    private double discountAmount;

    // primary constructor
    public DiscountBill(Employee clerk, boolean preferred) {
        super(clerk);
        isPreferred = preferred;
        discountCount = 0;
        discountAmount = 0;
    }

    // default construtor
    public DiscountBill() {
        this(new Employee(), false);
    }

    // overrides the grocery bill add method to keep track of discounted items and the amount discounted
    @Override
    public void add(Item i) {
        super.add(i);

        if (isPreferred && i.getDiscount() != 0) {
            discountCount++;
            discountAmount += i.getDiscount();
        }
    }

    // overrides the grocery bill getTotal method to get the discounted total
    @Override
    public double getTotal() {
        return super.getTotal() - discountAmount;
    }

    // getter methods 
    public int getDiscountCount() {
        return discountCount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public double getDiscountPercent() {
        return discountAmount * 100 / super.getTotal();
    }
}

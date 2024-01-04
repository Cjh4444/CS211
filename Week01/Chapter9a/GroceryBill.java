import java.util.*;
/*
 * W.P. Iverson, January 2024
 * copied from https://practiceit.cs.washington.edu/problems/bjp5/chapter9/GroceryBill.java
 * so we can work Exercise BJP5 Exercise 9.10: DiscountBill
 * changed private List to protected so Chapter 10 ShoppingCart can be used
 * for Bellevue College, CS211
 */
public class GroceryBill {
	// FIELDS
	private Employee clerk;
	private List<Item> receipt;
	private double total;
	private double internalDiscount;
	
	// CONSTRUCTORS
	public GroceryBill(Employee name) {
		clerk = name;
		receipt = new ArrayList<Item>();
		total = 0.0;
		internalDiscount = 0.0;
	}

	// Iverson requires zero parameter constructor
	public GroceryBill() {
		this(new Employee());
	}

	// MUTATORS (modifiers)
	public void add(Item i) {
		receipt.add(i);
		total += i.getPrice();
		internalDiscount += i.getDiscount();
	}
	
	// ACCESSORS (getters)
	public double getTotal() {
		return Math.rint(total * 100) / 100.0;
	}
	
	public Employee getClerk() {
		return clerk;
	}
	
	// private methods are called "helper" methods
	private String valueToString(double value) {
		value = Math.rint(value * 100) / 100.0;
		String result = "" + Math.abs(value);
		if(result.indexOf(".") == result.length() - 2) {
			result += "0";
		}
		result = "$" + result;
		return result;
	}
	
	// complicated toString methods for Practice-IT output
	public String receiptToString() {
		String build = "items:\n";
		for(int i = 0; i < receipt.size(); i++) {
			build += "   " + receipt.get(i);
			if(i != receipt.size() - 1) {
				build += "\n";
			}
		}
		return build;
	}
	
	public String toString() {
		return receiptToString() + "\ntotal: " + valueToString(total);
	}
	
	public String discountToString() {
		return receiptToString() + "\nsub-total: " + valueToString(total) + "\ndiscount: " + valueToString(internalDiscount) + "\ntotal: " + valueToString(total - internalDiscount);
	}

}

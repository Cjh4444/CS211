/*
 * W.P. Iverson, January 2024
 * copied from https://practiceit.cs.washington.edu/problems/bjp5/chapter9/GroceryBill.java
 * so we can work Exercise BJP4 Exercise 9.10: DiscountBill
 * 
 * for Bellevue College, CS211
 */
public class Exercise9_10 {

	public static void main(String[] args2024) {
		// a portion of test #1 in Practice-IT
		DiscountBill test0 = new DiscountBill();
		DiscountBill test1 = new DiscountBill(new Employee("clerk-1"), false);
		System.out.println("test #1 DiscountBill(clerk, preferred)");
		System.out.println("preferred: false");
		System.out.println("clerk: clerk-1");
		System.out.println("clerk: "+test1.getClerk());
		
		// a portion of test #2 in Practice-IT
		DiscountBill test2 = new DiscountBill(new Employee("clerk"), true);
		System.out.println("\ntest #2  getTotal()");
		System.out.println("preferred: true");
		test2.add(new Item("candy bar", 1.35, 0.25));
		test2.add(new Item("toy car", 3.25, 0.5));
		test2.add(new Item("apple", 0.3, 0.05));
		test2.add(new Item("orange", 0.3, 0.05));
		test2.add(new Item("newspaper", 0.99, 0.0));
		System.out.println(test2.discountToString());
		System.out.println(test2); // .toString() is THE JAVA standard
		System.out.println("getTotal(): "+test2.getTotal());
	}

}

/*
 * W.P. Iverson, January 2024
 * copied from https://practiceit.cs.washington.edu/problems/bjp5/chapter9/GroceryBill.java
 * so we can work Exercise BJP5 Exercise 9.10: DiscountBill
 * 
 * for Bellevue College, CS211
 */

	// Class used only for the GroceryBill Class
	// We use Item.java for other exercises
	public class Item {
		private String name;
		private double price;
		private double discount;
		
		public Item(String name, double price, double discount) {
			this.name = name;
			this.price = price;
			this.discount = discount;
		}
		
		public double getPrice() {
			return price;
		}
		
		public double getDiscount() {
			return discount;
		}
		
		private String valueToString(double value) {
			String result = "" + Math.abs(value);
			if(result.indexOf(".") == result.length() - 2) {
				result += "0";
			}
			result = "$" + result;
			return result;
		}
		
		public String toString() {
			return name + " " + valueToString(price) + " (-" + valueToString(discount) + ")";
		}
	}

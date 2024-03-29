package Week07.Assignment;

/* No imports required, we're writing our own
 * optional iterator import if your curious
 * 
 * CS211, W.P. Iverson, instructor and author
 * This is a start at test code for Chapter 15 Assignment
 * Other tests can and will happen....
 * version 2024
 */

public class Test {

// Testing for Exercises in Chapter 15
	
	public static void main(String[] args) {
		ArrayIntList test = new ArrayIntList();		// my data structure
		ArrayList<Integer> test2 = new ArrayList<Integer>();
		int[] a = {2,9,9,6,1,3,9,0};	// sample data
		for (int i: a) {		// use for each 
			test.add(i);
			test2.add(i);
		}
		
		System.out.println(test);
		// System.out.println(test2);
		// System.out.println(test.lastIndexOf(9));	// 15.1  should be 5?
		// System.out.println(test2.lastIndexOf(9));	// 15.1
		//test.reverse();				// 15.4
		//test.count(2);				// 15.8
		// System.out.println(test.removeLast()); // 15.11
		// System.out.println(test2.removeLast()); // 15.11
		// test.removeFront(4);				// 15.12
		// test2.removeFront(4);				// 15.12
		// test.removeAll(9);				// 15.13
		// test2.removeAll(9);				// 15.13
		// test.mirror();				// 15.15
		// test2.mirror();				// 15.15
		// test.stutter();				// 15.16
		// test2.stutter();				// 15.16
		//test.stretch(3);				// 15.17
		test.removeEvenNumbers();
		System.out.println(test);			// test changed if above code is run
		// System.out.println(test2);			// test changed if above code is run
		
		System.out.println();

		ArrayIntList quiz15 = new ArrayIntList();
		quiz15.add(1); quiz15.add(8); quiz15.add(8);  quiz15.add(7);  quiz15.add(2); 
		quiz15.add(9); quiz15.add(18); quiz15.add(2*3); quiz15.add(0); 
		
		System.out.println(quiz15);
		quiz15.removeEvenNumbers();
		System.out.println(quiz15);

		// System.out.print("\nLearning about iterators:\n[");
		// ArrayIntList.ArrayIntListIterator itr =  test.iterator();
		// while (itr.hasNext()) {
		// 	System.out.print(itr.next() + ", ");
		// }
		// System.out.println();

		// modified Programming Project #2, to make Class Iterable 
		// System.out.println();
		// for (Integer i: test2) System.out.print(i + ", ");	// requires Oracle Iterable<E>
		// System.out.print("\n\nTextbook Project #2 using our own ArrayList<E>:\n[");
		// for (Integer data: test2) System.out.print(data+", "); // Oracle generic Java API Iterator<E>
	}

}
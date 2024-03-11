package Week10.Assignment;

import java.util.*;

// W.P. Iverson
// Bellevue College, CS211
// Chapter 18 example, January 2024
public class Exercises18HPQ {

	public static void main(String[] args) {
		// BJP HeapPriorityQueue modified:
		PriorityQueue<Integer> pq18 = new PriorityQueue<Integer>(100);
		pq18.add(88); pq18.add(-1); pq18.add(35); pq18.add(42);  pq18.add(42);
		System.out.println(pq18); // uses PQ toString()
		
		// Some more Oracle Java methods:
		System.out.println(Arrays.toString(pq18.toArray())); // PQ return and Array
		System.out.println(pq18.remove(42)); // removes just a single Object
		System.out.println(pq18); // uses PQ toString()
		System.out.println(pq18.remove(99)); // removes just a single Object
		System.out.println(pq18); // uses PQ toString()
		System.out.println(pq18.poll()); // Oracle PQ actually uses poll to remove
		System.out.println(pq18); // uses PQ toString()
		pq18.clear(); 				// clears the Queue
		System.out.println(pq18); // noting left at this point
		
		// Some CONSTRUCTOR options with Oracle Java HeapPriorityQueue:
		// Build a Collection to use in testing below
		Collection<Integer> storage = new ArrayList<Integer>();	
		storage.add(42); storage.add(17); storage.add(9); storage.add(42);
		storage.add(35); storage.add(-1); storage.add(88);
		System.out.println(storage);  // output simply in order of above input
		
		// Oracle Java HeapPriorityQueue has constructor to accept Collection:
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(storage);
		System.out.println(pq); // prints as internal array order (KNOW what this is!!!)
		while (!pq.isEmpty()) { 
		     System.out.print(pq.remove() + " "); // prints in "natural" order
		}
		System.out.println();

		// Oracle Java HeapPriorityQueue has constructor to accept a different Comparator:
		PriorityQueue<Integer> pqMax = new PriorityQueue<Integer>(Collections.reverseOrder());
		pqMax.add(88); pqMax.add(-1); pqMax.add(35); pqMax.add(42);
		pqMax.add(9); pqMax.add(17); pqMax.add(42);
		System.out.println(pqMax); // prints as internal array order
		while (!pqMax.isEmpty()) {
		     System.out.print(pqMax.remove() + " "); // prints in Comparator's order
		}
		System.out.println();
		

	}
}

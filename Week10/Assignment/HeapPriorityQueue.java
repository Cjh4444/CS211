package Week10.Assignment;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.NoSuchElementException;
// for Iverson's CS211, Limit yourself to above imports
// these will help us maintain O(log N) run-time for this
// added clear() method for repeated testing


// Implements a priority queue of comparable objects using a
// min-heap represented as an array.

/*
 * Camden Harris
 * Winter 2024, C211, William Iverson
 * 03/18/24
 * Chapter 18b Assignment
 * Data Structure Class for generic HeapPriorityQueue, with Quiz 18b solution
 */

public class HeapPriorityQueue<E extends Comparable<E>> {
    private E[] elementData;
    private int size;
    private Comparator<E> comparator;
    
    // Constructs an empty queue.
    @SuppressWarnings("unchecked")
    public HeapPriorityQueue() {
        elementData = (E[]) new Comparable[10]; // was Object
        size = 0;
        comparator = Comparator.naturalOrder();
    }

    @SuppressWarnings("unchecked")
    public HeapPriorityQueue( int initialCapacity ) {
        this();
        elementData = (E[]) new Comparable[initialCapacity]; // was Object
    }

    public HeapPriorityQueue( Collection<E> collection ) {
        this();
        for (E item : collection) add(item);
    }

    public HeapPriorityQueue( Comparator<E> comparator ) {
        this();
        this.comparator = comparator;
    }
    
    // ADD METHODS HERE for exercise solutions:
    
    @SuppressWarnings("unchecked")
    public E[] toArray() {
        E[] returnArr = (E[]) new Comparable[size];

        int index = 0;
        while (!isEmpty()) returnArr[index++] = remove();
        for (E item : returnArr) add(item);

        return returnArr;
    }

    @SuppressWarnings("unchecked")
    public boolean remove(E item) {
        E[] tempArr = (E[]) new Comparable[size];

        E processedItem = null;
        int startingSize = size;

        int index = 0;
        while(!isEmpty()) {
            processedItem = remove();
            if (processedItem.equals(item)) break;
            tempArr[index++] = processedItem;
        }

        
        for (E movedItem : tempArr) {
            if (movedItem == null) break;
            add(movedItem);
        }

        return startingSize != size;
    }

    public E poll() {
        if (isEmpty()) return null;
        return remove(); 
    }

    // Quiz 18b Solution
    public boolean contentsEqual( HeapPriorityQueue<E> other ) {
        if (size() != other.size()) return false;

        for (E thisElement : elementData) {
            if (thisElement == null) continue;
            boolean isInOther = false;
            for (E otherElement : other.elementData) {
                if (otherElement == null) continue;
                if (thisElement.compareTo(otherElement) == 0) {
                    isInOther = true;
                    break;
                }
            }
            if (!isInOther) return false;
        }

        for (E otherElement : other.elementData) {
            if (otherElement == null) continue;
            boolean isInOther = false;
            for (E thisElement : elementData) {
                if (thisElement == null) continue;
                if (otherElement.compareTo(thisElement) == 0) {
                    isInOther = true;
                    break;
                }
            }
            if (!isInOther) return false;
        }

        return true;
    }
    
    
    // Adds the given element to this queue.
    public void add(E value) {
        // resize if necessary
        if (size + 1 >= elementData.length) { // O(N) issue here
            elementData = Arrays.copyOf(elementData, elementData.length * 2);
        }
        
        // insert as new rightmost leaf
        elementData[size + 1] = value;
        
        // "bubble up" toward root as necessary to fix ordering
        int index = size + 1;
        boolean found = false;   // have we found the proper place yet?
        while (!found && hasParent(index)) {
            int parent = parent(index);
            if (comparator.compare(elementData[index], (elementData[parent])) < 0) {
                swap(elementData, index, parent(index));
                index = parent(index);
            } else {
                found = true;  // found proper location; stop the loop
            }
        }
        size++;
    }
    
    // Returns true if there are no elements in this queue.
    public boolean isEmpty() {
        return size == 0;
    }

    // "clears" data by setting size to zero
    public void clear() {
    	size = 0;
    }
    
    // Returns the minimum value in the queue without modifying the queue.
    // If the queue is empty, throws a NoSuchElementException.
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return elementData[1];
    }
    
    // Removes and returns the minimum value in the queue.
    // If the queue is empty, throws a NoSuchElementException.
    public E remove() {
        E result = peek();

        // move rightmost leaf to become new root
        elementData[1] = elementData[size];
        size--;
        
        // "bubble down" root as necessary to fix ordering
        int index = 1;
        boolean found = false;   // have we found the proper place yet?
        while (!found && hasLeftChild(index)) {
            int left = leftChild(index);
            int right = rightChild(index);
            int child = left;
            if (hasRightChild(index) &&
                    comparator.compare(elementData[right], (elementData[left])) < 0) {
                child = right;
            }
            
            if (comparator.compare(elementData[index], (elementData[child])) > 0) {
                swap(elementData, index, child);
                index = child;
            } else {
                found = true;  // found proper location; stop the loop
            }
        }
        
        return result;
    }
    
    // Returns the number of elements in the queue.
    public int size() {
        return size;
    }
    
    // Returns a string representation of this queue, such as "[10, 20, 30]";
    // The elements are not guaranteed to be listed in sorted order.
    public String toString() {
        String result = "[";
        if (!isEmpty()) {
            result += elementData[1];
            for (int i = 2; i <= size; i++) {
                result += ", " + elementData[i];
            }
        }
        return result + "]";
    }
    
    
    // helpers for navigating indexes up/down the tree
    private int parent(int index) {
        return index / 2;
    }
    
    // returns index of left child of given index
    private int leftChild(int index) {
        return index * 2;
    }
    
    // returns index of right child of given index
    private int rightChild(int index) {
        return index * 2 + 1;
    }
    
    // returns true if the node at the given index has a parent (is not the root)
    private boolean hasParent(int index) {
        return index > 1;
    }
    
    // returns true if the node at the given index has a non-empty left child
    private boolean hasLeftChild(int index) {
        return leftChild(index) <= size;
    }
    
    // returns true if the node at the given index has a non-empty right child
    private boolean hasRightChild(int index) {
        return rightChild(index) <= size;
    }
    
    // switches the values at the two given indexes of the given array
    private void swap(E[] a, int index1, int index2) {
        E temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }


}

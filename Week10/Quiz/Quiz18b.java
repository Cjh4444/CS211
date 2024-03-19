package Week10.Quiz;

import Week10.Assignment.HeapPriorityQueue;

public class Quiz18b {
    public static void main(String[] arg123) { 
        HeapPriorityQueue<Integer> test52 = new HeapPriorityQueue<Integer>(); 
        test52.add(1); test52.add(2); test52.add(3); 
        HeapPriorityQueue<Integer> redo = new HeapPriorityQueue<Integer>(); 
        System.out.println(test52.contentsEqual(redo)); // false 
        redo.add(3); redo.add(2); redo.add(1); 
        System.out.println(test52); // [1, 2, 3] 
        System.out.println(redo); // [1, 3, 2] not exactly the same
        System.out.println(test52.contentsEqual(redo)); // true anyway
        System.out.println(test52); // [1, 2, 3] QUEUE is not altered
        System.out.println(redo); // [1, 3, 2] 
   }  
}

package Week10.Quiz;

import Week10.Assignment.HashIntSet;

public class Quiz18a {
    public static void main(String[] q48) {
             HashIntSet test = new HashIntSet();
             System.out.println(test); // []
             test.add(1); test.add(8); test.add(7); test.add(2); 
             test.add(9); test.add(18); test.add(0);
             System.out.println(test); // [0, 1, 2, 7, 8, 9, 18]
             test.removeEvenNumbers(); // 
             System.out.println(test); // [1, 7, 9]
             test.add(22); test.add(18); test.add(72); test.add(0); 
             test.add(92); test.add(88); test.add(8); test.add(2*727);
             System.out.println(test); // rehashed to LARGER array
             test.removeEvenNumbers();
             System.out.println(test); // [1, 7, 9]
    }  
}

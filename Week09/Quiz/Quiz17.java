package Week09.Quiz;

import Week09.Assignment.IntTree;
import Week09.Assignment.IntTreeNode;

public class Quiz17 {
    public static void main(String[] arg502) {
        IntTreeNode one = new IntTreeNode(0, null, null);
        IntTreeNode two = new IntTreeNode(0, null, null);
        two = new IntTreeNode(
                2 * 502,
                null,
                new IntTreeNode(9, null, new IntTreeNode(0, null, null)));

        one = new IntTreeNode(
                1,
                new IntTreeNode(8, new IntTreeNode(7, null, null), null),
                two);

        IntTree quiz17 = new IntTree(one);
        IntTree quiz17zero = new IntTree();
        IntTree quiz170 = new IntTree(170);

        IntTree used = quiz170;

        System.out.println(used);
        System.out.println("---------------------------");
        used.removeEvenNumbers();
        System.out.println(used);

        // Some other trees to test
    }
} // your solution is in IntTree.java

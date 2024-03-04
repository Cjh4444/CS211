package Week09.Assignment;

/**
 * BJP, reference tree #2
 * page 1076, for exercises #16 and #17
 * 
 * client driver for CS211 code exercises in IDE
 * by W.P. Iverson, Bellevue College, February 2023
 */
public class RefTree2
{
    public static void main(String[] args) {

    	// create the nodes we need
        IntTreeNode six = new IntTreeNode(6,null,new IntTreeNode(9,null,null));
        IntTreeNode seven = new IntTreeNode(7,new IntTreeNode(4,null,null),null);
        IntTreeNode eight = new IntTreeNode(8,new IntTreeNode(0,null,null),null);
        
        // build tree from above nodes
        IntTree tree2 = new IntTree(new IntTreeNode(2,eight,new IntTreeNode(1,seven,six)));
        //IntTree tree2 = new IntTree(new IntTreeNode(2,null,new IntTreeNode(1,null,null)));
        
        // KNOW how this output works!!!
        tree2.printSideways();
        // and this gives same output:
        System.out.println("\n------------------------\n");
        System.out.println(tree2);
        
        // Same nodes into Search Tree will yield a very different structure
        SearchTree<Integer> tree999 = new SearchTree<Integer>();
        tree999.add(2);  tree999.add(1);  tree999.add(7);  tree999.add(4);
        tree999.add(8);  tree999.add(0);  tree999.add(6);  tree999.add(9);
        System.out.println("\n------------------------\n");
        System.out.println(tree999);
    }
}

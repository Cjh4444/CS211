package Week09.Assignment;

// Simple binary tree class that includes methods to construct a
// tree of ints, to print the structure, and to print the data
// using a pre-order, in-order or post-order traversal.  The trees
// built have nodes numbered starting with 1 and numbered
// sequentially level by level with no gaps in the tree.  The
// documentation refers to these as "sequential trees."
//
// from buildingjavaprograms.com
// fixed in, post, pre, comments below
// added toString()
// by W.P. Iverson, Bellevue College, February 2023

public class IntTree {
    private IntTreeNode overallRoot;

    // pre : max > 0
    // post: constructs a sequential tree with given number of
    //       nodes
    public IntTree(int max) {
        if (max <= 0) {
            throw new IllegalArgumentException("max: " + max);
        }
        overallRoot = buildTree(1, max);
    }
    
    public IntTree() {
        overallRoot = null;
    }
    
    // constructor added so we can build page 1029 reference trees
    public IntTree(IntTreeNode given) {
        overallRoot = given;
    }

    // ADD METHODS here for exercises:
    
    public boolean isFull( ) {
        if (overallRoot == null) return false;
        return isFullHelper(overallRoot);
    }

    public boolean isFullHelper( IntTreeNode node ) {
        if (node.left == null ^ node.right == null) return false;
        if (node.left == null || node.right == null) return true;

        return isFullHelper(node.left) && isFullHelper(node.right);
    }

    public boolean equals2( IntTree other ) {
        if (overallRoot == null && other.overallRoot == null) return true;
        return equals2Helper(other, overallRoot, other.overallRoot);
    }

    private boolean equals2Helper( IntTree other, IntTreeNode thisNode, IntTreeNode otherNode ) {
        if ((thisNode.left == null ^ otherNode.left == null) || (thisNode.right == null ^ otherNode.right == null)) return false;

        boolean leftIsEqual = (thisNode.left == null && otherNode.left == null) ? true : equals2Helper(other, thisNode.left, otherNode.left);
        boolean rightIsEqual = (thisNode.right == null && otherNode.right == null) ? true : equals2Helper(other, thisNode.right, otherNode.right);
        return leftIsEqual && rightIsEqual && (thisNode.data == otherNode.data);
    }

    public void removeLeaves() {
        if (overallRoot == null) return;
        if (overallRoot.left == null && overallRoot.right == null) {
            overallRoot = null;
            return;
        } 
        removeLeavesHelper(overallRoot);
    }

    private void removeLeavesHelper( IntTreeNode node ) {
        if ( node.left == null && node.right == null) return;

        IntTreeNode left = node.left;
        IntTreeNode right = node.right;

        if ( left != null && left.left == null && left.right == null ) node.left = null;
        if ( right != null && right.left == null && right.right == null ) node.right = null;

        if ( node.left != null ) removeLeavesHelper(node.left);
        if ( node.right != null ) removeLeavesHelper(node.right);
    }
    
    
    


    
    
    
    
    
    
    
    
  


    






    // post: returns a sequential tree with n as its root unless
    // n is greater than max, in which case it returns an empty tree
    private IntTreeNode buildTree(int n, int max) {
        if (n > max) {
            return null;
        } else {
            return new IntTreeNode(n, buildTree(2 * n, max),
                                   buildTree(2 * n + 1, max));
        }
    }

    // post: prints the tree contents using a preorder traversal
    public void printPreorder() {
        System.out.print("preorder:");
        printPreorder(overallRoot);
        System.out.println();
    }

    // post: prints the tree contents using a preorder traversal
    // post: prints in preorder the tree with given root
    private void printPreorder(IntTreeNode root) {
        if (root != null) {
            System.out.print(" " + root.data);
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }

    // post: prints the tree contents using a inorder traversal
    public void printInorder() {
        System.out.print("inorder:");
        printInorder(overallRoot);
        System.out.println();
    }

    // post: prints in inorder the tree with given root
    private void printInorder(IntTreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(" " + root.data);
            printInorder(root.right);
        }
    }

    // post: prints the tree contents using a postorder traversal
    public void printPostorder() {
        System.out.print("postorder:");
        printPostorder(overallRoot);
        System.out.println();
    }

    // post: prints in postorder the tree with given root
    private void printPostorder(IntTreeNode root) {
        if (root != null) {
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.print(" " + root.data);
        }
    }

    // post: prints the tree contents, one per line, following an
    //       inorder traversal and using indentation to indicate
    //       node depth; prints right to left so that it looks
    //       correct when the output is rotated.
    public void printSideways() {
        printSideways(overallRoot, 0);
    }

    // post: prints in reversed inorder the tree with given
    //       root, indenting each line to the given level
    private void printSideways(IntTreeNode root, int level) {
        if (root != null) {
            printSideways(root.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(root.data);
            printSideways(root.left, level + 1);
        }
    }
    
    // toString() added by W.P. Iverson for simple console testing
    // since String is immutable, I've used StringBuilder
    public String toString() {
    	StringBuilder s = new StringBuilder();
    	toString(overallRoot, 0, s);
    	return s.toString();
    }
    
    // similar reverse in order traversal of tree as print sideways
    private void toString(IntTreeNode root, int level, StringBuilder s) {
        if (root != null) {
            toString(root.right, level + 1, s);
            String temp = new String(); // different for each node
            for (int i = 0; i < level; i++) {
            	temp += "    ";
            }
            s.append(temp + root.data + "\n"); // uses same String in recursions
            toString(root.left, level + 1, s);
        }
    }
}
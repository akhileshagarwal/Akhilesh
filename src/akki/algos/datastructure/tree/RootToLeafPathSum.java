package akki.algos.datastructure.tree;

class Node1 
{
    int data;
    Node1 left, right;
  
    Node1(int item) 
    {
        data = item;
        left = right = null;
    }
}
  
public class RootToLeafPathSum {
  
    Node1 root;
      
    /*
     Given a tree and a sum, return true if there is a path from the root
     down to a leaf, such that adding up all the values along the path
     equals the given sum.
   
     Strategy: subtract the node value from the sum when recurring down,
     and check to see if the sum is 0 when you run out of tree.
     */
  
    boolean haspathSum(Node1 node, int sum) 
    {
    	/* 
    	 * We can add a condition here to check if sum is -ve
    	 * and if it is then return. This is true only for tree 
    	 * with positive values
    	 */
            boolean ans = false;
            /* otherwise check both subtrees */
            int subsum = sum - node.data;
            if (subsum == 0 && node.left == null && node.right == null)
                return true;
            if (node.left != null)
                ans = ans || haspathSum(node.left, subsum);
            if (node.right != null)
                ans = ans || haspathSum(node.right, subsum);
            return ans;
        
    }
     
    /* Driver program to test the above functions */
    public static void main(String args[]) 
    {
        int sum = 7;
         
        /* Constructed binary tree is
              10
             /  \
           -8     2
          / \   /
         3   5 2
        */
        RootToLeafPathSum tree = new RootToLeafPathSum();
        tree.root = new Node1(10);
        tree.root.left = new Node1(-8);
        tree.root.right = new Node1(2);
        tree.root.left.left = new Node1(3);
        tree.root.left.right = new Node1(5);
        tree.root.right.left = new Node1(2);
  
        if (tree.haspathSum(tree.root, sum))
            System.out.println("There is a root to leaf path with sum " + sum);
        else
            System.out.println("There is no root to leaf path with sum " + sum);
    }
}
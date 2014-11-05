/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)    return true;
        
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 
        && isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int depth(TreeNode root){
        if(root == null)    return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}

//the following example is a balanced binary tree
//Input:	{1,2,2,3,3,3,3,4,4,4,4,4,4,#,#,5,5}
//Output:	false
//Expected:	true

//iterative solution?

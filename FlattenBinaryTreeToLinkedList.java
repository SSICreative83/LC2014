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
    public void flatten(TreeNode root) {
        root = flattenSubtree(root);
    }
    
    public TreeNode flattenSubtree(TreeNode root){
        if(root == null)    return root;
        TreeNode left = flattenSubtree(root.left);
        TreeNode right = flattenSubtree(root.right);
        
        root.left = null;
        root.right = connect(left, right); 
        
        return root;
    }
    
    public TreeNode connect(TreeNode left, TreeNode right) {
        if(left == null)    return right;
        
        TreeNode tail = left;
        while(tail.right != null)   tail = tail.right;
        tail.right = right;
        
        return left;
    }
}

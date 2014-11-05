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
    public int sumNumbers(TreeNode root) {
        if(root == null)    return 0;
        return dfs(root, 0);
        
    }
    
    public int dfs(TreeNode root, int tmp) {
        if(root == null) return tmp;
        if(root.left == null && root.right == null) return tmp * 10 + root.val;
        
        int left = 0, right = 0;
        if(root.left != null)
            left = dfs(root.left, tmp * 10 + root.val);
        if(root.right != null)
             right = dfs(root.right, tmp * 10 + root.val);
        
        return left + right;
    }
}

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0) return null;
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    public TreeNode buildTree(int[] inorder, int start1, int end1, int[] postorder, int start2, int end2){
        if(start1 > end1 || start2 > end2)  return null;
        if(start1 == end1 && start2 == end2)    return new TreeNode(inorder[start1]);
        
        TreeNode root = new TreeNode(postorder[end2]);
        
        int i = start1;
        for(; i <= end1; i++){
            if(inorder[i] == root.val){
                break;
            }
        }
        
        root.left = buildTree(inorder, start1, i - 1, postorder, start2, start2 + i - start1 - 1);
        root.right = buildTree(inorder, i + 1, end1, postorder, start2 + i - start1, end2 - 1);
        
        return root;
    }
}

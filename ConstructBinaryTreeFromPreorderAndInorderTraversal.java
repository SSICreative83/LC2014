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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)    return null;
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode buildTree(int[] preorder, int start1, int end1, int[] inorder, int start2, int end2) {
        if(start1 > end1 || start2 > end2)  return null;
        if(start1 == end1 && start2 == end2)    return new TreeNode(preorder[start1]);

        TreeNode head = new TreeNode(preorder[start1]);
        
        //make i the head index in inorder
        int i = start2; 
        for(; i <= end2; i++){
            if(inorder[i] == head.val){
                break;
            }
        }
        
        //head.left = buildTree(preorder, start1 + 1, i, inorder, start2, i - 1);
        //head.right = buildTree(preorder, i + 1, end1, inorder, i + 1, end2);
        
        head.left = buildTree(preorder, start1 + 1, start1 + i - start2 , inorder, start2, i - 1);
        head.right = buildTree(preorder, start1 + i - start2 + 1, end1, inorder, i + 1, end2);
        
        return head;

    }
}

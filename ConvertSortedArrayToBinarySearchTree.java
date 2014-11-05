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
    public TreeNode sortedArrayToBST(int[] num) {
        int len = num.length;
        if(len == 0)    return null;
        if(len == 1)    return new TreeNode(num[0]);
        
        return sortedArrayToBST(num, 0, len - 1);
    }
    
    public TreeNode sortedArrayToBST(int[] num, int start, int end) {
        int mid = start + (end - start + 1) / 2;    //left tree possibly has one more node
        TreeNode head = new TreeNode(num[mid]);
        
        
        if(start < mid) head.left = sortedArrayToBST(num, start, mid - 1);
        if(mid < end)   head.right = sortedArrayToBST(num, mid + 1, end);
        
        return head;
    }
}

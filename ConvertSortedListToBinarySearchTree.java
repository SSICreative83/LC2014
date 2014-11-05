/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        ListNode p = head;
        int len = 0;
        while(p != null){
            p = p.next;
            len++;
        }
        
        return sortedListToBST(head, len);
    }
    
    public TreeNode sortedListToBST(ListNode head, int len) {
        if(head == null || len <= 0)    return null;
        if(head.next == null || len == 1)   return new TreeNode(head.val);
        
        ListNode mid = head;
        for(int i = 0; i < len / 2; i++){
            mid = mid.next; //mid is the right side middle
        }
        
        TreeNode root = new TreeNode(mid.val);
        if(len % 2 != 0){
            root.left = sortedListToBST(head, len / 2);
            root.right = sortedListToBST(mid.next, len / 2);
        }else{
            root.left = sortedListToBST(head, len / 2);
            root.right = sortedListToBST(mid.next, len / 2 - 1);            
        }
        
        return root;
    }
}

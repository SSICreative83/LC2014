/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)    return head;
        
        ListNode node = head;
        ListNode nxt = head.next;
        
        while(nxt != null){
            if(node.val == nxt.val){
                
                nxt = nxt.next;
                
                //change pointer
                node.next = nxt;
                
            } else {
                node = nxt;
                nxt = nxt.next;
            }
        }
        
        return head;
    }
}

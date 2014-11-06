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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)   return head;
        
        ListNode newHead = new ListNode(0); //dummy node pointing to head
        newHead.next = head;
        
        ListNode fast = head;
        ListNode slow = newHead;
        
        while(fast != null && fast.next != null){
            slow.next = fast.next;
            //slow = slow.next;
            
            //fast.next = slow.next;
            //slow.next = fast;
            
            //fast = fast.next;
            //slow = slow.next;
            
            //or using following 4 lines
            fast.next = slow.next.next;
            slow.next.next = fast;
            slow = fast;
            fast = fast.next;
        }
        
        return newHead.next;
        
    }
}

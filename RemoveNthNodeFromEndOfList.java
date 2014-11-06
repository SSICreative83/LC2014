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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        
        if(head == null)    return null;
        
        while(n > 0){
            fast = fast.next;
            n--;
        }
        
        //if remove head
        if(fast == null){
            return slow.next;
        }
        
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        
        //remove slow.next
        slow.next = slow.next.next;
        
        return head;
    }
}

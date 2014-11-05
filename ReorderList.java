/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        
        //reverse the right half and do a merge
        if(head == null || head.next == null)   return;
        ListNode fast = head, slow = head, mid = null, cur = head;
        
        while(fast.next != null && fast.next.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        mid = slow.next;
        slow.next = null;
        
        mid = reverseList(mid);
        
        //do a merge
        while(mid != null){
            ListNode next = mid.next;
            mid.next = cur.next;
            cur.next = mid;
            mid = next;
            cur = cur.next.next;
        }
        
    }
    
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)   return head;
        
        ListNode pre = null, next = null;
        while(true){
            next = head.next;
            head.next = pre;
            pre = head;
            if(head.next == null)   return head;
            head = head.next;
        }
        
    }
}

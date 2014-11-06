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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null)   return head;
        
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode pre = dum;
        ListNode nxt = dum;
        
        int count = 1;
        while(count < n) {
            if(count < m) {
                pre = pre.next;
            }
            nxt = nxt.next;
            count++;
        }
        //nxt point to nth node's next
        nxt = nxt.next.next;
        
        //reverse using pre and next
        reverse(pre, nxt);
        
        return dum.next;
    }
    
    public ListNode reverse(ListNode pre, ListNode next) {
        ListNode last = pre.next;   //where first will be doomed "last"
        ListNode cur = last.next;
        
        while(cur != next){
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        
        return last;    //return new 'pre'
    }
}

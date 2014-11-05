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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)   return head;
        
        ListNode mid = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            mid = mid.next;
        }
        
        ListNode nhead = mid.next;
        mid.next = null;
        nhead = sortList(nhead);
        head = sortList(head);
        
        head = merge(head, nhead);
        return head;
        
    }
    
    public ListNode merge(ListNode h1, ListNode h2) {
        if(h1 == null && h2 == null)    return null;
        if(h1 == null){
            return h2;
        }
        if(h2 == null){
            return h1;
        }
        
        ListNode nhead = new ListNode(0);
        ListNode p = nhead;
        
        while(h1 != null && h2 != null){
            if(h1.val < h2.val){
                p.next = h1;
                h1 = h1.next;
            }else{
                p.next = h2;
                h2 = h2.next;
            }
            p = p.next;
        }
        
        if(h1 == null){
            p.next = h2;
        }else if(h2 == null){
            p.next = h1;
        }
        
        return nhead.next;
    }
}

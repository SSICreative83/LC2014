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
    public ListNode insertionSortList1(ListNode head) {
        if(head == null || head.next == null)   return head;
        
        ListNode newHead = new ListNode(head.val);
        ListNode p = head.next;
        
        while(p != null){
            boolean isTail = true;
            //current is smaller than new head
            if(p.val < newHead.val){
                ListNode newHead2 = new ListNode(p.val);
                newHead2.next = newHead;
                newHead = newHead2;
                
                p = p.next;
                continue;
            }
            
            ListNode q = newHead;
            while(q.next != null){
                //if q.next is the position to insert p
                if(q.next.val > p.val){
                    isTail = false;
                    ListNode next = q.next;
                    q.next = new ListNode(p.val);
                    q = q.next;
                    q.next = next;
                    break;
                }
                q = q.next;
            }
            
            if(isTail)  q.next = new ListNode(p.val);
            p = p.next;
        }        
        
        return newHead;
    }
    
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)   return head;
        
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;
        
        while(cur != null){
            ListNode curnext = cur.next;
            
            if(dummyHead.next == null || cur.val < dummyHead.next.val){    //insert to head
                cur.next = dummyHead.next;
                dummyHead.next = cur;
            }else{
                ListNode p = dummyHead;
                
                while(p.next != null && p.next.val < cur.val){
                    p = p.next;
                }
                
                if(p.next == null){ //insert to tail
                    p.next = cur;
                    cur.next = null;
                }else{
                    cur.next = p.next;
                    p.next = cur;
                }
            }
            
            cur = curnext;
        }
        
        return dummyHead.next;
    }
}

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
        //3 pointers?
        if(head == null || head.next == null)   return head;
        
        //head need to be removed
        while(head != null && head.next != null && head.val == head.next.val){
            ListNode p = head;
            while(p.next != null && p.next.val == p.val){
                p = p.next;
            }
            head = p.next;
        }
        
        ListNode pre = head;

        while(pre != null && pre.next != null){
            ListNode q = pre.next;
            while(q != null && q.next != null && q.val == q.next.val){
                q = q.next;
            }
            if(pre.next != q){
                pre.next = q.next;
            } else {
                pre = pre.next;
            }
        }
        
        return head;
    }
}

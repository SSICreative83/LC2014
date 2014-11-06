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
    
    //The solution is to create a new list, and change the values of nodes
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null)   return head;
        
        ListNode smallHead = new ListNode(0);
        ListNode largeHead = new ListNode(0);
        ListNode sp = smallHead;
        ListNode lp = largeHead;
        
        while(head != null){
            if(head.val < x){
                sp.next = new ListNode(head.val);
                sp = sp.next;
            }else{
                lp.next = new ListNode(head.val);
                lp = lp.next;
            }
            head = head.next;
        }
        
        //if(smallHead.next != null){
            sp.next = largeHead.next;
        //}
        return smallHead.next;
    }
}

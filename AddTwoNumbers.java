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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode l3 = new ListNode(0);
        ListNode head = l3;
        
        while(l1 != null || l2 != null){
            l3.next = new ListNode(0);
            l3 = l3.next;
            
            int current = 0;
            
            if(l1 == null){
                current = l2.val + carry;
                l2 = l2.next;
            } else if(l2 == null) {
                current = l1.val + carry;
                l1 = l1.next;
            } else {
                current = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }
            
            carry = current / 10; 
            current = current % 10;
            
            l3.val = current;
        }
        
        if(carry != 0){
            l3.next = new ListNode(carry);
        }
        
        return head.next;
    }
}

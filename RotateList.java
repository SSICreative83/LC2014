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
    public ListNode rotateRight(ListNode head, int n) {
        //naive approach: change pointers
        //better approach: use loop
        //bug at last part to find new head
        
        if(head == null || n == 0)    return head;
        
        ListNode index = head;
        int len = 1;
        
        //after the loop, index will point to last node
        while(index.next != null){
            len++;
            index = index.next;
        }
        
        //create a loop
        index.next = head;
        //move the pointer
        index = index.next;
        
        //need to move index 
        int steps = len - n % len;
        
        ListNode pre = index;
        while(steps > 0){
            if(steps == 1){
                pre = index;
            }
            index = index.next;
            steps--;
        }
        
        //break at end
        pre.next = null;
        
        return index;
    }
}

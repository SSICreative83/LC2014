/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        return helper2(head, new HashMap<RandomListNode, RandomListNode>());
    }
    
    public RandomListNode helper(RandomListNode head, HashMap<RandomListNode, RandomListNode> map) {
        if(head == null)    return null;
        
        RandomListNode newHead = new RandomListNode(head.label);
        map.put(head, newHead);
        
        if(map.containsKey(head.next)){
            newHead.next = map.get(head.next);
        }else{
            newHead.next = helper(head.next, map);
        }
        
        if(map.containsKey(head.random)){
            newHead.random = map.get(head.random);
        }else{
            newHead.random = helper(head.random, map);
        }
        return newHead;
    }
    
    public RandomListNode helper2(RandomListNode head, HashMap<RandomListNode, RandomListNode> map) {
        if(head == null)    return null;
        
        if(map.containsKey(head))   return map.get(head);
        
        RandomListNode newHead = new RandomListNode(head.label);
        map.put(head, newHead);
        
        newHead.next = helper2(head.next, map);
        newHead.random = helper2(head.random, map);
        
        return newHead;
    }
}

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    //need to maintain 2 queues, one for result, one for each level
    
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); //Queue is abstract, can't be instantiated
        queue.add(root);
        
        while(!queue.isEmpty()){
            
            ArrayList<Integer> tmp = new ArrayList<>();
            Queue<TreeNode> levelQueue = new LinkedList<TreeNode>();
            
            while(!queue.isEmpty()){
                TreeNode cur = queue.remove();
             
                tmp.add(cur.val);
                
                if(cur.left != null)  levelQueue.add(cur.left);
                if(cur.right != null)  levelQueue.add(cur.right);
            }
            
            queue = levelQueue;
            
            result.add(tmp);
            
        }
        
        return result;
    }
}

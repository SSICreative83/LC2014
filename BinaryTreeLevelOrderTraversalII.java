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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); //Queue is abstract, can't be instantiated
        queue.add(root);
        
        while(!queue.isEmpty()){
            
            ArrayList<Integer> tmp = new ArrayList<>();
            Queue<TreeNode> levelQueue = new LinkedList<TreeNode>();
            
            while(!queue.isEmpty()){
                TreeNode current = queue.remove();
                levelQueue.add(current);
            }
            
            while(!levelQueue.isEmpty()){
                TreeNode n = levelQueue.remove();
                tmp.add(n.val);
                
                if(n.left != null)  queue.add(n.left);
                if(n.right != null)  queue.add(n.right);
            }
            
            result.add(0, tmp);
        }
        
        //Collections.reverse(result);
        
        return result;        
    }
}

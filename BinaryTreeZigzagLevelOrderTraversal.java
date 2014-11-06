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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        
        Stack<TreeNode> stack = new Stack<TreeNode>(); 
        stack.push(root);
        
        int i = 0;
        while(!stack.isEmpty()){
            
            ArrayList<Integer> tmp = new ArrayList<>();
            Stack<TreeNode> nextStack = new Stack<TreeNode>();
            
            while(!stack.isEmpty()){
                
                TreeNode cur = stack.pop();
                tmp.add(cur.val);
                
                if(i % 2 == 0){
                    if(cur.left != null)  nextStack.push(cur.left);
                    if(cur.right != null)  nextStack.push(cur.right);
                }else{
                    if(cur.right != null)  nextStack.push(cur.right);    
                    if(cur.left != null)  nextStack.push(cur.left);
                }
            }
            
            stack = nextStack;
            result.add(tmp);
            i++;
        }
        
        return result;      
    }
}

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
    
    //this is better solution, because it uses mirror pre-order
    
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList result = new ArrayList<>();
        if(root == null)    return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            result.add(cur.val);
            if(cur.left != null) stack.push(cur.left);
            if(cur.right != null) stack.push(cur.right);
        }
        
        Collections.reverse(result);
        return result;
    }
    
    public ArrayList<Integer> postorderTraversal1(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null)    return result;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode current = stack.peek();
            
            if(pre == null || pre.left == current || pre.right == current){
                if(current.left != null){
                    stack.push(current.left);
                }else if(current.right != null){
                    stack.push(current.right);
                }else{
                    result.add(stack.pop().val);
                }
                
            }else if(current.left == pre){
                
                if(current.right != null){
                    stack.push(current.right);
                }else{
                    result.add(stack.pop().val);
                }
                
            }else if(current.right == pre){
                result.add(stack.pop().val);
            }
            
            pre = current;
        }
        
        return result;
        
    }
}

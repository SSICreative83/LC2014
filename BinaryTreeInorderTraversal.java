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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)    return res;
        
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        
        while(p != null || !stack.isEmpty()){
            if(p != null){
                stack.push(p);
                p = p.left;
            }else{
                TreeNode cur = stack.pop();
                res.add(cur.val);
                if(cur.right != null){
                    p = cur.right;
                }
            }
        }
        return res;
    }
}

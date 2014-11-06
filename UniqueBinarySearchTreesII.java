/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        res = generateTreesHelper(1, n);
        return res;
    }
    
    public List<TreeNode> generateTreesHelper(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        if(start > end){
            res.add(null);
            return res;
        }     
        
        for(int i = start; i <= end; i++){  //treat every number as root
            List<TreeNode> left = generateTreesHelper(start, i - 1);
            List<TreeNode> right = generateTreesHelper(i + 1, end);
            
            //TreeNode root = new TreeNode(i);

            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
            
        }
        
        return res;
    }
}

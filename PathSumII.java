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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)    return result;
        
        List<Integer> tmp = new ArrayList<>();
        tmp.add(root.val);
        dfs(root, sum, tmp, result);
        return result;
    }
    
    public void dfs(TreeNode root, int sum, List<Integer> tmp, List<List<Integer>> result){
        int currentSum = 0;
        for(int i : tmp){
            currentSum += i;
        }
        
        //This is leaf
        if(root.left == null && root.right == null){
            if(sum == currentSum){
                result.add(tmp);
                return;
            }else{
                return;
            }
        }
        
        //This is not leaf
       // if(currentSum < sum){
            if(root.left != null){
                List<Integer> ntmp = new ArrayList<>(tmp);
                ntmp.add(root.left.val);
        
                dfs(root.left, sum, ntmp, result);
                
            }
            if(root.right != null)  {
                List<Integer> ntmp = new ArrayList<>(tmp);
                ntmp.add(root.right.val);
                dfs(root.right, sum, ntmp, result);
            }
       // }
    }
}

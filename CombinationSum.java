public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        if(candidates.length == 0)  return result;
        
        Arrays.sort(candidates);
        ArrayList<Integer> tmp = new ArrayList<>();
        
        dfs(candidates, 0, target, tmp, result);
        return result;
    }
    
    public void dfs(int[] candidates, int start, int target, ArrayList<Integer> tmp, ArrayList<ArrayList<Integer>> result){
        int curSum = 0;
        for(int i : tmp){
            curSum += i;
        }
        
        if(curSum == target){
            result.add(tmp);
            return;
        }
        
        if(curSum > target) return;
        
        for(int i = start; i < candidates.length; i++){
            int cur = candidates[i];
            ArrayList<Integer> ntmp = new ArrayList<>(tmp);
            ntmp.add(cur);
            dfs(candidates, i, target, ntmp, result);
        }
    }
}

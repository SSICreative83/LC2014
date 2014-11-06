public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(n == 0 || k == 0 || n < k)   return res;
        
        dfs(n, k, 0, new ArrayList<Integer>(), res);
        return res;
        
    }
    
    public void dfs(int n, int k, int min, List<Integer> tmp, List<List<Integer>> res){
        if(tmp.size() == k){
            res.add(tmp);
            return;
        }
        
        for(int i = min + 1; i <= n; i++){
            List<Integer> ntmp = new ArrayList<>(tmp);
            ntmp.add(i);
            dfs(n, k, i, ntmp, res);
        }
    }
}

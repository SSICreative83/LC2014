public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(num == null) {
            return res;
        }
        
        Arrays.sort(num);
        List<Integer> tmp = new ArrayList<>();
        dfs(num, 0, tmp, res);
        
        return res;        
    }
    
    public void dfs(int[] S, int start, List<Integer> tmp, List<List<Integer>> res) {
        res.add(tmp);
        
        for(int i = start; i < S.length; i = increment(S, i)) {
            List<Integer> ntmp = new ArrayList<>(tmp);
            ntmp.add(S[i]);
            dfs(S, i + 1, ntmp, res);
        }
    }
    
    public int increment(int[] S, int i) {
        i++;
        while(i < S.length && S[i] == S[i - 1]) {
            i++;
        }
        
        return i;
    }
}

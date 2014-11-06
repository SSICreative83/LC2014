public class Solution {
    
    //Recursion solution
    public List<List<Integer>> permute1(int[] num) {
        int len = num.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len == 0)    return res;
        if(len == 1){
            List<Integer> tmp = new ArrayList<>();
            tmp.add(num[0]);
            res.add(tmp);
            return res;
        }
        
        for(int i = 0; i < len; i++){
            //build a subset of length len - 1
            int[] subset = new int[len - 1];
            for(int j = 0; j < i; j++){
                subset[j] = num[j];
            }
            for(int j = i + 1; j < len; j++){
                subset[j - 1] = num[j];
            }
            
            for(List<Integer> per : permute(subset)){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(num[i]);
                tmp.addAll(per);
                res.add(tmp);
            }
        }
        
        return res;
    }
    
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        if(num == null || num.length == 0)  return res;
        
        List<Integer> tmp = new ArrayList<>();
        dfs(num, tmp, res);
        return res;
    }
    
    public void dfs(int[] num, List<Integer> tmp, List<List<Integer>> res) {
        if(num.length == 0){
            res.add(tmp);
            return;
        }
        
        for(int i = 0; i < num.length; i++){
            //new num
            int[] nnum = new int[num.length - 1];
            for(int j = 0; j < i; j++){
                nnum[j] = num[j];
            }
            for(int j = i + 1; j < num.length; j++){
                nnum[j - 1] = num[j];
            }
            
            List<Integer> ntmp = new ArrayList<>(tmp);
            ntmp.add(num[i]);
            dfs(nnum, ntmp, res);
        }
    }
    
}

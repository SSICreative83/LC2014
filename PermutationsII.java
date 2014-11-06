public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        int len = num.length;
        if(len == 0) return result;
        
        Arrays.sort(num);
        ArrayList<Integer> tmp = new ArrayList<>();
        
        ArrayList<Integer> nnum = new ArrayList<>();
        for(int i : num){
            nnum.add(i);
        }
        
        dfs(nnum, tmp, result);
        return result;
    }
    
    public void dfs(ArrayList<Integer> remain, ArrayList<Integer> tmp, ArrayList<ArrayList<Integer>> result){
        
        if(remain.size() == 0){
            result.add(tmp);
        }
        
        for(int i = 0; i < remain.size(); i = increment(remain, i)){
            ArrayList<Integer> ntmp = new ArrayList<>(tmp);
            ArrayList<Integer> nremain = new ArrayList<>(remain);
            ntmp.add(remain.get(i));
            nremain.remove(i);
            dfs(nremain, ntmp, result);
        }
    }
    
    public int increment(ArrayList<Integer> remain, int i){
        i++;
        while(i < remain.size() && remain.get(i - 1) == remain.get(i)) i++;
        return i;
    }
}

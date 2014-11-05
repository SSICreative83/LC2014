public class Solution {
    public int minCut(String s) {
        int len = s.length();
        if(len == 0 || len == 1)    return 0;
        
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> tmp = new ArrayList<>();
        return dfs(s, 0, len - 1, tmp, result);
        
        //int min = Integer.MAX_VALUE;
        //for(ArrayList<String> current : result){
        //    min = Math.min(min, current.size() - 1);
        //}
        //return min;
    }
    
    public int dfs(String s, int start, int end, ArrayList<String> tmp, ArrayList<ArrayList<String>> result) {   
        if(start > end) return tmp.size() - 1;
        
        for(int i = start; i <= end; i++){
            if(isPalin(s.substring(start, i + 1))){
                ArrayList<String> ntmp = new ArrayList<>(tmp);
                ntmp.add(s.substring(start, i + 1));
                dfs(s, i + 1, end, ntmp, result);
            }
        }
    }
    
    public boolean isPalin(String s) {
        int len = s.length();
        if(len == 0)    return false;
        if(len == 1)    return true;
        
        for(int i = 0, j = len - 1; i < j; i++, j--){
            if(s.charAt(i) != s.charAt(j))  return false;
        }
        
        return true;
    }
}

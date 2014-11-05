public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        
        if(s.length() == 0) return result;
        
        ArrayList<String> tmp = new ArrayList<>();
        
        dfs(s, 0, tmp, result);
        return result;
    }
    
    public void dfs(String s, int start, ArrayList<String> tmp, ArrayList<ArrayList<String>> result){
        if(start == s.length()){
            result.add(tmp);
            return;
        }
        
        for(int i = start; i < s.length(); i++) {
            if(isPalin(s.substring(start, i + 1))){
                ArrayList<String> ntmp = new ArrayList<>(tmp);
                ntmp.add(s.substring(start, i + 1));
                dfs(s, i + 1, ntmp, result);
            }
        }
    }
    
    public boolean isPalin(String s) {
        if(s.length() == 0) return false;
        if(s.length() == 1) return true;
        
        for(int i = 0, j = s.length() - 1; i < j; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}

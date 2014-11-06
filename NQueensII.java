public class Solution {
    int result = 0;     //use result as gloval variable
        
    public int totalNQueens(int n) {
        if(n <= 0)  return 0;
        int[] loc = new int[n];
        
        dfs(n, loc, 0);
        return result;
    }
    
    public void dfs(int n, int[] loc, int cur) {
        if(cur == n) {
            result++;
            return;
        }
        
        for(int i = 0; i < n; i++){
            loc[cur] = i;
            if(isValid(loc, cur, i)){
                dfs(n, loc, cur + 1);
            }
        }
    }
    
    public boolean isValid(int[] loc, int cur, int value) {
        for(int i = 0; i < cur; i++){
            if(loc[i] == value || Math.abs(loc[i] - loc[cur]) == cur - i)   return false;
        }
        return true;
    }
}

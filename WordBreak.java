public class Solution {
    public boolean wordBreak1(String s, Set<String> dict) {
        if(s == null || s.length() == 0 || dict == null || dict.size() == 0) {
            return false;
        }  
        
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        
        for(int i = 0; i < len; i++) {
            if(dict.contains(s.substring(i, i + 1))) {
                dp[i][i] = true;
            }
        }
        
        for(int i = len - 2; i >= 0; i--) {
            for(int j = i + 1; j < len; j++) {
                if(dict.contains(s.substring(i, j + 1))) {
                    dp[i][j] = true;
                }
                
                for(int k = i; k < j; k++) {    //k < j, since k + 1 will be used
                    if(dp[i][k] && dp[k + 1][j]) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        
        return dp[0][len - 1];
    }
    
    public boolean wordBreak(String s, Set<String> dict) {
        if(s == null || s.length() == 0 || dict == null)
            return true;
            
        int length = s.length();
 
        //dp[i] is true when the substring from i to the end can be partitioned
        boolean[] dp = new boolean[length + 1];
            
        //empty string can be partitioned for sure    
        dp[length] = true;    
        
        //bottom up dp, start from the end
        for(int i = length - 1;i >= 0; i--){
            for(int j = i;j < length;j++){
                String sub = s.substring(i,j+1);
                if(dict.contains(sub) && dp[j+1] == true){
                    dp[i]= true;
                    break;  //break, just jump out current level of loop
                }
            }
        }
        
        return dp[0];
    }
}

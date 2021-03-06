public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        
        if(len1 + len2 != len3) return false;
        if(len1 == 0)   return s2.equals(s3);
        if(len2 == 0)   return s1.equals(s3);
        
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        
        for(int i = 1; i < len1 + 1; i++){
            if(s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0])
                dp[i][0] = true;
        }
        
        for(int j = 1; j < len2 + 1; j++){
            if(s2.charAt(j - 1) == s3.charAt(j - 1) && dp[0][j - 1])
                dp[0][j] = true;
        }
        
        for(int i = 1; i < len1 + 1; i++){
            for(int j = 1; j < len2 + 1; j++){
                if((s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1]) || (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j]))             
                    dp[i][j] = true;
            }
        }
        
        return dp[len1][len2];
    }
}

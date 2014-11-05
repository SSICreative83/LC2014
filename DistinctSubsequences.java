public class Solution {
    public int numDistinct(String S, String T) {
        int len1 = S.length();
        int len2 = T.length();
        if(len1 == 0 || len2 == 0 || len1 < len2)  return 0;
        
        int[][] res = new int[len2 + 1][len1 + 1];
        for(int i = 0; i < len1 + 1; i++){
            res[0][i] = 1;
        }
        for(int i = 1; i < len2 + 1; i++){
            res[i][0] = 0;
        }
        
        for(int i = 1; i < len2 + 1; i++){
            for(int j = 1; j < len1 + 1; j++){
                if(T.charAt(i - 1) == S.charAt(j - 1)){
                    res[i][j] = res[i][j - 1] + res[i - 1][j - 1];
                }else{
                    res[i][j] = res[i][j - 1];
                }
            }
        }
        
        return res[len2][len1];
    }
    
}

public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        String res = "";
        
        for(int i = 0; i < len; i++){
            
            String s1 = palin(s, i, i);
            String s2 = palin(s, i, i + 1);
            
            String curMax = s1.length() > s2.length() ? s1 : s2;
            if(curMax.length() > res.length()){
                res = curMax;
            }
            
        }
        
        return res;
    }
    
    public String palin(String s, int i, int j) {
        String res = "";
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        res = s.substring(i + 1, j);
        return res;
    }
}

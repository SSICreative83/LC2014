public class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length();
        if(len < 2)    return true;
        
        s = s.toLowerCase();
        
        for(int i = 0, j = len - 1; i <= j; i++, j--){
            while(i < len - 1 && !isChar(s.charAt(i)) && !isNum(s.charAt(i))) i++;
            while(j > 0 && !isChar(s.charAt(j)) && !isNum(s.charAt(j))) j--;
            
            if(!isPalinChars(s.charAt(i), s.charAt(j)))  return false;
        }
        
        return true;
    }
    
    public boolean isChar(char c){
        return c >= 'a' && c <= 'z';
    }
    
    public boolean isNum(char c){
        return c >= '0' && c <= '9';
    }
    
    public boolean isPalinChars(char c1, char c2){
        if(isNum(c1) || isChar(c1) || isNum(c2) || isChar(c2))   return c1 == c2;
        return true;
    }
}

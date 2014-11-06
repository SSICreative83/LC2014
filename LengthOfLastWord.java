public class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int len = s.length();
        if(len == 0)    return 0;
        int result = 0;
        
        for(int i = len - 1; i >= 0; i--){
            if(s.charAt(i) == ' '){
                String s1 = s.substring(i + 1, len);
                result = s1.length();
                break;
            }
            
            if(i == 0){
                result = s.length();
            }
        }
        
        
        
        return result;
    }
}

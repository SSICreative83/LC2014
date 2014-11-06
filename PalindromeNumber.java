public class Solution {
    public boolean isPalindrome(int x) {
        if(x == 0)  return true;
        if(x < 0)   return false;   //negative numbers are NOT palindrome
        
        int i = 1;
        while(x / i >= 10)    i *= 10;
        
        for(; x > 0; i /= 100){
            int left = x / i;
            int right = x % 10;
            if(left != right){
                return false;
            }
            x %= i;
            x /= 10;
        }
        
        return true;
    }
}

public class Solution {
    public int reverse(int x) {
        if(x == 0)  return 0;
        
        int result = 0;
        boolean isPossitive = true;
        if(x < 0)  {
            isPossitive = false;
            x = -1 * x;
        }
        
        while (x > 0){
            result = 10 * result;
            result += x % 10;
            x = x / 10;
        }
        
        if(!isPossitive)    result = -1 * result;
        return result;
            
    }
}

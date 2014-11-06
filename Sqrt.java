public class Solution {
    public int sqrt(int x) {
        if(x < 2)  return x;
        int result = 0;
        
        for(int i = 1, j = x / 2; i <= j;){
            int mid = (i + j) / 2;
            
            if(x / mid == mid){
                result = mid;
                break;
                
            } else if(x / mid > mid){
                i = mid + 1;    //need to use mid to increase i and decrease j
                result = mid;
                
            } else {
                j = mid - 1;
            }
            
        }
        
        return result;
    }
}

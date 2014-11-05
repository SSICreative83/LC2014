public class Solution {
    public int singleNumber(int[] A) {
        int len = A.length;
        if(len <= 0)    return -1;
        
        int[] bitsCount = new int[32];
        int result = 0;
        
        for(int i = 0; i < bitsCount.length; i++){
            
            for(int j = 0; j < len; j++){
                
                if((A[j] >> i & 1) == 1){ //A[j] bit i is 1
                    bitsCount[i] = (bitsCount[i] + 1) % 3;
                }
    
            }
            
            result |= (bitsCount[i] << i);
            
        }
        
        return result;
    }
}

public class Solution {
    public int maxSubArray(int[] A) {
        int len = A.length;
        if(len == 0)    return 0;
        
        int curSum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < len; i++){
            if(curSum < 0)  curSum = 0;
            curSum += A[i];
            max = Math.max(max, curSum);
        }
        
        return max;
    }
}

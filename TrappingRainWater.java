public class Solution {
    public int trap(int[] A) {
        int len = A.length;
        if(len <= 2) return 0;
        
        //get the maxRight array
        int[] maxRight = new int[len];
        maxRight[len - 1] = 0;
        for(int i = len - 2; i >= 0; i--){
            maxRight[i] = Math.max(maxRight[i + 1], A[i + 1]);
        }
        
        //get the maxLeft array
        int[] maxLeft = new int[len];
        maxLeft[0] = 0;
        for(int i = 1; i < len; i++){
            maxLeft[i] = Math.max(maxLeft[i - 1], A[i - 1]);
        }
        
        //calculate water. min(maxRight[i], maxLeft[i]) - A[i]
        int sum = 0;
        for(int i = 0; i < len; i++){
            sum += Math.max(Math.min(maxLeft[i], maxRight[i]) - A[i], 0);
        }
        return sum;
    }
}

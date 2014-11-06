public class Solution {
    public boolean canJump(int[] A) {
        int len = A.length;
        int max = 0;
        for(int i = 0; i < len && i <= max; i++){
            max = Math.max(max, i + A[i]);
            if(max >= len - 1)  return true;
        }
        
        return false;
    }
}

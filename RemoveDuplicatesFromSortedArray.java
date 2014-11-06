public class Solution {
    public int removeDuplicates(int[] A) {
        int len = A.length;
        
        if(len < 2) return len;
        
        int i = 0;
        for(int j = 0; j < len; j++){
            if(A[i] != A[j]){
                A[++i] = A[j];
            }
        }
        
        return i + 1;
    }
}

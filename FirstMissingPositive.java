public class Solution {
    public int firstMissingPositive(int[] A) {
        int len = A.length;
        if(len == 0)    return 1;
        
        for(int i = 0; i < len; i++){
            int index = i + 1;
            while(A[i] > 0 && A[i] != index && A[i] <= len){
                if(A[i] == A[A[i] - 1])  break;
                swap(A, i, A[i] - 1);
            }
        }
        
        for(int i = 0; i < len; i++){
            int index = i + 1;
            if(A[i] != index)   return index;
        }
        return len + 1;
    }
    
    public void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}

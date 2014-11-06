public class Solution {
    public void sortColors(int[] A) {
        int len = A.length;
        if(len == 0)    return;
        
        int lt = 0, gt = len - 1, i = 0;
        while(i <= gt){
            if(A[i] > 1){
                swap(A, i, gt--);
            }else if(A[i] < 1){
                swap(A, i++, lt++);
            }else
                i++;
        }
        
    }
    
    public void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}

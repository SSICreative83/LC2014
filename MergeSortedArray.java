public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        if(n == 0)  return;
        
        int len = m + n;
        int indexA = m - 1;
        int indexB = n - 1;
        for(int i = len - 1; i >= 0; i--){
            if(indexA < 0){
                A[i] = B[indexB--];
            } else if(indexB < 0){
                A[i] = A[indexA--];
            } else if(A[indexA] >= B[indexB]){
                A[i] = A[indexA--];
            } else {
                A[i] = B[indexB--];
            }
        }
    }
}

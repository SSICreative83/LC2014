public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0)  return false;
        int n = matrix[0].length;
        if(n == 0)  return false;
        
        //search first element in each row 
        int row = 0, i = 0;
        for(; i < m; i++){
            if(matrix[i][0] == target)  return true;
            if(matrix[i][0] > target){
                if(i == 0)  return false;
                else{
                     row = i - 1;
                     break;
                }   
            }
        }
        if(i == m)  row = m - 1;
        
        for(int j = 0; j < n; j++){
            if(matrix[row][j] == target)    return true;
            if(matrix[row][j] > target)     return false;
        }
        return false;
    }
}

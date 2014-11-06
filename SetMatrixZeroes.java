public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if(m == 0)  return;
        int n = matrix[0].length;
        if(n == 0)  return;
        
        boolean isFirstRowZero = false;
        boolean isFirstColZero = false;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    if(i == 0 && j == 0){
                        isFirstRowZero = true;
                        isFirstColZero = true;
                    }else if(i == 0){
                        isFirstRowZero = true;
                    }else if(j == 0){
                        isFirstColZero = true;
                    }else{
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                        matrix[i][j] = 1;
                    }
                }
            }
        }
        
        for(int j = 1; j < n; j++){
            if(matrix[0][j] == 0){
                for(int i = 0; i < m; i++){
                    matrix[i][j] = 0;
                }
            }
        }
        
        for(int i = 1; i < m; i++){
            if(matrix[i][0] == 0){
                for(int j = 0; j < n; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(isFirstColZero){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
        
        if(isFirstRowZero){
            for(int j = 0; j < n; j++){
                matrix[0][j] = 0;
            }
        }
    }
}

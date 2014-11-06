public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        if(m == 0 || n == 0 || obstacleGrid[0][0] == 1)  return 0;
        
        int[][] result = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    result[i][j] = 1;
                }
                else if(i == 0){     //first row
                    if(obstacleGrid[i][j] == 1){
                        result[i][j] = 0;
                    }else{
                        result[i][j] = result[i][j - 1];
                    }                    
                }
                else if(j == 0){    //first column
                    if(obstacleGrid[i][j] == 1){
                        result[i][j] = 0;
                    }else{
                        result[i][j] = result[i - 1][j];
                    }
                }
                else{
                    if(obstacleGrid[i][j] == 1){
                        result[i][j] = 0;
                    }else{
                        result[i][j] = result[i][j - 1] + result[i - 1][j];
                    }
                }
            }
        }
        return result[m - 1][n - 1];
    }
}

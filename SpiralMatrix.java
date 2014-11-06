public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        
        int m = matrix.length;
        if(m == 0)  return result;
        int n = matrix[0].length;
        if(n == 0)  return result;
        
        int x = 0, y = 0;
        for(int i = n, h = m; i > 0 && h > 0; i -= 2, h -= 2){  //this is key, condition need to be &&
            //if(i == 1 && h == 1){
            //    result.add(matrix[x][y]);
            //}
            //else 
            if(h == 1){
                for(int j = 0; j < i; j++)
                    result.add(matrix[x][y++]);
                break;                              //need to break
            }else if(i == 1){
                for(int j = 0; j < h; j++)
                    result.add(matrix[x++][y]);
                break;
            }
            
            
            for(int j = 0; j < i - 1; j++){
                result.add(matrix[x][y++]);
            }
            
            
            for(int j = 0; j < h - 1; j++){
                result.add(matrix[x++][y]);
            }
            
            for(int j = 0; j < i - 1; j++){
                result.add(matrix[x][y--]);
            }
            
            for(int j = 0; j < h - 1; j++){
                result.add(matrix[x--][y]);
            }
            
            x++;
            y++;
            
        }
        
        return result;
    }
}

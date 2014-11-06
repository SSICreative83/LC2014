public class Solution {
    public void solveSudoku(char[][] board) {
        //assume size is 9 * 9
        ArrayList<Integer> empty = new ArrayList<>();
         
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    empty.add(i * 9 + j);
                }
            }
        }
        
        dfs(board, empty, 0, empty.size()); //end size is empty.size() not empty.size() - 1
    }
    
    public boolean dfs(char[][] board, ArrayList<Integer> empty, int current, int end) {
        if(current == end)  return true;    //notice this end condition
        
        int row = empty.get(current) / 9;
        int col = empty.get(current) % 9;
        
        for(int i = 1; i <= 9; i++){
            if(isValid(board, row, col, i)){
                board[row][col] = (char)(i + '0');
                if(dfs(board, empty, current + 1, end)) return true;
                board[row][col] = '.';
            }
        }
        
        return false;
    }
    
    public boolean isValid(char[][] board, int row, int col, int value) {
        
        for(int i = 0; i < 9; i++){
            if(board[row][i] - '0' == value)  return false;
            if(board[i][col] - '0' == value)  return false;
        }
        
        for(int i = 3 * (row / 3) + 0; i < 3 * (row / 3) + 3; i++){
            for(int j = 3 * (col / 3) + 0; j < 3 * (col / 3) + 3; j++){
                if(board[i][j] - '0' == value)    return false;
            }
        }
        
        return true;
    }
    
    
}

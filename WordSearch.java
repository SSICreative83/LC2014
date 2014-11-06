public class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0)    return true;
        int n = board.length;
        if(n == 0)  return false;
        
        int m = board[0].length;
        if(m == 0)  return false;
        
        char start = word.charAt(0);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == start){
                    
                    board[i][j] = ' ';
                    
                    if(dfs(board, word, 1, i, j)) return true;
                    
                    board[i][j] = start;
                }
            }
        }
        
        //dfs(board, word, 0, 0, 0);
        return false;
    }
    
    public boolean dfs(char[][] board, String word, int start, int row, int col) {
        if(start == word.length()) return true;
        
        char current = word.charAt(start);  //see if current is at left, right, top, bottom
        int m = board.length;
        int n = board[0].length;
        
        //top
        if(row > 0 && board[row - 1][col] == current) {
            board[row - 1][col] = ' ';
            if(dfs(board, word, start + 1, row - 1, col))   return true;
            board[row - 1][col] = current;
        }
        
        //bottom
        if(row < m - 1 && board[row + 1][col] == current) {
            board[row + 1][col] = ' ';
            if(dfs(board, word, start + 1, row + 1, col))   return true;
            board[row + 1][col] = current;
        }
        
        //left
        if(col > 0 && board[row][col - 1] == current) {
            board[row][col - 1] = ' ';
            if(dfs(board, word, start + 1, row, col - 1))   return true;
            board[row][col - 1] = current;
        }
        
        //right
        if(col < n - 1 && board[row][col + 1] == current) {
            board[row][col + 1] = ' ';
            if(dfs(board, word, start + 1, row, col + 1))   return true;
            board[row][col + 1] = current;
        }
        
        return false;
        
    }
    
}

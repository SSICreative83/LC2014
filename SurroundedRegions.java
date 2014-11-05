public class Solution {
    //This uses 2-D dfs, which is slow, but after adding more conditions, it passed
    
    public void solve(char[][] board) {
        
        int m = board.length;
        if(m == 0)  return;
        int n = board[0].length;
        if(n == 0)  return;
        
        for(int i = 0; i < m; i++){
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }

        for(int j = 1; j < n - 1; j++){
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == 'N'){
                    board[i][j] = 'O';
                }
            }
        }
        
    }
    
    public void dfs(char[][] board, int i, int j){

        if(board[i][j] == 'O'){
            board[i][j] = 'N';
        }else{
            return;
        }
        
        int m = board.length;
        int n = board[0].length;
        
        //up
        if(i > 1){                      //condition is important
            dfs(board, i - 1, j);
        }
        
        //down
        if(i < m - 2){
            dfs(board, i + 1, j);
        }
        
        //left
        if(j > 1){
            dfs(board, i, j - 1);
        }
        
        //right
        if(j < n - 2){
            dfs(board, i, j + 1);
        }
        
        return;
    }
}

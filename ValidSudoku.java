public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        
        //don't need to check other numbers (input is only '1' - '9')
        HashSet<Character> set = new HashSet<>();
        //every row
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j]!='.'){
                    if(set.contains(board[i][j])){
                        return false;
                    }else{
                        set.add(board[i][j]);
                    }
                } 
            }
           set.clear();
        }
        
        //every column
        for(int j = 0; j < n; j++){
            for(int i = 0; i < n; i++){
                //if(board[i][j]!='.' && !set.add(board[i][j])) return false;
                if(board[i][j]!='.'){
                    if(set.contains(board[i][j])){
                        return false;
                    }else{
                        set.add(board[i][j]);
                    }
                }
            }
            set.clear();
        }
        
        //every cell
        int m = n / 3;
        for(int k = 0; k < m; k++){
            for(int h = 0; h < m; h++){
                
                for(int i = k * 3; i < k * 3 + 3; i++){
                    for(int j = h * 3; j < h * 3 + 3; j++){
                        //if(board[i][j]!='.' && !set.add(board[i][j])) return false; 
                        if(board[i][j]!='.'){
                            if(set.contains(board[i][j])){
                                return false;
                            }else{
                                set.add(board[i][j]);
                            }
                        }
                    }
                }
                set.clear();
            }
        }
        
        return true;
    }
}

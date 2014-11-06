public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        
        if(n == 0)  return result;
        
        dfs(n, n, "", result);
        return result;
    }
    
    public void dfs(int left, int right, String tmp, ArrayList<String> result) {
        if(left == 0 && right == 0){
            result.add(tmp);
            return;
        }
        if(left > 0){
            dfs(left - 1, right, tmp + "(", result);
        }
        if(left < right){
            dfs(left, right - 1, tmp + ")", result);
        }
    }
}

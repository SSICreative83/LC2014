public class Solution {
    public List<String> letterCombinations(String digits) {
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        List<String> result = new ArrayList<String>();
        //if(digits.length() == 0)    return result;
        
        dfs(digits, map, 0, "", result);
        return result;
    }
    
    public void dfs(String digits, String[] map, int index, String tmp, List<String> result) {
        if(index == digits.length()){
            result.add(tmp);
            return;
        }
        
        String cur = map[digits.charAt(index) - '0'];
        for(int i = 0; i < cur.length(); i++){
            String ntmp = tmp + cur.charAt(i);
            dfs(digits, map, index + 1, ntmp, result);
        }
    }
}

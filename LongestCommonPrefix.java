public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)    return "";
        int len = strs.length;
        String res = strs[0];
        
        while(res.length() > 0){
            int i = 1;
            for(; i < len; i++){
                if(!strs[i].startsWith(res))
                    break;
            }
            if(i == len){
                return res;
            }
            res = res.substring(0, res.length() - 1);
        }
        
        return "";
    }
}

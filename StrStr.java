public class Solution {
    public String strStr(String haystack, String needle) {
        int len = haystack.length();
        int nlen = needle.length();
        
        //if(len == 0 || nlen == 0)   return null;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < len - nlen + 1; i++){
            String cur = haystack.substring(i, i + nlen);
            if(!map.containsKey(cur)){
                map.put(cur, i);
            }
        }
        
        if(map.containsKey(needle)){
            int start = map.get(needle);
            return haystack.substring(start);
        }else{
            return null;
        }
        
    }
}

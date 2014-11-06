public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if(len == 0)    return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        int start = 0;
        int max = 0;
        for(int i = 0; i < len; i++){
            char cur = s.charAt(i);
            if(map.containsKey(cur)){
                int index = map.get(cur);
                for(int j = start; j <= index; j++){
                    char key = s.charAt(j);
                    map.remove(key);
                }
                map.put(cur, i);
                start = index + 1;
            }else{
                map.put(cur, i);
                max = Math.max(max, i - start + 1);
            }
        }
        
        return max;
    }
}

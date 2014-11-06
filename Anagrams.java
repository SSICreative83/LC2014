public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> res = new ArrayList<>();
        if(strs.length == 0)    return res;
        
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            String cur = strs[i];
            char[] arr = cur.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            if(map.containsKey(key)){
                map.get(key).add(cur);
            }else{
                List<String> list = new ArrayList<>();
                list.add(cur);
                map.put(key, list);
            }
        }
        
        for(List<String> list : map.values()){
            if(list.size() > 1){
                for(String s : list){
                    res.add(s);
                }
            }
        }
        return res;
    }
}

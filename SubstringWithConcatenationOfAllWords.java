public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        int len = S.length();
        List<Integer> res = new ArrayList<>();
        if(len == 0 || L.length == 0)   return res;
        int wlen = L[0].length();
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < L.length; i++){
            String cur = L[i];
            if(map.containsKey(cur)){
                map.put(cur, map.get(cur) + 1);
            }else{
                map.put(cur, 1);
            }
        }
        
        for(int j = 0; j <= len - L.length * wlen; j++){
            HashMap<String, Integer> nmap = new HashMap<>(map);
            
            for(int k = j; k <= len - wlen; k += wlen){
                String cur = S.substring(k, k + wlen);
                if(nmap.containsKey(cur)){
                    nmap.put(cur, nmap.get(cur) - 1);
                    if(nmap.get(cur) == 0)  nmap.remove(cur);
                }else{
                    break;
                }
                if(nmap.isEmpty()){
                    res.add(j);
                    break;
                }
            }
        }
        return res;
    }
}

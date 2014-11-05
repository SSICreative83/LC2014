public class Solution {
    public int longestConsecutive(int[] num) {
        int len = num.length;
        if(len == 0)    return 0;
        
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        
        for(int i = 0; i < len; i++){
            set.add(num[i]);
        }
        
        for(int i = 0; i < len; i++){
            int cur1 = num[i];
            int cur2 = num[i];
            while(set.contains(cur1)) {
                set.remove(cur1);
                cur1--;
            }
            set.add(cur2);
            while(set.contains(cur2)){
                set.remove(cur2);
                cur2++;
            }
            res = Math.max(res, cur2 - cur1 - 1);
        }
        
        return res;
    }
}

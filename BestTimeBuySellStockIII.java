public class Solution {
    //http://blog.csdn.net/fightforyourdream/article/details/14503469
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len < 2)    return 0;
        
        int[] max_to_current = new int[len];
        int min = prices[0];
        int[] max_to_len = new int[len];
        int max = prices[len - 1];
        int result = 0;
        
        for(int i = 1; i < len; i++){
            min = Math.min(min, prices[i]);
            max_to_current[i] = Math.max(max_to_current[i - 1], prices[i] - min);
        }
        
        for(int i = len - 2; i >= 0; i--){
            max = Math.max(max, prices[i]);
            max_to_len[i] = Math.max(max_to_len[i + 1], max - prices[i]);
        }
        
        for(int i = 0; i < len; i++){
            result = Math.max(result, max_to_current[i] + max_to_len[i]);   
        }
        return result;
    }
}

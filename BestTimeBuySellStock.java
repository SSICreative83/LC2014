public class Solution {
    public int maxProfit(int[] prices) {
        
        //naive approach: O(n^2), time limit exceeded
        //one pass
        
        if(prices.length < 2)   return 0;
        
        int maxProfit = 0;
        int min = prices[0];
        
        for(int i = 0; i < prices.length; i++){
 //           for(int j = i + 1; j < prices.length; j++){
 //               maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
 //           }
            min = Math.min(min, prices[i]); //
            maxProfit = Math.max(maxProfit, prices[i] - min);
            
        }
        
        return maxProfit;
    }
}

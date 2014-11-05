public class Solution {
    
    //[1, 2, 2], output: 5, expected: 4
    //need to start from left and right
    
    public int candy(int[] ratings) {
        int len = ratings.length;
        if(len < 2)    return len;
        
        int sum = 0;
        int[] candies = new int[len];
        
        for(int i = 0; i < len; i++){
           candies[i] = 1;
        }
        
        for(int i = 1; i < len; i++){
            if(ratings[i] > ratings[i - 1]){
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        for(int i = len - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]){    //condition is important
                candies[i] = candies[i + 1] + 1;
            }
        }
        
        for(int i = 0; i < len; i++){
           sum += candies[i];
        }
        
        return sum;
    }   
}

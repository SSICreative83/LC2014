public class Solution {
    public int threeSumClosest(int[] num, int target) {
        int len = num.length;
        int result = num[0] + num[1] + num[2];
        
        Arrays.sort(num);
        for(int i = 0; i < len - 2; i = increment(num, i)){
            for(int j = i + 1, k = len - 1; j < k; ){
                if(num[i] + num[j] + num[k] == target){
                    return target;
                }
                else if(Math.abs(num[i] + num[j] + num[k] - target) < Math.abs(result - target)){//closer
                    result = num[i] + num[j] + num[k];
                }
                if(num[i] + num[j] + num[k] < target){
                    j = increment(num, j);
                } else {
                    k = decrement(num, k);
                }
            }
        }
        return result;
    } 
    
    public int increment(int[] num, int i){
        i++;
        while(i < num.length && num[i] == num[i - 1])   i++;
        return i;
    }
    
    public int decrement(int[] num, int i){
        i--;
        while(i >= 0 && num[i] == num[i + 1])   i--;
        return i;
    }
}

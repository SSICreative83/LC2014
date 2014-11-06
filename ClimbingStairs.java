public class Solution {
    public int climbStairs(int n) {
        if(n <= 0)  return 0;
        if(n == 1)  return 1;
        
        //naive way: recursion
        //return climbStairs(n - 2) + climbStairs(n - 1);
        
        //better way: use array to store result
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        
        for(int i = 2; i < n + 1; i++){
            result[i] = result[i - 2] + result[i - 1];
        }
        
        return result[n];
    }
}

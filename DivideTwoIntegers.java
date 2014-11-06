public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0){
            throw new ArithmeticException("Can't devide by zero!");
        }
        //int sign = (dividend ^ divisor) > 0 ? -1 : 1;
        int sign = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ? 1 : -1;
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        
        //count the max m
        int i = 0;
        while((b << i) <= a){
            i++;
        }
        if(i == 0)   return 0;
        i--;
        
        int[] bit = new int[i + 1];
        for(int j = i; j >= 0; j--){
            long cur = b << j;
            if(cur <= a){
                bit[j] = 1;
                a -= cur;
            }
        }
        
        int result = 0;
        for(int k = 0; k <= i; k++){
            if(bit[k] == 1)  result += (1 << k);
        }
        
        return (sign < 0) ? -result : result;
    }
}

public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        
        boolean isNines = true;
        for(int i = 0; i < len; i++){
            if(digits[i] != 9){
                isNines = false;
            }
        }
        
        int[] result;
        if(isNines){
            result = new int[len + 1];
            result[0] = 1;
            for(int i = 1; i < len + 1; i++){
                result[i] = 0;
            }
        } else {
            result = new int[len];
            int carry = digits[len - 1] == 9 ? 1 : 0;
            result[len - 1] = digits[len - 1] == 9 ? 0 : digits[len - 1] + 1;
            for(int i = len - 2; i >= 0; i--){
                result[i] = (digits[i] + carry) % 10;
                carry = (digits[i] + carry) / 10;
            }
        }
        return result;
    }
}

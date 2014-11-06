public class Solution {
    public String addBinary(String a, String b) {
        if(b.length() == 0)     return a;
        if(a.length() == 0)     return b;
        
        int carry = 0, i = a.length() - 1, j = b.length() - 1;
        String result = "";
        
        while(i >= 0 || j >= 0 || carry != 0){
            int current = 0;
            if(i >= 0 && j >= 0){
                current = (a.charAt(i) - '0' + b.charAt(j) - '0' + carry) % 2;
                carry = (a.charAt(i) - '0' + b.charAt(j) - '0' + carry) / 2;
                i--;
                j--;
            }else if(i >= 0){
                current = (a.charAt(i) - '0' + carry) % 2;
                carry = (a.charAt(i) - '0' + carry) / 2;    
                i--;
            }else if(j >= 0){
                current = (b.charAt(j) - '0' + carry) % 2;
                carry = (b.charAt(j) - '0' + carry) / 2;
                j--;
            }else{
                current = carry % 2;
                carry = carry / 2;
            }
            result = String.valueOf(current) + result;
        }
        return result;
    }
}

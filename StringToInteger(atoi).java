public class Solution {
    public int atoi(String str) {
        //leading and trailing zeros
        str = str.trim();
        
        //empty string
        if(str.length() == 0)   return 0;
        
        //sign
        boolean pos = true;
        char first = str.charAt(0);
        if(first == '+' || first == '-'){
            if(first == '-')    pos = false;
            str = str.substring(1);
        }
        
        //convert
        int len = str.length();
        boolean isNum = false;
        long sum = 0;
        for(int i = 0; i < len; i++){
            char cur = str.charAt(i);
            if(cur >= '0' && cur <= '9'){
                if(!isNum)  isNum = true;
                sum *= 10;
                sum += cur - '0';
            }else{
                if(!isNum)  return 0;
                else    break;
            }
        }

       
        //sign
        if(!pos)    sum = -sum;
        
        //large or small
        if(sum > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else if(sum < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        
        return (int)sum;
    }
}

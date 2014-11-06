public class Solution {
    public int numDecodings1(String s) {
        if(s.length() == 0) return 0;
        int sum = 0;
        if(isValid(s.substring(0, 1)))  sum += numDecodings(s.substring(1));
        if(s.length() > 1 && isValid(s.substring(0, 2)))  sum += numDecodings(s.substring(2));
        return sum;
    }
    
    public boolean isValid(String s) {
        if(s.charAt(0) == '0')  return false;
        int value = Integer.parseInt(s);
        return value >= 1 && value <= 26;
    }
    
    public int numDecodings(String s) {
        //1226, 1206, 6221
        //if current char is valid, add the one before, if pre+cur is valid, add i - 2
        int len = s.length();
        if(len == 0)    return 0;
        int[] res = new int[len + 1];
        res[0] = 1;
        res[1] = isValid(s.substring(0, 1)) ? 1 : 0;
        for(int i = 1; i < len; i++){
            if(isValid(s.substring(i, i + 1)))  res[i + 1] += res[i];
            if(isValid(s.substring(i - 1, i + 1)))  res[i + 1] += res[i - 1];
        }
        return res[len];
    }
}

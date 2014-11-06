public class Solution {
    public String multiply(String num1, String num2) {
        
        if(num1.equals("0") || num2.equals("0"))  return "0";
        
        int len1 = num1.length(), len2 = num2.length();
        if(len1 == 0)  return num2;
        if(len2 == 0)  return num1;

        int[] res = new int[len1+len2];
        
        for(int i=len1 - 1; i >= 0; i--)  {
            for(int j=len2 - 1; j >= 0; j--)  {
                int n1 = num1.charAt(i) - '0';
                int n2 = num2.charAt(j) - '0';
                int mul = n1 * n2 + res[i+j+1];
                res[i+j+1] = mul % 10;
                res[i+j] += mul / 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        int start = 0;
        while(start < len1 + len2 && res[start]==0)  {
            start++;
        }
        
        for(int i = start; i< len1 + len2; i++)  {
            sb.append(res[i]);
        }
        return sb.toString();
        
    }
}

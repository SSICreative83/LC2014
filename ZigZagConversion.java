public class Solution {
    public String convert(String s, int nRows) {
        int len = s.length();
        if(len <= nRows || nRows == 1)    return s;
        
        StringBuffer sb = new StringBuffer();
        int inc = 2 * nRows - 2;
        
        for(int i = 0; i < nRows; i++){
            
            if(i == 0 || i == nRows - 1){
                
                //add i, i + inc, i + 2 * inc...
                for(int j = i; j < len; j += inc){
                    sb.append(s.charAt(j));
                }
                
                
            }else {
                
                //add i, (i + inc - i), i + inc, (i + 2 * inc - i), i + 2 * inc...
                int index = (-1) * i;
                for(int j = i; j < len; j += inc){
                    sb.append(s.charAt(j));
                    
                    index += inc;
                    if(index < len){
                        sb.append(s.charAt(index));
                    }
                }
                
            }
            
        }
        
        return sb.toString();
        
    }
}

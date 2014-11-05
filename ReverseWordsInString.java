public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        int len = s.length();
        if(len == 0)    return "";
        int start = 0;
        
        char[] array = s.toCharArray();
        reverse(array, 0, len - 1);
        StringBuffer result = new StringBuffer();
        
        for(int i = 0; i < len; i++){
            if(array[i] == ' '){
                reverse(array, start, i - 1);
                
                //add current word to result
                for(int j = start; j < i; j++){
                    result.append(array[j]);
                }
                result.append(' ');
                
                while(i < len - 1 && array[i + 1] == ' ')   i++; 
                start = i + 1;
            }
        }
        
        //last word
        reverse(array, start, len - 1);
        for(int j = start; j < len; j++){
            result.append(array[j]);
        }
        
        return result.toString();
    }
    
    public void reverse(char[] array, int i, int j) {
        while(i < j){
            char tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i++;
            j--;
        }
    }
}

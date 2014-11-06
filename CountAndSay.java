public class Solution {
    
    //http://blog.csdn.net/fightforyourdream/article/details/12901505
    
    public String countAndSay1(int n) {
        if(n == 1){  
            return "1";  
        }  
          
        String s = "1";  
        StringBuffer ret = new StringBuffer();  
        int cnt = 0;  
        int round = 0;          //round is how many times it iterates 
        int i;  
        
        while(++round < n){  
            cnt = 1;  
            ret.setLength(0);  //StringBuffer setLength()
            for(i=1; i<s.length(); i++){  
                if(s.charAt(i) == s.charAt(i-1)){       //repeat, keep counting  
                    cnt++;  
                }else{          //new value, add to result  
                    ret.append(cnt).append(s.charAt(i-1));  
                    cnt = 1;        //reset cnt  
                }  
            }  
            ret.append(cnt).append(s.charAt(i-1));  
            s = ret.toString(); //update s  
        }  
        
        return ret.toString();        
    }
    
    public String countAndSay(int n) {
        if(n == 1)  return "1";
        
        String result = "1";
        
        for(int i = 1; i < n; i++){
            
            String tmp = "";
            int cnt = 1;
            int j = 1;
            
            for(; j < result.length(); j++){
                if(result.charAt(j) == result.charAt(j - 1)){
                    cnt++;
                }else{
                    tmp += (cnt + "");
                    tmp += result.charAt(j - 1); 
                    cnt = 1;
                }
                
            }
            
            tmp += (cnt + "");
            tmp += result.charAt(j - 1);
            result = tmp;
        }
        
        return result;
    }
}

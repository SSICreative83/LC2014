public class Solution {
    public int romanToInt(String s) {
        
        //define a hashtable for Roman chars
        HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
		hash.put('I', 1);
		hash.put('V', 5);
		hash.put('X', 10);
		hash.put('L', 50);
		hash.put('C', 100);
		hash.put('D', 500);
		hash.put('M', 1000);
		
		//remember the process
		int sum = 0; 
		int i = 0;
		int len = s.length();
		
		if(len == 1)    return hash.get(s.charAt(0));
		
		while(i < len - 1){
		    if(hash.get(s.charAt(i)) < hash.get(s.charAt(i + 1))){
		        sum += hash.get(s.charAt(i + 1)) - hash.get(s.charAt(i));
		        i += 2;
		    } else {
		        sum += hash.get(s.charAt(i));
		        i++;
		    }
		}
		
		if(hash.get(s.charAt(len - 2)) >= hash.get(s.charAt(len - 1))){
		    sum += hash.get(s.charAt(len - 1));
		}
		
		return sum;
    }
}

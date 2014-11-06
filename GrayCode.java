public class Solution {
    
    //The thought is important
    
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        
        //if n == 0, should return [0]
        //if(n <= 0)  return result;
        
        for(int i = 0; i < Math.pow(2, n); i++){
            result.add(i ^ (i >> 1));
        }
        return result;
    }
}

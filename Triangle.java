public class Solution {
    
    //The following solution doesn't work
    //[[-1],[2,3],[1,-1,-3]], output: 0, expected: -1
    
    public int minimumTotal1(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0)    return Integer.MIN_VALUE;
        
        int result = triangle.get(0).get(0);
        if(triangle.size() == 1)    return result;
        
        int lastIndex = 0;
        for(int i = 1; i < triangle.size(); i++){
            int curMin = Integer.MIN_VALUE;
            
            if(triangle.get(i).get(lastIndex) > triangle.get(i).get(lastIndex + 1)){
                curMin = triangle.get(i).get(lastIndex + 1);
                lastIndex = lastIndex + 1;
            }else{
                curMin = triangle.get(i).get(lastIndex);
            }
            
            result += curMin;
        }
        return result;
    }
    
    //need to look from bottom up
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int len = triangle.size();
        if(len == 0)    return 0;
        if(len == 1)    return triangle.get(0).get(0);
        
        for(int i = len - 2; i >= 0; i--){
            ArrayList<Integer> current = triangle.get(i);    //this is the O(n) space
            for(int j = 0; j < current.size(); j++){
                int newValue = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)) + current.get(j);
                current.set(j, newValue);
                if(i == 0 && j == 0){
                    return current.get(0);
                }
            }
        }
        
        return 0;
    }
}

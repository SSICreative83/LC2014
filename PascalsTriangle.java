public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>>  result = new ArrayList<>();
        if(numRows < 1) return result;
        
        //add the first level
        ArrayList<Integer> current = new ArrayList<>();
        current.add(1);
        result.add(current);
        
        for(int i = 1; i < numRows; i++){
            current = new ArrayList<Integer>();
            
            //add first 1 in each level
            current.add(1);
            
            for(int j = 1; j < i; j++){
                current.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            
            //add last 1 in each level
            current.add(1);
            result.add(current);
        }
        return result;
    }
}

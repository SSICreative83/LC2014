public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);
        if(rowIndex == 0)   return result;
        result.add(1);
        if(rowIndex == 1)   return result;
        
        for(int i = 2; i <= rowIndex; i++){
             ArrayList<Integer> tmp = new ArrayList(result);
             
            for(int j = 1; j < i; j++){ //j < i
                result.set(j, tmp.get(j - 1) + tmp.get(j));
            }
            
            result.add(1);
        }
        return result;
    }
}

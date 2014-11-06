public class Solution {
    
    //O(n^2) sort first, then left, right
    
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int len = num.length;
        if(len < 3) return result;
        
        //sort the input array
        Arrays.sort(num);
        
        //traversal
        for(int i = 0; i < len - 2;){
            int newTarget = (-1) * num[i];
            for(int j = i + 1, k = len - 1; j < k; ){
                if(num[j] + num[k] == newTarget){
                    //put current triplets into result
                    ArrayList<Integer> current = new ArrayList<>();
                    current.add(num[i]);
                    current.add(num[j]);
                    current.add(num[k]);
                    result.add(current);
                    
                    //need to consider duplicate elements
                    j++;
                    while(j < len && num[j - 1] == num[j] ) j++;
                    k--;
                    while(k > i && num[k + 1] == num[k]) k--;
                } else if(num[j] + num[k] < newTarget){
                    j++;
                } else {
                    k--;
                }
            }
            
            i++;
            while(i < len - 2 && num[i - 1] == num[i]) i++;
            
        }
        
        return result;
    }
}

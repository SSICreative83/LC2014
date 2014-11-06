public class Solution {
    
    //O(n^3): sort, then left,right
    //there is faster solution using HashMap, and Multi-map?
    
    class Pair {
        int first;      // The first index
        int second;     // The second index
 
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int n = num.length;
        if(n < 4) return result;  
        
        Arrays.sort(num);
        
        //cache sum of two numbers
       HashMap<Integer, ArrayList<Pair>> hashMap = new HashMap<Integer, ArrayList<Pair>>();
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (hashMap.containsKey(num[i]+num[j]))     // Existing sum (key)
                    hashMap.get(num[i]+num[j]).add(new Pair(i, j));
                else {              // new sum (key)
                    ArrayList<Pair> pairs = new ArrayList<Pair>();
                    pairs.add(new Pair(i, j));
                    hashMap.put(num[i]+num[j], pairs);
                }
            }
        }
        
        // For each unique pair (num[i],num[j]) as the first two numbers in a quadruple,
        // search the map with target-num[i]-num[j] and get the remaining two numbers without duplicates
        for (int i = 0; i < n-3; i++) {
            
            if (i > 0 && num[i] == num[i-1])
                // All quadruples starting with num[i] have included before
                continue;
                
            for (int j = i+1; j < n-2; j++) {
                if (j > i+1 && num[j] == num[j-1])
                    // All quadruples starting with (num[i],num[j]) have included before
                    continue;
                    
                int wanted = target - num[i] - num[j];
                if (hashMap.containsKey(wanted)) {  // There is at least a pair whose sum is wanted
                    for (Pair pair : hashMap.get(wanted)) {
                        if (pair.first <= j)    // The third number has to be after the second one in the array
                            continue;
                        if (result.isEmpty() || result.get(result.size()-1).get(0) != num[i] ||
                                result.get(result.size()-1).get(1) != num[j] ||
                                result.get(result.size()-1).get(2) != num[pair.first]) {    // no duplicate
                            ArrayList<Integer> quadruple = new ArrayList<Integer>(4);
                            quadruple.add(num[i]);
                            quadruple.add(num[j]);
                            quadruple.add(num[pair.first]);
                            quadruple.add(num[pair.second]);
                            result.add(quadruple);
                        }
                    }
                }
            }
        }
 
        return result;
        
    }
    
    public ArrayList<ArrayList<Integer>> fourSum1(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int len = num.length;
        if(len < 4) return result;
        
        Arrays.sort(num);
        for(int i = 0; i < len - 3; i = increment(num, i)){
            for(int j = i + 1; j < len - 2; j = increment(num, j)){
                for(int k = j + 1, h = len - 1; k < h; ){
                    if(num[i] + num[j] + num[k] + num[h] == target){
                        
                        //put current into result
                        ArrayList<Integer> current = new ArrayList<>();
                        current.add(num[i]);
                        current.add(num[j]);
                        current.add(num[k]);
                        current.add(num[h]);
                        result.add(current);
                        
                        //change index
                        k = increment(num, k);
                        h = decrement(num, h);
                        
                    } else if(num[k] + num[h] < target - num[i] - num[j]){
                        k = increment(num, k);
                    } else {
                        h = decrement(num, h);
                    }
                }
            }
        }
        return result;
    }
    
    public int increment(int[] num, int i){
        i++;
        while(i < num.length && num[i] == num[i - 1])   i++;    //allow i++ out of bound, it will be checked
        return i;
    }
    
    public int decrement(int[] num, int i){
        i--;
        while(i >= 0 && num[i] == num[i + 1])   i--;
        return i;
    }
}

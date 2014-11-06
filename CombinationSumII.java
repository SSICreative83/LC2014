public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(num.length == 0) return result;
        
        Arrays.sort(num);
        ArrayList<Integer> tmp = new ArrayList<>();
        dfs(num, 0, num.length - 1, target, tmp, result);
        return result;
    }
    
    public void dfs(int[] num, int start, int end, int target, ArrayList<Integer> tmp, ArrayList<ArrayList<Integer>> result) {
        if(start > end) return;
        int currentSum = 0;
        
        //get current sum
        for(int i = 0; i < tmp.size(); i++) {
            currentSum += tmp.get(i);
        }
        if(currentSum > target) return;
        
        for(int i = start; i <= end; i = increment(num, i, end)) {
            if(currentSum + num[i] > target)    return;
            if(currentSum + num[i] == target) {
                tmp.add(num[i]);
                result.add(tmp);
                return;
            }
            ArrayList<Integer> ntmp = new ArrayList<>(tmp);
            ntmp.add(num[i]);
            dfs(num, i + 1, end, target, ntmp, result);
        }
    }
    
    public int increment(int[] num, int i, int end) {
        i++;
        while(i <= end && num[i - 1] == num[i]) i++;
        return i;
    }
}

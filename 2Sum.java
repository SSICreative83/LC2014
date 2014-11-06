public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        if(len == 0)    return new int[]{-1, -1};
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            if(map.containsKey(numbers[i])){
                return new int[]{map.get(numbers[i]) + 1, i + 1};
            }else{
                map.put(target - numbers[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}

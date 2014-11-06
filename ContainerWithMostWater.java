public class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        if(len < 2) return 0;
        
        int result = 0;
        int start = 0, end = len - 1;
        
        while(start < end){
            int newResult = Math.min(height[start], height[end]) * (end - start);
            result = Math.max(result, newResult);
            
            if(height[start] <= height[end]){
                start++;
            }else
                end--;
        }
        return result;
    }
}

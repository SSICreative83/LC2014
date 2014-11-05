public class Solution {
    public int findMin(int[] num) {
        if(num.length == 0) {
            return Integer.MIN_VALUE;
        }
        
        int start = 0, end = num.length - 1; 
        while(start + 1 < end && num[start] > num[end]) {
            int mid = start + (end - start) / 2;
            if(num[start] > num[mid]) { //right is in order, target is in left
                end = mid;
            } else {    //left is in order, target is in right
                start = mid;
            }
            
        }
        
        return num[start] < num[end] ? num[start] : num[end];
    }
}

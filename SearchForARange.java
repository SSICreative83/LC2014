public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] res = {-1, -1};
        int len = A.length;
        if(len == 0)    return res;
        
        res = searchRangeHelper(A, 0, len - 1, target);
        return res;
    }
    
    public int[] searchRangeHelper(int[] A, int start, int end, int target){
       
        int[] res = {-1, -1};
        if(start > end) return res;
        
        if(start == end){
            if(A[start] == target){
                return new int[]{start, start};
            }else{
                return res;
            }
        }
        
        int mid = (start + end) / 2;
        if(A[mid] < target){
            res = searchRangeHelper(A, mid + 1, end, target);
        }else if(A[mid] > target){
            res = searchRangeHelper(A, start, mid, target);
        }else{
            res[0] = searchRangeHelper(A, start, mid, target)[0];
            res[1] = Math.max(searchRangeHelper(A, mid + 1, end, target)[1], mid);
        }
        return res;
    }
}

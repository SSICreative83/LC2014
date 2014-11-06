public class Solution {
    public int search(int[] A, int target) {
        int len = A.length;
        if(len == 0)    return -1;
        
        return bSearch(A, target, 0, len - 1);
    }
    
    public int bSearch(int[] A, int target, int start, int end){
        if(start == end){
            if(A[start] == target)  return start;
            else return -1;
        }
        else if(start < end){
            int mid = (start + end) / 2;    //left side mid
            if(A[mid] == target)    
                return mid;
            else{
                if(A[start] <= A[mid]) {   //left is in-order
                    
                    if(A[start] <= target && A[mid] > target)
                        return bSearch(A, target, start, mid - 1);
                    
                    return bSearch(A, target, mid + 1, end);    //search right
                
                }else{  //right is inorder
                    
                    if(A[mid] < target && A[end] >= target)
                        return bSearch(A, target, mid + 1, end);
                    
                    return bSearch(A, target, start, mid - 1);
                }
            }    
        }
        return -1;
    }
}

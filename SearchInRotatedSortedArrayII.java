public class Solution {
    
    //http://blog.csdn.net/u010500263/article/details/18471861
    //This is a better demo of difference of I and II
    
    //The difference is [1 3 1 1 1], target = 3 (mid is duplicate of start, target value can be in the upper half of the array or the bottom part of the array)
    //but my implementation will compare value one by one, so avoided this problem
    
    public boolean search(int[] A, int target) {
        int len = A.length;
        if(len == 0)    return false;
        
        return bSearch(A, target, 0, len - 1);
    }
    
    public boolean bSearch(int[] A, int target, int start, int end){
        if(start == end){
            if(A[start] == target)  return true;
            else return false;
        }
        else if(start < end){
            int mid = (start + end) / 2;    //left side mid
            if(A[mid] == target)    
                return true;
            else{
                if(A[start] == A[mid]){ //left is duplicate of mid
                    start++;
                    return bSearch(A, target, start, end);
                }
                else if(A[start] < A[mid]) {   //left is in-order
                
                    if(A[start] <= target && A[mid] > target)   //in left part, search left
                        return bSearch(A, target, start, mid - 1);
                    
                    return bSearch(A, target, mid + 1, end);    //search right
                
                }else{  //right is inorder
                    
                    if(A[mid] < target && A[end] >= target)
                        return bSearch(A, target, mid + 1, end);
                    
                    return bSearch(A, target, start, mid - 1);
                }
            }    
        }
        return false;
    }
}

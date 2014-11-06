public class Solution {
    
    //Greedy I
    
    public int jump1(int[] A) {
        if(A == null || A.length <= 1)
            return 0;
    
        int lastReached = 0;
        int maxReached = 0;
        int step = 0;
    
        for(int i = 0;i <= maxReached && i < A.length; i++)
        {
            if(i > lastReached)
            {
                step++;             //key: update step
                lastReached = maxReached;  //key: update lastReach
                //how to gurantee one more step can go to reach from lastReach?
                //because current i has not visited, so there must be one number < i (which index is smaller or equal to lastReach), whose value make lastReach (or smaller index) to reach, like 3 here
            }
            maxReached = Math.max(maxReached, A[i] + i);
        }
    
        if(maxReached < A.length-1)
            return 0;
        return step;
    }
    
    //Greedy II
    
    public int jump(int[] A){   
        if(A == null || A.length <= 1)  return 0;
        
        int maxReached = 0, next = 0, step = 0;
        
        for(int i = 0; i < A.length - 1; i++){   //condition: 
            maxReached = Math.max(maxReached, A[i] + i);    //find current max
            
            if(i == next){  //need to jump
                if(next == maxReached)  return -1;  //jump at current location
                next = maxReached;
                step++;
            }
        }
        return step;
    }
}

public class Solution {
    
    //time limit exceeded
    
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int len = gas.length;
        if(len == 0)    return -1;
        if(len == 1)    return gas[0] >= cost[0] ? 0 : -1;
        
        //start from each station
        for(int i = 0; i < len; i++){
            int willRemain = 0;
            
            //at each other station, j starts at i
            for(int j = i; j < len + i; j++){
                int index = j % len;
                 
                willRemain += gas[index] - cost[index];
                
                if(willRemain < 0)  break;
                    
                if(i == 0){
                    if(index == len - 1)    return i;
                }else{
                    if(index == i - 1)  return i;
                }
            }
        }
        
        return -1;
    }
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
                if (gas==null|| cost==null||gas.length==0||cost.length==0||gas.length!=cost.length){
            return -1;
        }
        
        int sum=0;
        
        int start=0;
        
        int total=0;
        
        for (int i=0; i<gas.length; i++){
            sum+=gas[i]-cost[i];
            total+=sum;
            if (sum<0){
                start=i+1;
                sum=0;
            }
            
        }
        
        if (total<0){
            return -1;
        }
        
        return start;
        
        
        
    }
}

public class Solution {
    public String getPermutation(int n, int k) {
        
        //http://blog.csdn.net/u013027996/article/details/18405735
        
        ArrayList<Integer> numList = new ArrayList<>();
        numList.add(1);
        int sum = 1;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 2; i <= n; i++){
            numList.add(i);
            sum *= i;
        }
        
        sum = sum / n;
        k--;
        
        for(int i = 0; i < n; i++){
            int curNumPos = k / sum;
            int cur = numList.get(curNumPos);
            numList.remove(curNumPos);
            sb.append(cur);
            
            if(i == n - 1)  break;
            k = k % sum;
            sum = sum / (n - i - 1);
        }
        
        return sb.toString();
        
    }
}

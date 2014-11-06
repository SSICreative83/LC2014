public class Solution {
    public int numTrees(int n) {
        if(n < 2)  return n;
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            int left = i - 1;
            int right = n - i;
            
            if(left == 0) sum += numTrees(right);
            else if(right == 0) sum += numTrees(left);
            else sum += numTrees(left) * numTrees(right);
        }
        return sum;
    }
}

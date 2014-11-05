public class Solution {
    public int maxProduct1(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        int maxherepre = A[0];
        int minherepre = A[0];
        int maxsofar = A[0];
        int maxhere, minhere;

        for (int i = 1; i < A.length; i++) {
            maxhere = Math.max(Math.max(maxherepre * A[i], minherepre * A[i]), A[i]);
            minhere = Math.min(Math.min(maxherepre * A[i], minherepre * A[i]), A[i]);
            maxsofar = Math.max(maxhere, maxsofar);
            maxherepre = maxhere;
            minherepre = minhere;
        }
        return maxsofar;
    }
    
    public int maxProduct(int[] A) {
        int maxProd = Integer.MIN_VALUE;
        int prod = 1;
        for(int i = 0; i < A.length; i++) {
            prod = prod * A[i];
            maxProd = Math.max(maxProd, prod);
            if (A[i] == 0)
                prod = 1;
        }
        
        prod = 1;
        for(int i = A.length - 1; i >= 0; i--) {
            prod = prod * A[i];
            maxProd = Math.max(maxProd, prod);
            if (A[i] == 0)
                prod = 1;
        }
        
        return maxProd;            
    }
}

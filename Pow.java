public class Solution {
    public double pow(double x, int n) {
        if(x == 0)    return 0;
        if(n == 0)  return 1;
        double px = (x < 0) ? -x : x;
        int pn = (n < 0) ? -n : n;
        int exp = 1;
        double res = px;
        int pn2 = pn;
        
        while(pn2 / 2 > 0){
            exp = exp * 2;
            res = res * res;
            pn2 = pn2 / 2;
        }
        
        double ret = res * pow(px, pn - exp);
        
        if(x < 0 && n % 2 != 0) ret = -ret;
        if(n < 0)   ret = 1 / ret;
        return ret;
    }   
}

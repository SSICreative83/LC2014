public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(S == null || S.length == 0) {
            return res;
        }
        
        Arrays.sort(S);
        res.add(new ArrayList<Integer>());
        
        for(int i = 0; i < S.length; i++) {
            List<List<Integer>> tmpRes = new ArrayList<>(res);
            for(List<Integer> sub : res) {
                List<Integer> tmp = new ArrayList<>(sub);
                tmp.add(S[i]);
                tmpRes.add(tmp);
            }
            res = tmpRes;
        }
        
        return res;
    }
}

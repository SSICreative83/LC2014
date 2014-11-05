public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        int length = s.length();
        
        //create the word ending character's index list for each character
        ArrayList<ArrayList<Integer>> record = new ArrayList<ArrayList<Integer>>(length);
        for(int i = 0;i<length;i++)
            record.add(new ArrayList<Integer>());
 
        //each character can be the ending character of some word
        for(int end=length;end>=0;end--){
 
            if(end < length && record.get(end).isEmpty())
                continue;
            
            //find the starting character for the current ending character
            for(int runner = end-1;runner >= 0;runner--){
                if(dict.contains(s.substring(runner,end)))
                    record.get(runner).add(end);    //add current end to start character's list
            }
        }
        
        ArrayList<String> solutionSet = new ArrayList<String>();
        buildSolution(record,0,s,"",solutionSet);
        
        return solutionSet;        
    }
    
    public void buildSolution(ArrayList<ArrayList<Integer>> record, int current, String s, 
                String solution, ArrayList<String> solutionSet){
        
        //iterate on current character's word ending list
        for(Integer end : record.get(current)){
 
            String sub=s.substring(current,end);
            /*
                since the loop may have many iterations, we should keep the reference
                of "solution", rather than writing as "solution += ..."
            */
            String newSolution = solution+(current==0 ? sub : " "+sub);
            
            if(end == s.length()) 
                solutionSet.add(newSolution);
            else 
                buildSolution(record,end,s,newSolution,solutionSet);
        }
    }
}

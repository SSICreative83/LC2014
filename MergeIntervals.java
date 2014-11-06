/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        int len = intervals.size();
        if(len < 2) return intervals;
        
        Collections.sort(intervals, new IntervalComparator());
        Interval pre = intervals.get(0);
        
        for(int i = 1; i < len; i++){
            Interval cur = intervals.get(i);
            if(pre.end >= cur.start){
                pre = new Interval(pre.start, Math.max(pre.end, cur.end));
            }else{
                result.add(pre);
                pre = cur;
            }
        }
        result.add(pre);
        return result;
    }
    
    class IntervalComparator implements Comparator<Interval>{
        public int compare(Interval i1, Interval i2){
            if(i1.start < i2.start) return -1;
            else if(i1.start == i2.start) return 0;
            else return 1;
        }
    }
    

}

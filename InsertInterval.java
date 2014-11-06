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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        int len = intervals.size();
        if(len == 0){
            result.add(newInterval);
            return result;
        }
        int low = newInterval.start;
        int high = newInterval.end;
        
        for(int i = 0; i < len; i++){
            Interval cur = intervals.get(i);
            if(cur.end < newInterval.start){
                result.add(cur);
            }else if(cur.start > newInterval.end){
                result.add(new Interval(low, high));
                low = cur.start;
                high = cur.end;
            }
            else{
                low = Math.min(cur.start, low);
                high = Math.max(cur.end, high);
            }
        }
        
        result.add(new Interval(low, high));
        return result;
    }
}

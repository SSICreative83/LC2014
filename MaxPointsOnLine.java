/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        int len = points.length;
        if(len == 0)    return 0;
        
        HashMap<Double, Integer> map = new HashMap<>();
        int res = 0;
        
        for(int i = 0; i < len; i++){
            map.clear();
            int num = 1;
            for(int j = 0; j < len; j++){
                if(i == j)  continue;
                double k;
                
                if(points[i].x == points[j].x && points[i].y == points[j].y)    num++;
                else{
                    if(points[i].x == points[j].x)  k = Double.MAX_VALUE;
                    k = ((double)points[i].y - (double)points[j].y) / ((double)points[i].x - (double)points[j].x);
                
                    if(map.containsKey(k)){
                        map.put(k, map.get(k) + 1);
                     }else{
                         map.put(k, 1);
                    }
                }
            }
            
            int tmp = 0;
            for(int value : map.values()){
                tmp = Math.max(tmp, value);
            }
            res = Math.max(tmp + num, res);
        }

        return res;
    }
}

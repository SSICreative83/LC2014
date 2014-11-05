public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if(dict.isEmpty())  return 0;
        return bfs(start, end, dict);
    }
    
    public int bfs(String start, String end, Set<String> dict){
        Queue<String> queue = new LinkedList<>();
        Queue<Integer> len = new LinkedList<>();
        int length = start.length();
        queue.offer(start);
        len.offer(1);
        
        while(!queue.isEmpty()){
            String word = queue.poll();
            int curlen = len.poll();
            
            if(word.equals(end))    return curlen;
            
            for(int i = 0; i < length; i++){
                char[] array = word.toCharArray();
                
                for(char c = 'a'; c <= 'z'; c++){
                    if(c == array[i])   continue;
                    array[i] = c;
                    String str = new String(array);
                    if(dict.contains(str)){
                        queue.offer(str);
                        len.offer(curlen + 1);
                        dict.remove(str);
                    }
                }
            }
        }
        
        return 0;
    }
}

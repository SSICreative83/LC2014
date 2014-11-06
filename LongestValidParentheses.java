public class Solution {
    
    //use stack, DP, this is difficult to think up, need to rewrite by self
    
    public int longestValidParentheses1(String s) {
        int len = s.length();
        if(len == 0) return 0;
        
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i = 0; i < len; i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                if(!stack.isEmpty() && s.charAt(stack.peek()) == '('){
                    stack.pop();
                    //the following statement is key. why i + 1?
                    max = Math.max(max, stack.isEmpty() ? i + 1 : i - stack.peek());
                }else{
                    stack.push(i);
                }
            }
        }
        
        return max;
    }
    
    public int longestValidParentheses(String s) {
        int len = s.length();
        if(len == 0) return 0;
        
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        
        for(int i = 0; i < len; i++){
            char cur = s.charAt(i);
            if(cur == '('){
                stack.push(i);
            }else{
                if(!stack.empty() && s.charAt(stack.peek()) == '('){
                    stack.pop();
                    if(stack.empty()){
                        max = Math.max(max, i + 1); //"()()"
                    }else{
                        max = Math.max(max, i - stack.peek());  //"(()()"
                    }
                }else{
                    stack.push(i);
                }
            }
        }
        return max;
    }
}

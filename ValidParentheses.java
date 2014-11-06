public class Solution {
    public boolean isValid(String s) {
        
        //use stack
        int len = s.length();
        if(len == 0)    return true;
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            else if(!stack.isEmpty()){
                char open = stack.peek();
                if(c == ')'){
                    if(open != '(') return false;
                    else    stack.pop();
                }    
                else if(c == ']'){
                    if(open != '[') return false;
                    else    stack.pop();
                }    
                else if(c == '}'){
                    if(open != '{') return false;
                    else    stack.pop();
                }    
            }else   return false;
        }
        return stack.isEmpty();
    }
}

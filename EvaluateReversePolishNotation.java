public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0)    return 0;
        int len = tokens.length;
        Stack<String> stack = new Stack<>();
        String op = "+-*/";
        
        for(int i = 0; i < len; i++){
            String cur = tokens[i];
            if(op.indexOf(cur) != -1){
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if(cur.equals("+"))  res = num1 + num2;
                else if(cur.equals("-")) res = num1 - num2;
                else if(cur.equals("*")) res = num1 * num2;
                else if(cur.equals("/")) res = num1 / num2;
                
                stack.push(String.valueOf(res));//Integer.toString(intnum)
                
            }else{
                stack.push(cur);
            }
        }
        if(!stack.isEmpty())
            return Integer.parseInt(stack.pop());
        else
            return 0;
    }
}

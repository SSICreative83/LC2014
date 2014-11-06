public class Solution {
    public String simplifyPath(String path) {
        
        if(path.length() == 0)  return "/";
        
        Stack<String> stack = new Stack<>();
        String[] array = path.trim().split("/");    //split(",") method
        
        for(String s : array){
            if(s.equals(".") || s.length() == 0 ){}
            else if(s.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            }else{
                stack.push(s);
            }
        }
        
        if(stack.isEmpty()) return "/";
        
        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());    //insert(index, value) method
            sb.insert(0, "/");
        }
        
        return sb.toString();
    }
}

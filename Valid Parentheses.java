class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<Character>(); 
        
        for(int i=0;i<s.length();i++){
            if(stack.empty()==false){
                if(((s.charAt(i)==')' && stack.peek()=='(') ) || (s.charAt(i)=='}' && stack.peek()=='{' ) || (s.charAt(i)==']' && stack.peek()=='[' )){
                    stack.pop();
                }else{
                    stack.push(s.charAt(i));
                }
                
            }else{
                stack.push(s.charAt(i));
            }
            
        }
        
        if(stack.empty()==true){
            return true;
        }
        return false;
        
    }
}
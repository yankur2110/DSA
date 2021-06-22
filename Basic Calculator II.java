class Solution {
    public int calculate(String s) {
    /*
        Basically we want the efficient approach such that we traverse the String only once.
        Here note that multiplication and divison has the same precedence.
    */
        int num =0; //storing the num before the current operator.
        char prevSign = '+';
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char currChar = s.charAt(i);
            
            if(Character.isDigit(currChar)){
                num=num*10+Character.getNumericValue(currChar);
            }
            if( (!Character.isDigit(s.charAt(i)) && currChar!=' ' )|| i==s.length()-1){
            
                if(prevSign=='+')
                    stack.push(num);
                if(prevSign=='-')
                    stack.push(-1*num);
                if(prevSign=='*')
                    stack.push(stack.pop()*num);
                if(prevSign=='/')
                    stack.push(stack.pop()/num);
                
                num=0;
                prevSign=currChar;
                    
            }
        }
        
        int result =0;
        for(int i: stack){
            result+=i;
        }
        
        return result;
    }
}

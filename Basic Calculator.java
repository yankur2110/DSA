class Solution {

    //every time you will have a result (0 when we encounter the symbol for the first time), a sign and a number that you've just evaluated on LHS when you find a symbol.
    //for parenthesis case: whenever opening parenthesis is encountered, we will have a result in the top (2nd element though) of stack to which the opening parenthesis evalution (till the corresponding closing parenthesis) * sign (present on top of stack) has to be operated.

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int sign=1, result=0, number=0;

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                number=number*10+ch-'0';
            }else if (ch=='+'){
                result+= sign*number;
                sign=1;
                number=0;

            }else if (ch=='-'){
                result+= sign*number;
                sign=-1;
                number=0;

            }else if (ch=='('){
                stack.push(result);
                stack.push(sign);
                result=0;
                sign=1;
            }else if (ch==')'){
                result+= sign*number;
                result*=stack.pop();
                result+=stack.pop();
                number=0;
                System.out.println("result is "+result);

            }

        }
        if(number!=0){
            return result+=sign*number;
        }
        return result;
    }
}

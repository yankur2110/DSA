class Solution {
    public String removeKdigits(String num, int k) {
        if(k==num.length()) return "0";

        Stack<Character> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();

        int i=0;
        while(i<num.length()){

            //if any peak is found from the left side, keep on popping the stack top element till the time it's a peak when compared with current character i.e., character at i.
            while(!stack.isEmpty() && k>0 && stack.peek()>num.charAt(i)){
                k--;
                stack.pop();
            }

            //if it's not monotonously increasing/equal, simply push to stack.
            stack.push(num.charAt(i++));
        }

        //for monotonous increasing number or equal number like 1234 or 1111.
        while(k-->0){
            stack.pop();
        }

        //form the final string from the stack elements.
        while(!stack.isEmpty())
            stringBuilder.append(stack.pop());
        stringBuilder.reverse(); //reverse the string to get the actual number.

        //remove all starting 0's.
        while(stringBuilder.length()>1 && stringBuilder.charAt(0)=='0')
            stringBuilder.deleteCharAt(0);

        return stringBuilder.toString(); //convert stringBuilder to string and return.

    }
}

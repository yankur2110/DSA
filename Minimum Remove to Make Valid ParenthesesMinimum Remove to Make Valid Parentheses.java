class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < sb.length(); ++i) {
         if (sb.charAt(i) == '(') st.add(i); //if it's a '(', add to stack.
            if (sb.charAt(i) == ')') { //if it's a ')'.. then check
                if (!st.empty()) st.pop();  //if stack contains '(', just cancel them.
                else
                    sb.setCharAt(i, '*'); //otherwise it's a redundant one, so update with '*'
            }
        }

         while (!st.empty())
            sb.setCharAt(st.pop(), '*'); //redundant '('.. replace with '*'.

        return sb.toString().replaceAll("\\*", "");
    }
}

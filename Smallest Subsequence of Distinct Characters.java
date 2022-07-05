class Solution {
    public String smallestSubsequence(String S) {
        //this stack will store the distinct characters in order.
        Stack<Integer> stack = new Stack<>();

        //'last' stores the last index of a character in string.
        //'seen' is a check that represents if we have added the character in stack or not.
        int[] last = new int[26], seen = new int[26];

        //populate the last array.
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;

        //now the core part:
        for (int i = 0; i < S.length(); ++i) {

            //current character.
            int c = S.charAt(i) - 'a';

            //if we have already included the current character into the stack, just skip it.
            //if we haven't included the element, we have to include it anyhow. Also we are marking it as 'seen'.. by updating the value by 1 at that index.
            if (seen[c]++ > 0) continue;

            //if the incoming character is smaller && we are sure that the peek() element will occur in future as well.. then we will just pop that element and make the seen 0 for that element.
            while (!stack.isEmpty() && stack.peek() > c && i < last[stack.peek()])
                seen[stack.pop()] = 0;

            //since it was a new character, we have to include it.
            stack.push(c);
        }

        //now our stack contains the desired result, append each into the string.
        //note we are just traversing the stack.. not popping, so the elements are in fifo style.
        StringBuilder sb = new StringBuilder();
        for (int i : stack) sb.append((char)('a' + i));

        //return the string.
        return sb.toString();
    }
}

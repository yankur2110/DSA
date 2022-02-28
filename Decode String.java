public class Solution {
    public String decodeString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>(); //stack to keep track of numbers.
        Stack<String> resStack = new Stack<>(); //resultant decoded String.
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) { //if a digit is found, keep on iterating till the time consecutive numbers are there, convert into number and push into countStack.
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            }
            else if (s.charAt(idx) == '[') { //once '[' is found, push the continuous string, we have formed till now.
                resStack.push(res);
                res = "";
                idx++;
            }
            else if (s.charAt(idx) == ']') { //if ']' then we will need to append the current consectuive string formed till now, (countStack.pop()) number of times to the string present before '[' i.e., resStack.pop() string.
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
            else { //if it's a character keep adding to resultString.
                res += s.charAt(idx++);
            }
        }
        return res;
    }
}

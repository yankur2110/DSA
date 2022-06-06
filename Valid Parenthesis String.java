class Solution {
    public boolean checkValidString(String s) {

        //min and max represents the range of opening braces we can have at any point of time (i.e., depending on the substring we have traversed).
        int minOpenBraces = 0, maxOpenBraces = 0;

        for(int i=0; i<s.length(); i++){

            char ch = s.charAt(i);

            if(ch=='('){ //you have to increment both below.
                minOpenBraces++;
                maxOpenBraces++;
            }else if (ch == ')'){ //you have to decrement both below.
                minOpenBraces--;
                maxOpenBraces--;
            }else{ //this piece here, is doing the decision tree calculation.
                minOpenBraces--;
                maxOpenBraces++;
            }

            if(maxOpenBraces<0) return false; //if max<0, it means we won't be able to recover i.e., ')' has come before the '(' or '*'.
            if(minOpenBraces<0) minOpenBraces=0; //if minOpenBraces<0, it means we have taken a '*' unnecessary as ')'. Because it minOpenBraces<0 because of actual ')', then it would have already been caught in above condition.

        }

        return minOpenBraces==0;

    }
}

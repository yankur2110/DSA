class Solution {
    public int countHomogenous(String s) {
        int result=0, count=0;
        int mod = (int)1e9+7;

        char prevChar='0';

        for(int i=0;i<s.length();i++){
            char currChar = s.charAt(i);
            count= (currChar==prevChar)?count+1:1;
            prevChar=currChar;

            result = (result+count)%mod;
        }

        return result;

    }
}

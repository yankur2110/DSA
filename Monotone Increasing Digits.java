class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] charArray = String.valueOf(n).toCharArray();
        int len = charArray.length;

        int startOf9 = len;
        for(int i=len-1;i>0;i--){
            if(charArray[i]<charArray[i-1]){
                startOf9=i;
                charArray[i-1]--;
            }
        }

        for(int i=startOf9;i<len;i++){
            charArray[i]='9';
        }

        return Integer.parseInt(new String(charArray));
    }
}

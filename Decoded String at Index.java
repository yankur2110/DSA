class Solution {
    public String decodeAtIndex(String s, int k) {
        long len=0;

        //find the length of string.
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                len*=(ch-'0');
            }else{
                len++;
            }
        }

        //core logic impl.
        for(int i=s.length()-1;i>=0;i--){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){ //if it's a digit it means length would be shortened.
                len/=(ch-'0');
                k%=len; //since the whole length is shortened and we are still calculating the K'th index. It is incorrect, we need to shorten the kth index as well. K would be same as of K%len now.
            }else{
                if(k==0 || len==k) //if it's the last index element... K==0 means first index only.. This would be true when we have performed k%len atleast once... Since 1-indexed.
                    return ch+"";
                len--;
            }
        }

        return "";
    }
}

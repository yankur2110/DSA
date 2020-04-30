class Solution {
    public String longestPalindrome(String s) {
        
        if(s == null || s.length()<1)
            return "";
        
        int start = 0;
        int end = 0;
        
        for (int i=0 ;i<s.length()-1; i++){
            int len1=expandFromMiddle(s,i,i);
            int len2=expandFromMiddle(s,i,i+1);
            int len=Math.max(len1,len2);
        
        if( len > (end-start+1) ){
            start=i-((len-1)/2);
            end=i+(len/2);
         }
        }
        
        return s.substring(start,end+1);
        
    }
    
    public int expandFromMiddle(String s, int left, int right){
        
        while(left>=0 && left<=right && right <s.length() &&  s.charAt(left)==s.charAt(right)  ){
            left--;
            right++;
        }
        
        return (right-1)-(left+1)+1; /*because both left_pointer is shifted left by 1 and right_pointer is shifted right by 1. To get actual palindrome we added 1 to left and subtracted 1 to right*/
    }
}
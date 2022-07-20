class Solution {
    public boolean validPalindrome(String s) {
        int start=0, end=s.length()-1;
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                break;
            }
            start++;end--;
        }

        if(start>end) return true;
        String s1 = s.substring(0,start)+s.substring(start+1);
        String s2 = s.substring(0,end)+s.substring(end+1);

        return isPalindrome(s1)||isPalindrome(s2);
    }


    public boolean isPalindrome(String s){
        int start=0, end=s.length()-1;
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--))
                return false;
        }

        return true;
    }
}

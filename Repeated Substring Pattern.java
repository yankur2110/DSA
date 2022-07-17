class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();

        for(int i=len/2;i>=1;i--){
            if(len%i==0){ //if it is possible to divide the string into len%i parts then only proceed.
                int times = len/i; //if it's a +ve case, then it has to be repeated len%i times.
                String subStr = s.substring(0,i);
                StringBuilder sb = new StringBuilder();

                //add str 'times' times.
                for(int j=0;j<times;j++) {
                    sb.append(subStr);
                }

                //check if string is formed.
                if(sb.toString().equals(s))
                    return true;
            }

        }
        return false;
    }
}

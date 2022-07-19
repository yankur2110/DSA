class Solution {
    public int[] shortestToChar(String s, char c) {
        int[] nearestCfromLeft = new int[s.length()];
        int[] nearestCfromRight = new int[s.length()];
        int left=Integer.MAX_VALUE;
        int right=Integer.MAX_VALUE;
        int[] resultArray = new int[s.length()];

        for(int i=0;i<s.length();i++){
            int rightIndex=s.length()-i-1;

            if(s.charAt(i)==c){
                nearestCfromLeft[i]=0;
                left=0;
            }else{
                nearestCfromLeft[i] = (left==Integer.MAX_VALUE) ? Integer.MAX_VALUE : ++left;
            }

            if(s.charAt(rightIndex)==c){
                nearestCfromRight[rightIndex]=0;
                right=0;
            }else{
                nearestCfromRight[rightIndex] = (right==Integer.MAX_VALUE)?Integer.MAX_VALUE: ++right;
            }

        }


        for(int i=0;i<s.length();i++){
            resultArray[i] = Math.min(nearestCfromLeft[i], nearestCfromRight[i]);
        }
        return resultArray;
    }
}

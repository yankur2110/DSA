class Solution {
    public String getSmallestString(int n, int sum) {
        char[] charArray = new char[n];
        Arrays.fill(charArray,'a');
        sum-=n;

        for(int i=n-1;i>=0;i--){
            if(sum>0){
                charArray[i]+=Math.min(sum,25);
                sum-=Math.min(sum,25);
            }else{
                break;
            }
        }

        return String.valueOf(charArray);
    }
}

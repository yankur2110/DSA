class Solution {
    public long[] sumOfThree(long num) {
        long[] result;
        if(num%3!=0){
            result = new long[0];
        }else{
            result = new long[3];
            long mid=num/3;
            result[0]=mid-1;
            result[1]=mid;
            result[2]=mid+1;
        }
        return result;
    }
}

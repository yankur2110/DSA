class Solution {
    public boolean isPerfectSquare(int num) {
        int start=1, end=num;

        while(start<=end){
            long mid = (start + end)/2;
            long product = mid*mid;
            if(product==num) return true;

            if(num<product){
                end=(int)mid-1;
            }else{
                start=(int)mid+1;
            }
        }

        return false;
    }
}

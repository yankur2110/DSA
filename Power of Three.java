class Solution {
    public boolean isPowerOfThree(int n) {
        int max3 = 1162261467;
        if(n<=0) return false;
        return max3%n==0;
    }
}

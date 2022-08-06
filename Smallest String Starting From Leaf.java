class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n1=nums1.length, n2=nums2.length;
        int[][] dp = new int[n1+1][n2+1]; //length of common subarray ending at nums1[i], nums2[j].

        int max=0;
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1; //maximum common subarray length before current numbers from nums1 and num2.
                    max=Math.max(max, dp[i][j]);
                }
            }
        }

        return max;
    }
}

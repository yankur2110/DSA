class Solution {
    int[][] dp; //dp for memoization.

    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        dp = new int[n][n];

        //initialize the dp array with -1 value.
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        int maxFirstPlayerScore = findMaxScore(nums, 0, nums.length-1); //find max score possible for player1.

        //totalScorePossible.
        int totalScore=0;
        for(int i: nums) totalScore+=i;

        return maxFirstPlayerScore>=(totalScore-maxFirstPlayerScore); // compare both scores.


    }

    public int findMaxScore(int[] nums, int start, int end){
        if(start>end) return 0; //invalid case, break.
        if(start==end) return nums[start];   //break condition, if only one element is there.. that would be the max possible.

        if(dp[start][end]!=-1) return dp[start][end]; //use of memoization.

        //crucial part: the first user has two options, either to choose the start or the end.
        //also the next player will play the smart move, so will take the min of both the choices (at both choices that are available to first player).
        dp[start][end] = Math.max(nums[start]+Math.min(findMaxScore(nums, start+2, end), findMaxScore(nums, start+1, end-1)),
                                  nums[end]+Math.min(findMaxScore(nums,start+1,end-1), findMaxScore(nums, start, end-2)));

        return dp[start][end];
    }
}

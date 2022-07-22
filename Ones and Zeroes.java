class Solution {
    public int findMaxForm(String[] strs, int m, int n) {

        //we would need the information of number of 0's/1's in each string. Hence we are storing this information in a 2-D array.
        int[][] numOfOand1atIndex = new int[strs.length][2];
        for(int i=0;i<strs.length;i++){
            int[] arr = countZeroAndOne(strs[i]);
            numOfOand1atIndex[i][0] = arr[0];
            numOfOand1atIndex[i][1] = arr[1];
        }

        //let's build the 0/1 Knapsack DP now.
        //dp[i][j][k] represents the max largest subset we can get with first 'i' elements with atmost 'j' zeroes and 'k' one's.
        int l  = strs.length;
        int[][][] dp = new int[l+1][m+1][n+1];

        for(int i=1;i<=l;i++){
            for(int j=0;j<=m;j++){
                for(int k=0;k<=n;k++){
                    int zeroesInI=numOfOand1atIndex[i-1][0];
                    int onesInI=numOfOand1atIndex[i-1][1];

                    if(zeroesInI<=j && onesInI<=k){
                        //BELOW IS THE MAIN LOGIC OF 0/1 KNAPSACK.
                        dp[i][j][k]=Math.max(dp[i-1][j][k], 1+dp[i-1][j-zeroesInI][k-onesInI] ); //if number of 0's and 1's in (i-1)th index string are less than the boundary then we would check the largest subsets possible till here && compare it with the case when we haven't taken this element... take the max of these.
                    }else{
                        dp[i][j][k]=dp[i-1][j][k]; //if number of 0's and 1's are greater than the boundary, then simply we cannot consider the current element. Hence the max number of subset would remain the same as they were without considering the current element.
                    }
                }
            }
        }

        return dp[l][m][n];
    }

    public int[] countZeroAndOne(String str){
        int zeroes=0, ones=0;

        for(char ch : str.toCharArray()){
            if(ch=='0') zeroes++;
            else ones++;
        }
        return new int[]{zeroes, ones};
    }
}

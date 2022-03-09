class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        int MOD = (int)Math.pow(10, 9) + 7;
        long[][] dp = new long[d+1][target+1]; //long to store the values.
        dp[0][0]=1;

        //start populating the dp array.
        for(int i=1;i<=d;i++){
            for(int j=1;j<=target;j++){ //here we are computing, number of ways we can get the sum j with i dices.
                for(int k=1;k<=f;k++){ //to compute the above, we will check the (i-1) dices, with target's (k=1 to k=f faces) lesser than current target i.e., j.. OR in other words we will add the nums which are present at (i-1) row with values (k=1 -> f) less than current target.
                    if(j>=k){
                        dp[i][j]=(dp[i][j]+dp[i-1][j-k])%MOD; //(a+b)%m = ((a%m)+(b%m))%m.
                    }else{
                        break;
                    }
                }
            }
        }
        return (int)dp[d][target]; //cast to int.
    }

}

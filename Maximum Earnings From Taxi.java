class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {

        //sort rides array based on end point in ascending order.
        Arrays.sort(rides, (a,b) -> (a[1]-b[1]));

        long[] dp = new long[n+1]; //since n points, in 0 based array we would n+1 elements.
        int j=0; //we will use this global pointer to keep track of passenger we have included till a point. Since the rides array is sorted we are sure that if we have checked all passenger's till a point, no passenger would have 'dropping point' before this.. in next rides array elements.

        //dp[i] represents the max profit we can get till point i.

        for(int i=1;i<=n;i++){
            dp[i]=dp[i-1]; //safer, i.e., in case no passenger is dropping at current point 'i'.

            while(j<rides.length && rides[j][1]==i){ //check for all passengers who are dropping at 'i'.
                int profitWithCurrentPassenger = rides[j][1]-rides[j][0]+rides[j][2];
                dp[i]=Math.max(dp[i], dp[rides[j][0]] + profitWithCurrentPassenger); //check max by adding the tip of current passenger ++ tip collected till this passenger's start point.
                j++; //check next passenger.
            }
        }

        return dp[n];
    }
}

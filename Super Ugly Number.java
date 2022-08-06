class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int numOfPrimes = primes.length;
        int[] dp = new int[n+1];
        dp[1]=1;

        //following array points to one of the numbers of dp[i] which if same index of arr is multiplied, might give the next number.
        int[] pointersOfCorrespondingPrimes = new int[numOfPrimes];

        //initially all would be pointing to first number of dp only.
        Arrays.fill(pointersOfCorrespondingPrimes,1);

        //start populating dp.
        for(int k=2;k<=n;k++){
            long min=Long.MAX_VALUE;

            //check each of the potential candidate.
            for(int i=0;i<numOfPrimes;i++){
                min = Math.min(min, (long)primes[i]*dp[pointersOfCorrespondingPrimes[i]]);
            }

            //dp[k] would be min of each of these.
            dp[k]=(int)min;

            //now we need to increment all those pointers which gives the product min, so that we don't consider any of them again.
            for(int i=0;i<numOfPrimes;i++){
                if(min == (long)primes[i] * dp[pointersOfCorrespondingPrimes[i]])
                    pointersOfCorrespondingPrimes[i]++;
            }
        }

        //return the nth number.
        return dp[n];
    }
}

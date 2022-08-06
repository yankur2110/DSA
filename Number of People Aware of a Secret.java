class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp = new long[n+1]; //number of people who knows the secret at day i.
        int mod = (int)1e9+7;
        dp[0]=0;dp[1]=1;

        long numberOfPeopleSharingSecretOnThisDay = 0;
        long numberOfNewPeopleGettingSecretOnThisDay = 0;
        long numberOfPeopleForgettingSecretOnThisDay = 0;

        for(int i=2;i<=n;i++){
            //new people who will get the secret on i'th day.
            numberOfNewPeopleGettingSecretOnThisDay = dp[Math.max(i-delay,0)];
            //people who will forget the secret this day.
            numberOfPeopleForgettingSecretOnThisDay = dp[Math.max(i-forget,0)];

            //people who knows the secret till i'th day would be: people who already know the secret + new people - forgetting people.
            numberOfPeopleSharingSecretOnThisDay+=
                (numberOfNewPeopleGettingSecretOnThisDay-numberOfPeopleForgettingSecretOnThisDay + mod)%mod;

            //store in the dp.
            dp[i]=numberOfPeopleSharingSecretOnThisDay;
        }

        //if we want to calculate the number of people who knows the secret till n'th day, these would be people from (n-forget+1) to n. Previous one's have already forgotten.
        long ans=0;
        for(int i=n-forget+1;i<=n;i++){
            ans = (ans+dp[i])%mod;
        }

        return (int)ans;
    }
}

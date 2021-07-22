class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount<1) return 0;
        return helper(coins, amount, new int[amount+1]);
    }
    
    public int helper(int[] coins, int remainder, int[] resultArray){
        if(remainder<0)
            return -1;
        if(remainder==0)
            return 0;
        
        if(resultArray[remainder]!=0)
            return resultArray[remainder];
        
        int min = Integer.MAX_VALUE;
        
        for(int i=0;i<coins.length;i++){
            int res = helper(coins, remainder-coins[i], resultArray);
            if(res>=0 && res < min)
                min = 1+res;
        }
        
        resultArray[remainder] = (min==Integer.MAX_VALUE) ? -1 : min;
        return resultArray[remainder];
    }
}

class Solution {
    HashMap<String, Integer> dpMap = new HashMap<>();
    public int maxProfit(int[] prices) {
        //we are using "B" as the notation that we can buy, "S" as the notation that we can sell.
        //first param is the index of the stock that we can buy/sell.
        return maxProfitHelper(0,"B",prices);
    }

    public int maxProfitHelper(int i, String buyOrSell, int[] prices){
        //if we have exhausted all the stocs already. We cannot get any profit.
        if(i>=prices.length){
            return 0;
        }

        //this line for caching:
        String key = i+buyOrSell;
        if(dpMap.containsKey(key)){
            return dpMap.get(key);
        }

        int maxProfit=0; //since we are using bottom up. Add the profit from bottom to into the current one.

        //if we are allowed to buy the stock, then we have two option.. either to buy or just skip.
        if(buyOrSell=="B"){

            int buy = maxProfitHelper(i+1, "S", prices)-prices[i];
            int skip = maxProfitHelper(i+1, "B", prices);
            maxProfit = Math.max(buy,skip);

        }else{
            //if we have to sell the current stock, then we have two option either to sell the current stock or just skip. If we are selling then next we have to buy only ++ we cannot buy the next stock hence will pass (i+2) as the index.
            int sell = maxProfitHelper(i+2, "B", prices)+prices[i];
            int skip = maxProfitHelper(i+1, "S", prices);
            maxProfit = Math.max(sell,skip);
        }

        //store the cached data for future.
        dpMap.put(key, maxProfit);
        return maxProfit;
    }
}

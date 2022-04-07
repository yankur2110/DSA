class Solution {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> sumToNumberOfTimesMap = new HashMap<>();
        sumToNumberOfTimesMap.put(0,1); //add 0 with value 1 so that if we encounter a number whose value is equal to k, we consider that as well.

        int resultCount=0, currSum=0;

        for(int i : nums){ // traverse the array.
            currSum+=i; //keep on adding the current element to current sum.

            if(sumToNumberOfTimesMap.containsKey(currSum-k)) //if we have a subarray with sum (currSum-k) i.e., this information we can get from hashmap.
                resultCount+=sumToNumberOfTimesMap.get(currSum-k); //if yes then add that number to result count.

            sumToNumberOfTimesMap.put(currSum, sumToNumberOfTimesMap.getOrDefault(currSum, 0)+1); //put the currSum to the hashmap.
        }

        return resultCount;
    }
}

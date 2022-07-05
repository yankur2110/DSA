class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count=0;
        HashMap<Integer, Integer> map = new HashMap<>(); //we want to store the count of remainders we have encountered so far because with all these remainders, we can form a subarray.
        map.put(0,1); //so that even if a single number divisible by k comes, we count that.
        int sum=0;

        for(int i:nums){
            sum+=i;
            int remainder = sum%k; //remainder.

            if(remainder<0) remainder+=k; //add K in case of negative remainder.
            count+=map.getOrDefault(remainder,0);
            map.put(remainder, map.getOrDefault(remainder,0)+1); //add to hashmap.
        }

        return count;
    }
}

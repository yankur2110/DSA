class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int runningSum=0;
        //hashmap to store the remainder of sum till that index (with the index as value). Logic: if we encounter the same remainder, that means we have gone through one subarray which has sum purely divisible by k.
        HashMap<Integer, Integer> remainderToIndexMap = new HashMap<>();
        remainderToIndexMap.put(0,-1); //to handle the edge case like {24,0,4}, k=6.

        for(int i=0;i<nums.length;i++){
            runningSum+=nums[i];
            runningSum%=k;

            //if remainder found again, check for the length.
            if(remainderToIndexMap.containsKey(runningSum)){
                if(i-remainderToIndexMap.get(runningSum)>=2) return true;
            }else{
                remainderToIndexMap.put(runningSum,i); //otherwise just put it in the map.
            }
        }

        return false;
    }
}

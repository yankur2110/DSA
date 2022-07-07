class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]&1;
        }

        //now the problem is deduced to number of subarrays with sum k.
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum=0;
        map.put(0,1);
        int ans=0;

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            ans+=map.getOrDefault(sum-k,0);
            map.put(sum, map.getOrDefault(sum,0)+1);
        }

        return ans;
    }
}

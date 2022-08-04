class Solution {
    HashMap<String, Integer> memo = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums,target,0);
    }

    public int helper(int[] nums, int target, int start){
        if(start==nums.length && target==0){
            return 1;
        }
        if(start>=nums.length) return 0;

        String key = target+ " "+ start;
        if(memo.containsKey(key)){
            return memo.get(key);
        }

        int keepStartPositive = helper(nums, target-nums[start], start+1);
        int makeStartNegative = helper(nums, target+nums[start], start+1);

        memo.put(key, keepStartPositive+makeStartNegative);

        return memo.get(key);
    }
}

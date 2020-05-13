class Solution {
    public int firstMissingPositive(int[] nums) {
        
        HashSet<Integer> hash_set = new HashSet<Integer>();
        
        for(int i=0;i<nums.length;i++){
            if(!hash_set.contains(nums[i])){
                hash_set.add(nums[i]);
            }
        }
        
        int i;
        
        for(i=1;i<Integer.MAX_VALUE;i++){
            if(!hash_set.contains(i)){
                break;
            }
        }
       return i; 
    }
}
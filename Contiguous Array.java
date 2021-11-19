class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int longestSubString = 0;
        int currSum=0;
        
        for(int i=0;i<nums.length;i++){
            currSum+=(nums[i]==1)?1:-1;
            
            if(currSum==0){
                longestSubString = i+1;
            }else if(map.containsKey(currSum)){
                longestSubString = Math.max(longestSubString, i-map.get(currSum));
                
            }else{
                map.put(currSum, i);
            }
        }
        
        return longestSubString;
    }
}

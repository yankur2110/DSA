class Solution {
    List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(0,nums,new ArrayList<>());
        return resultList;
    }

    public void backtrack(int currIndex, int[] nums, List<Integer> currentList){

        resultList.add(new ArrayList<>(currentList));

        for(int i=currIndex;i<nums.length;i++){
            if(i>currIndex && nums[i]==nums[i-1]) continue;

            currentList.add(nums[i]);
            backtrack(i+1, nums, currentList);
            currentList.remove(currentList.size()-1);
        }

    }
}

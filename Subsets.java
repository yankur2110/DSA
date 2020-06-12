class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        //https://www.youtube.com/watch?v=CfqNrA6Jf_I
        //https://www.youtube.com/watch?v=LdtQAYdYLcE&t=405s ..both are exactly same.
        //ACTUALLY I WAS STRUCK FOR LONGER TIME SO I AM POSTPONING IT FOR FUTURE BUT SUBMITTING IT AFTER REF.
        //logic is whatever integer we have call the recursive function first by taking it and once without taking it.
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> subset = new ArrayList<Integer>();
        
        generateSubset(0,nums,subset,result);
        
        return result;
        
    }
    
    private void generateSubset(int index, int[] nums, List<Integer> subset, List<List<Integer>> result){
        
        result.add(new ArrayList<>(subset));
        
        for(int i=index;i<nums.length;i++){
            subset.add(nums[i]);
            generateSubset(i+1,nums,subset,result);
            subset.remove(subset.size()-1);
        }
        
    }
}
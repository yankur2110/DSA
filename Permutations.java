class Solution {
    /* explanation: https://www.youtube.com/watch?v=KukNnoN-SoY&t=251s
code for ref(I did not referred it ) */
    
    List<Integer> permutation = new ArrayList<Integer>();
    List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> permute(int[] nums) {
        
        boolean[] isElemVisited = new boolean[nums.length];
        
        getPermutations(nums,isElemVisited);
        
        return resultList;
        
    }
    
    public void getPermutations(int[] nums, boolean[] isElemVisited){
        
        if(permutation.size()==nums.length){
            resultList.add(new ArrayList<>(permutation));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            
            if(isElemVisited[i]==true){
                continue;
            }
            isElemVisited[i]=true;
            
            permutation.add(nums[i]);
            
            getPermutations(nums,isElemVisited);
            isElemVisited[i]=false;
            permutation.remove(new Integer(nums[i]));
        }
        
    }
}
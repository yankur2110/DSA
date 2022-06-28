class Solution {
    List<Integer> permutation = new ArrayList<>();
    List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        boolean[] visited = new boolean[nums.length];
        findPermutation(nums, visited);
        return resultList;
    }

    public void findPermutation(int[] nums, boolean[] visited){
        if(permutation.size()==nums.length){
            resultList.add(new ArrayList<>(permutation));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(visited[i]) continue;

            //this line does the wonders to get only the unique permutations.
            if(i>0 &&nums[i-1]==nums[i] && visited[i-1]) continue;
            visited[i]=true;
            permutation.add(nums[i]);
            findPermutation(nums, visited);
            visited[i]=false;
            permutation.remove(permutation.size()-1);

        }
    }


}

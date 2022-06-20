class Solution {

    List<List<Integer>> resultList = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayList<>());
        return resultList;
    }

    public void backtrack(int[] candidates, int i, int reqdSum, List<Integer> currentList){ // 'i' is the current index.

        if(reqdSum==0){
            resultList.add(new ArrayList<>(currentList));
            return;
        }

        if(reqdSum<0 || i>=candidates.length) return; //since the array is sorted, we are sure that if reqdSum<0, we will not get required collection in next elements.

        //if requiredSum is still >0, it means we can consider other elements for our possible output.
        for(int j=i;j<candidates.length;j++){
            if((j>i) && candidates[j]==candidates[j-1]) continue; //it's the main condition. Because using this we are making sure that we are not considering the duplicate combination. Once taken into consideration, skip all same elements.
            currentList.add(currentList.size(), candidates[j]);
            backtrack(candidates, j+1, reqdSum-candidates[j], currentList);
            currentList.remove(currentList.size()-1);
        }

    }
}class Solution {

    List<List<Integer>> resultList = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayList<>());
        return resultList;
    }

    public void backtrack(int[] candidates, int i, int reqdSum, List<Integer> currentList){ // 'i' is the current index.

        if(reqdSum==0){
            resultList.add(new ArrayList<>(currentList));
            return;
        }

        if(reqdSum<0 || i>=candidates.length) return; //since the array is sorted, we are sure that if reqdSum<0, we will not get required collection in next elements.

        //if requiredSum is still >0, it means we can consider other elements for our possible output.
        for(int j=i;j<candidates.length;j++){
            if((j>i) && candidates[j]==candidates[j-1]) continue; //it's the main condition. Because using this we are making sure that we are not considering the duplicate combination. Once taken into consideration, skip all same elements.
            currentList.add(currentList.size(), candidates[j]);
            backtrack(candidates, j+1, reqdSum-candidates[j], currentList);
            currentList.remove(currentList.size()-1);
        }

    }
}

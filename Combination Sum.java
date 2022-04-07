class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(candidates); //sort the array.
        backtrack(candidates, target, new ArrayList<>(), 0, resultList);
        return resultList;
    }

    public void backtrack(int[] candidates, int target, List<Integer> currentList, int start,
                         List<List<Integer>> resultList){

        if(target<0) return; //because our candidates array has only positive numbers.

        if(target==0) resultList.add(new ArrayList<>(currentList)); //create copy of currentList and add to resultList.
        else{
           for(int i=start;i<candidates.length;i++){
               currentList.add(candidates[i]); //take the current element into consideration.
               backtrack(candidates, target-candidates[i], currentList, i, resultList); //backtrack with current element in this iteration or without current element in next iteratin.
               currentList.remove(currentList.size()-1); //skip the current element.
           }
        }


    }
}

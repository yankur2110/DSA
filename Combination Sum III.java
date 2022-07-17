class Solution {
    List<List<Integer>> resultList = new ArrayList<>();
    boolean[] visited = new boolean[10];
    int sum=0;
    public List<List<Integer>> combinationSum3(int k, int n) {
        sum=n;
        findCombination(1, new ArrayList<>(), 0, k);
        return resultList;
    }

    public void findCombination(int start, List<Integer> currentList, int currSum, int k){
        if(currentList.size()==k && currSum==sum){
            resultList.add(new ArrayList<>(currentList));
            return;
        }
        if(currentList.size()>k || currSum>sum){
            return;
        }

        for(int i=start;i<=9;i++){
            if(visited[i]){
                continue;
            }

            visited[i]=true;
            currentList.add(i); currSum+=i;
            findCombination(i+1, currentList, currSum, k);
            currentList.remove(currentList.size()-1); currSum-=i;
            visited[i]=false;
        }
    }
}

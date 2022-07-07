class Solution {
    List<List<Integer>> resultList = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        findCombinations(1, n, new ArrayList<Integer>(), k);
        return resultList;
    }

    public void findCombinations(int start, int n, List<Integer> list, int k){
        if(list.size()==k){
            resultList.add(new ArrayList<>(list));
            return;
        }

        for(int i=start;i<=n;i++){
            list.add(i);
            findCombinations(i+1, n , list, k);
            list.remove(list.size()-1);

        }
    }

}

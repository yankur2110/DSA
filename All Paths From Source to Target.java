class Solution {
    List<List<Integer>> resultList = new ArrayList<>();
    HashMap<Integer, List<Integer>> adjMap = new HashMap<>();
    int max=0;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        max=graph.length-1;
        dfs(0, graph, new ArrayList<>());
        return resultList;
    }

    public void dfs(int start, int[][] graph, List<Integer> currList){
        if(start==max){
            currList.add(start);
            resultList.add(new ArrayList<>(currList));
            currList.remove(currList.size()-1);
            return;
        }

        //start exploring.
        for(int to: graph[start]){
            currList.add(start);
            dfs(to, graph, currList);
            currList.remove(currList.size()-1);
        }

    }
}

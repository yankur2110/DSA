class Solution {
    HashMap<Integer, Boolean> map = new HashMap<>();

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> resultList = new ArrayList<>();

        int nodes = graph.length;
        for(int i=0;i<nodes;i++){
            if(dfs(graph,i)) resultList.add(i);
        }
        return resultList;
    }

    //in each dfs call, we are finding whether currNode is safe node or not.
    public boolean dfs(int[][] graph, int currNode){
        if(map.containsKey(currNode)){
            return map.get(currNode);
        }

        map.put(currNode, false);
        int[] neigbors = graph[currNode];

        for(int neighbor : neigbors){
            if(!dfs(graph, neighbor))
                return false;
        }

        map.put(currNode, true);
        return map.get(currNode);
    }
}

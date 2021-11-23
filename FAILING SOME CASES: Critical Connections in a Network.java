class Solution {
    
    int rank =0;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        //first construct the adjacency graph.
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(List<Integer> list : connections){
            List<Integer> list1 = map.getOrDefault(list.get(0), new ArrayList<Integer>());
            list1.add(list.get(1));
            map.put(list.get(0), list1);
            
            //to ensure undirected graph
            List<Integer> list2 = map.getOrDefault(list.get(1), new ArrayList<Integer>());
            list2.add(list.get(0));
            map.put(list.get(1), list2);
        }

        int parentValue =-1;

        int startNode = connections.get(0).get(0);
        List<List<Integer>> resultList = new ArrayList<>();

        boolean[] visited = new boolean[n];
        int[] minArray = new int[n];

        //parentValue is passed here to make sure we don't consider parent node for min value.
        doDfsAndAssignRankAndMin(startNode, map, resultList, visited, minArray, parentValue);

        return resultList;
    }
    //basically if min of child and parent is not same, it's a critical edge.
    public int doDfsAndAssignRankAndMin(int currNode, Map<Integer, List<Integer>> edgeMap, List<List<Integer>> resultList, boolean[] visited, int[] min, int parentValue) {

        if(visited[currNode]==true ){
                return min[currNode];
        }
        visited[currNode]=true;
        min[currNode] = rank++;
        int min2 = Integer.MAX_VALUE;

        List<Integer> nodesConnectedToCurrNode = edgeMap.get(currNode);

        for(int i: nodesConnectedToCurrNode){

            if(i!=parentValue) {
                min2 = doDfsAndAssignRankAndMin(i, edgeMap, resultList, visited, min, currNode);

                if (min[currNode] < min2) {
                    List<Integer> list = new ArrayList<>();
                    list.add(currNode);
                    list.add(i);
                    resultList.add(list);
                } else {
                    min[currNode] = min2;
                }
            }
        }
        return min[currNode];
    }
}

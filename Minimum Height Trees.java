class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        //handle case where only 1 node is there.
        if (n == 1) return Collections.singletonList(0);

        List<Set<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++)
            graph.add(new HashSet<>());

        //build the graph.
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        //check for the leaves.
        List<Integer> leaves = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(graph.get(i).size()==1) leaves.add(i);
        }


        //check while total number of nodes remaining are >2.
        while(n>2){
            n-=leaves.size();

            //for the new leaves after removes the leaves i.e., reverse bfs.
            List<Integer> newLeaves = new ArrayList<>();

            for(int leaf: leaves){ //they will have for sure one node connected to them.
                int connectedNode = graph.get(leaf).iterator().next();
                graph.get(connectedNode).remove(leaf);
                if (graph.get(connectedNode).size() == 1) newLeaves.add(connectedNode);

            }
            leaves=newLeaves;
        }

        return leaves;
    }
}

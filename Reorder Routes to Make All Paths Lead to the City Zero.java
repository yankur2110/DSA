class Solution {
    public int minReorder(int n, int[][] connections) {

        //we can do the bfs traversal.
        //in each case, there should be inward edge and not outward edge.
        Map<Integer, HashSet<Integer>> map = new HashMap<>();

        Set<String> edgeDirectionsSet = new HashSet<>();

        for(int[] dir : connections){
            edgeDirectionsSet.add(dir[0]+"-"+dir[1]);
            map.putIfAbsent(dir[0], new HashSet<>());
            map.putIfAbsent(dir[1], new HashSet<>());
            map.get(dir[0]).add(dir[1]);
            map.get(dir[1]).add(dir[0]);
        }

        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        boolean[] visited = new boolean[n];
        visited[0]=true;

        int result=0;
        while(!que.isEmpty()){
            int currNode = que.poll();

            //check of opp direction at the time of inserting in queue.
            for(int neighbor : map.getOrDefault(currNode, new HashSet<>())){
                if(visited[neighbor]) continue;
                visited[neighbor]=true;

                if(edgeDirectionsSet.contains(currNode+"-"+neighbor)) result++;
                que.add(neighbor);
            }
        }

        return result;
    }
}

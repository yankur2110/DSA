class Solution {

    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer,Integer>> map = new HashMap<>();

        //map stores the neighbors to a node with their respective distance from key node as well.
        for(int[] time : times){
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }

        //distance, node into pq. We will use this to do the bfs based on distance.
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] - b[0]));

        //add the start.
        pq.add(new int[]{0, K});

        //keep the visited array so that we don't process the same node again. Because since we are popping the element based on distance, it is guranteed that it's the minimum distance for that node to reach from K.
        boolean[] visited = new boolean[N+1];
        int res = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.remove();
            int curNode = cur[1];
            int curDist = cur[0];
            if(visited[curNode]) continue;
            visited[curNode] = true;
            res = curDist; //distance to reach the current node.
            N--; //it means we are able to reach one more node.

            if(map.containsKey(curNode)){ //add neighbors of current node to the priority queue.
                for(int next : map.get(curNode).keySet()){
                    pq.add(new int[]{curDist + map.get(curNode).get(next), next});
                }
            }
        }

        //return the result.
        return N == 0 ? res : -1;

    }
}

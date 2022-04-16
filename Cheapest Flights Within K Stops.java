class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[][] adjMatrix = new int[n][n]; //this is used to check if there's a path between i->j. That would be there if there exists a cost value for it.

        for(int[] flight : flights){
            adjMatrix[flight[0]][flight[1]]=flight[2]; //populate adjMatrix
        }

        int[] shortestDistances = new int[n]; //this array will contain the shortest distances of a city from src city.
        int[] hops = new int[n]; //we need to store the stops we have taken to reach a node as well. This would be used to consider if we can reach a node to a node in fewer steps (modified Djikstra in our case). Because there's a probability that there's might be a path from that node, but if we don't consider the stops we are killing that probability.

        Arrays.fill(shortestDistances, Integer.MAX_VALUE); //initialize the shortestDistances array with infinity values.
        Arrays.fill(hops, Integer.MAX_VALUE); //initialize the stops array with infinity values.

        shortestDistances[src]=0; //since src node would be at 0 distance from src city.
        hops[src]=0; //since there would be 0 stops taken to reach the src node.


        //As we know in Dijkstra algorithm, we need to check the minimum weight (or cost here) of a node. So, we will need the node itself and it's weight (cost to reach there).
        //Since, in our case we have a constraint of atmax K hops, so we will need to keep track of number of hops we have encountered till now as well. So, our priority queue will contain the NODE ITSELF, MIN. COST TO REACH THIS NODE, NUMBER OF HOPS WE'VE CONSIDERED SO FAR.

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a,b) -> a[1]-b[1]
        ); //i.e., minHeap on basis of cost.

        minHeap.offer(new int[]{src,0,0}); //adding the src node to heap.

        while(!minHeap.isEmpty()){
            int[] nodeToBeConsidered = minHeap.poll();
            int node = nodeToBeConsidered[0];
            int costTillTheNode = nodeToBeConsidered[1];
            int hopsTakenToReachTheNode = nodeToBeConsidered[2];

            if(node==dst) //because the node that we have just picked has already got minCost.
                return costTillTheNode;
            if(hopsTakenToReachTheNode==k+1) //since max of K-hops are allowed.
                continue;

            for(int nei=0;nei<n;nei++){
                if(adjMatrix[node][nei]>0){ //if path to neighbor exists.

                    int dU = costTillTheNode, dV = shortestDistances[nei], wUV = adjMatrix[node][nei];

                    // Better cost.. normal Dijkstra.
                    if (dU + wUV < dV) {
                        shortestDistances[nei] = dU + wUV;
                        hops[nei] = hopsTakenToReachTheNode+1;
                        minHeap.offer(new int[]{nei, dU + wUV, hopsTakenToReachTheNode + 1});

                    }else if(hopsTakenToReachTheNode+1 < hops[nei]){ //Better hops.. This is the modified case i.e., if number of hops are less for a neighbor irrespective of the cost.
                        shortestDistances[nei] = dU + wUV; // this line is added for last test case that was failing if it was not added.
                        hops[nei] = hopsTakenToReachTheNode+1;
                        minHeap.offer(new int[]{nei, dU + wUV, hopsTakenToReachTheNode + 1});
                    }
                }

            }
        }

        return shortestDistances[dst] == Integer.MAX_VALUE? -1 : shortestDistances[dst];
    }
}

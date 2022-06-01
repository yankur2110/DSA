class Solution {
    public boolean isBipartite(int[][] graph) {
        int numOfNodes = graph.length;
        int[] colourOfNodesArray = new int[numOfNodes]; //this array represents the colour of node ++ if it's uncoloured it means it's unvisited.

        for(int i=0;i<numOfNodes;i++){ //additional for loop, as this graph might have several unconnected graphs.

            if(colourOfNodesArray[i]!=0) continue; //if the node is coloured it means it's visited, so no need to continue.

            Queue<Integer> que = new LinkedList<>();
            que.offer(i); //add the current node to queue.

            colourOfNodesArray[i]=1; //1 for blue, -1 for red, 0 for no colour/unvisited.

            while(!que.isEmpty()){ //traverse the current graph and colour it.
                int current = que.poll(); //it's slightly different (minute) bfs traversal, since we already know the neighbors. So, we don't need to get the size and traverse those nodes.

                for(int neighbourOfCurrent : graph[current]){
                    if(colourOfNodesArray[neighbourOfCurrent] == 0){ //if it's not coloured, fill it with alternate colour and add to queue.
                       colourOfNodesArray[neighbourOfCurrent] =  -colourOfNodesArray[current];
                        que.offer(neighbourOfCurrent);
                    }else if(colourOfNodesArray[neighbourOfCurrent] != -colourOfNodesArray[current]){ //if it's coloured filled, check if it's filled with same colour or not. If not return false.
                        return false;
                    }
                }
            }
        }

        return true; //if no adjacent nodes have same colour, it means they have different colour. That means it's a bipartite graph -> Return true.

    }
}

class Solution {
    int[] parent; //unlike our union find template, here we are storing the absolute parent. Since it's an undirected graph.
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length+1];

        //initially every is it's own parent.
        for(int i=1;i<=edges.length;i++){
            parent[i]=i;
        }

        for(int[] edge : edges){
            int A = edge[0]; //we will make the first node as parent.
            int B = edge[1]; //we will make the second node as it's child.

            int parentA= getAbsoluteParent(A); //whenever we are checking the absolute parent, we are updating the absolute parent's as well at the same time.
            int parentB= getAbsoluteParent(B);

            if(parentA==parentB){ //whenever we found a cycle, we return the edge.. since two  nodes have same parent.
                return edge;
            }

            parent[parentB]=parentA; //important.. link absolute parents. This ensures that we don't do incorrect parent relations in the parent array.
        }

        return new int[2];
    }

    public int getAbsoluteParent(int node){ //returning and updating the absolute parent of a node.
        if(node==parent[node]) return node;

        parent[node]=getAbsoluteParent(parent[node]); //storing the absolute parent.
        return parent[node];
    }
}

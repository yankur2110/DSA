class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] matrix = new int[n][n];
        for(int[] row : matrix)
            Arrays.fill(row,10001); //since adding weight of two edges in case of Integer.MAX_VALUE would result into integer overflow.

        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];

            matrix[from][to]=weight;
            matrix[to][from]=weight; //since undirected graph.
        }


        for(int i=0;i<n;i++){
            matrix[i][i]=0; //since the difference of node with itself is 0.
        }

        //Actual algorithm starts
        for(int k=0;k<n;k++){ //intermediate node.
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k]+matrix[k][j]);
                }
            }
        }

        int city = n-1;
        int connectedTo = n;

        for(int i=0;i<n;i++){
            int count=0; //city 'i' is connected to 'count' number of cities.
            for(int j=0;j<n;j++){
                if(matrix[i][j]<=distanceThreshold){
                    count++;
                }
            }

            if(count<=connectedTo){
                connectedTo=count;
                city=i;
            }

        }

        return city;
    }
}

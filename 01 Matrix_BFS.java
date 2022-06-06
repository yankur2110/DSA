class Solution {
    public int[][] updateMatrix(int[][] mat) {
        //BFS APPROACH:
        Queue<int[]> bfsQueue = new LinkedList<>();

        //iterate the matrix, put -1 if it's value is other than 0. If it's 0 then add to queue.
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    bfsQueue.offer(new int[]{i,j});
                }else{
                    mat[i][j]=-1;
                }
            }
        }

        //bfs traversal starting from 0's -> then it's neighbours.
        int[][] dir = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
        while(!bfsQueue.isEmpty()){
            int[] polledCell = bfsQueue.poll();
            int polledCellRow = polledCell[0];
            int polledCellCol = polledCell[1];

            //check all neighbours.
            for(int i=0;i<4;i++){
                int neighborRow = polledCellRow + dir[i][0];
                int neighborCol = polledCellCol + dir[i][1];

                //continue, if it's out of range or already computed.
                if(neighborRow<0 || neighborRow>=mat.length ||  neighborCol<0 ||
                   neighborCol>=mat[0].length || mat[neighborRow][neighborCol]!=-1) continue;

                mat[neighborRow][neighborCol] = mat[polledCellRow][polledCellCol]+1;
                bfsQueue.offer(new int[]{neighborRow, neighborCol});
            }
        }

        return mat;
    }
}

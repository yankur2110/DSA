class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        if(grid[0][0] == 1 || grid[grid.length-1][grid.length-1] == 1)
            return -1;

        int[][] directions = { //directions starting from west -> anti-clockwise.
            {0,-1},
            {-1,-1},
            {-1,0},
            {-1,1},
            {0,1},
            {1,1},
            {1,0},
            {1,-1}

        };

        Queue<int[]> que = new LinkedList<>();
        int level=0;
        int[] startPos = {0,0};
        que.offer(startPos);
        grid[0][0]=-1;

        while(!que.isEmpty()){
            level++;

            int size = que.size();
            for(int i=0;i<size;i++){

                int[] polledCoordinate = que.poll();
                int x = polledCoordinate[0];
                int y = polledCoordinate[1];

                if(x==grid.length-1 && y==grid.length-1){
                    return level;
                }

                for(int j=0;j<directions.length;j++){
                    int adjacentXCoordinate = x+directions[j][0];
                    int adjacentYCoordinate = y+directions[j][1];

                    if(adjacentXCoordinate<0 || adjacentXCoordinate>=grid.length || adjacentYCoordinate<0 || adjacentYCoordinate>=grid.length )
                        continue;

                    if(grid[adjacentXCoordinate][adjacentYCoordinate]==0){
                        que.add(new int[]{adjacentXCoordinate, adjacentYCoordinate});
                        grid[adjacentXCoordinate][adjacentYCoordinate]=-1; //to avoid extra visited array, we are just updating the value at that coordinate to be -1.

                    }
                }

            }

        }

        return -1;

    }
}

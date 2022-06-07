class Solution {
    int[][] directions = {{0,-1},{-1,0},{0,1},{1,0}};
    public int islandPerimeter(int[][] grid) {
        int result=0;

        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++)
                result+=getNetPerimiterByThisIsland(grid, i,j);

      return result;
    }

    public int getNetPerimiterByThisIsland(int[][] grid, int i, int j){
        if(grid[i][j]!=1) return 0;

        int count=0;
        for(int k=0;k<4;k++){
            int adjRow = i+directions[k][0];
            int adjCol = j+directions[k][1];

            if(adjRow>=0 && adjRow<grid.length && adjCol>=0 && adjCol<grid[0].length && grid[adjRow][adjCol]==1){
                count++;
            }
        }

        return 4-count;
    }
}

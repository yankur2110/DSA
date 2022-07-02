class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length, res = 0;

        //check for land in top-left.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) continue; //no need to anything in case of land.
                grid[i][j] = 201; //201 because.. the size won't exceed 100.
                if (i > 0) grid[i][j] = Math.min(grid[i][j], grid[i-1][j] + 1); //top.
                if (j > 0) grid[i][j] = Math.min(grid[i][j], grid[i][j-1] + 1); //left.
            }
        }

        //check for land in bottom right.
        for (int i = n-1; i >=0 ; i--) {
            for (int j = n-1; j >=0 ; j--) {
                if (grid[i][j] == 1) continue; //no need to anything in case of land.
                if (i < n-1) grid[i][j] = Math.min(grid[i][j], grid[i+1][j] + 1); //bottom.
                if (j < n-1) grid[i][j] = Math.min(grid[i][j], grid[i][j+1] + 1); //right
                res = Math.max(res, grid[i][j]); //update the maximum
            }
        }

        //returning res-1 because in case of land is connected we are doing +1 i.e., it will start with 2 only even if land is present at next index.
        return res == 201 ? -1 : res - 1;
    }
}

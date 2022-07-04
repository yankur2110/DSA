class Solution {
    //for easy 4 direction travel.
    int[] dirX = {0,0,-1,1};
    int[] dirY = {-1,1,0,0};

    public int closedIsland(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;

        //convert land connected to boundary to water.
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i*j==0 || i==row-1 || j==col-1){
                    if(grid[i][j]==0)
                        dfs(grid,i,j);
                }
            }
        }

        //after updating all the lands connected to boundary to water. Now we will iterate the matrix again to find the actual land which is totally surrounded by water.
        int ans=0;
        for(int i=1;i<row-1;i++){
            for(int j=1;j<col-1;j++){
                if(grid[i][j]==0){
                    ans++; //increment the answer.
                    dfs(grid,i,j); //convert whole this connected island to water.
                }
            }
        }

        //return the answer.
        return ans;
    }

    //dfs to mark all connected lands as water.
    public void dfs(int[][] grid, int i, int j){
        //check if it's valid or not.
        if(!(i<grid.length && i>=0 && j<grid[0].length && j>=0 && grid[i][j]==0)) return;

        grid[i][j]=1;
        for(int k=0;k<4;k++){
            dfs(grid,i+dirX[k], j+dirY[k]);
        }
    }
}

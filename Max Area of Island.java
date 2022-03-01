class Solution {
    int maxArea = 0;
    public int maxAreaOfIsland(int[][] grid) {

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    int  returnVal = countConnectedIsland(i,j,grid);
                    maxArea = Math.max(maxArea, returnVal);
                }
            }
        }
        return maxArea;
    }

    public int countConnectedIsland(int i, int j, int[][] grid){
        if( i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!=1 )
            return 0;
        grid[i][j]=2;
        return 1+ countConnectedIsland(i+1,j,grid)+
        countConnectedIsland(i-1,j,grid)+
        countConnectedIsland(i,j-1,grid)+
        countConnectedIsland(i,j+1,grid);
    }
}

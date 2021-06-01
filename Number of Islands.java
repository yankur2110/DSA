class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    makeConnectedLandZero(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void makeConnectedLandZero(char[][] grid, int row, int col){
        
        if(row>=grid.length || row<0 || col>=grid[0].length || col<0 || grid[row][col]=='0')
            return;
        
        grid[row][col]='0';
        makeConnectedLandZero(grid, row+1, col);
        makeConnectedLandZero(grid, row, col+1);
        makeConnectedLandZero(grid, row-1, col);
        makeConnectedLandZero(grid, row, col-1);
        
            
            
    }
}

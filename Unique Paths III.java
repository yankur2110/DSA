class Solution {
    int result=0;
    public int uniquePathsIII(int[][] grid) {
        int emptyCells = 0;
        int x=0,y=0; //position of start cell.
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0)
                    emptyCells++;
                if(grid[i][j]==1){
                    x=i; y=j;
                }
            }
        }
        dfs(grid,x,y,emptyCells);
        return result;
    }

    public void dfs(int[][] grid, int x, int y, int emptyCells){

        if(x<0 || y<0 ||x>=grid.length || y>=grid[0].length || grid[x][y]<0)
            return;

        if(grid[x][y]==2 ){
            if(emptyCells== -1){ //here it's important to note that we are not comparing emptyCells with 0 but with -1 instead because we are considering 1 as well in our path. And we are at 1, we aare s
                result++;
            }
            return; //here we need to store nested if because we will return if we encounter 2 everytime even if emptyCells != -1.
        }
        emptyCells--;
        grid[x][y]=-1;
        dfs(grid,x,y-1,emptyCells);
        dfs(grid,x-1,y,emptyCells);
        dfs(grid,x,y+1,emptyCells);
        dfs(grid,x+1,y,emptyCells);
        grid[x][y]=0;
        emptyCells++;
    }
}

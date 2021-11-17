class Solution {
    public int getMaximumGold(int[][] grid) {
        
        if(grid==null || grid.length==0)
            return 0;
        int m = grid.length, n = grid[0].length;
        int max=0;
        
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(grid[i][j]>0)
                    max= Math.max(max, findMaxGoldPath(grid, i, j, m, n, new boolean[m][n]));
            }
        
        return max;
    }
    
    public int findMaxGoldPath(int[][] grid, int i, int j, int row, int col, boolean[][] visited){
        
        if( i<0 || j<0 || i>=row || j>=col || visited[i][j] || grid[i][j]==0 )
            return 0;
        
        visited[i][j]=true;
        
        int left = findMaxGoldPath(grid, i-1,j, row, col, visited);
        int right = findMaxGoldPath(grid, i+1,j, row, col, visited);
        int top = findMaxGoldPath(grid, i,j-1, row, col, visited);
        int bottom = findMaxGoldPath(grid, i,j+1, row, col, visited);
        visited[i][j]=false;
    
        return Math.max(left, Math.max(right, Math.max(top,bottom))) + grid[i][j];
    }
}

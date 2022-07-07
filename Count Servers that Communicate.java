class Solution {
    public int countServers(int[][] grid) {
        int m= grid.length, n =grid[0].length;
        int[] isServerOnRow = new int[m];
        int[] isServerOnCol = new int[n];
        int count=0;


        //count number of computers present in each row and each col.
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    isServerOnRow[i]++;
                    isServerOnCol[j]++;
                }
            }
        }

        //if more than 1 computer is present in that row or col, increment the count.
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && (isServerOnRow[i]>1 || isServerOnCol[j]>1))
                    count++;
            }
        }
        return count;
    }
}

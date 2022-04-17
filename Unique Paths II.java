class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length,n = obstacleGrid[0].length;

        int[][] dpArray = new int[m][n]; //declare the dpArray. (i,j) represents the number of ways to reach index (i,j).
        // Arrays.fill(dpArray,0); //no need to this explicitly as array's all elements would be initialized with 0 values by default.

        for(int i=0;i<n;i++){ //initialize first row.
            if(obstacleGrid[0][i]==0) dpArray[0][i]=1; //if no obstacle then only the robot can go.
            else break;                                //if there's an obstacle robot cannot proceed on that row.
        }
        for(int i=0;i<m;i++){ //initialize first column.
            if(obstacleGrid[i][0]==0) dpArray[i][0]=1; //if no obstacle then only the robot can go.
            else break;                                //if there's an obstacle robot cannot proceed on that column.
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==1){ //if encounters an obstacle, there's no way to reach there.
                    dpArray[i][j]=0;
                }else{
                    dpArray[i][j] = dpArray[i-1][j] + dpArray[i][j-1]; //if no obstacle, then robot can come from top or left.
                }
            }
        }

        return dpArray[m-1][n-1]; //return the result.

    }
}

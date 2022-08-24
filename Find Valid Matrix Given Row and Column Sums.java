class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        //greedily keep on finding the valid number for an index.
        int rows= rowSum.length;
        int cols= colSum.length;
        int[][] result = new int[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                result[i][j]=Math.min(rowSum[i],colSum[j]);
                rowSum[i]-=result[i][j];
                colSum[j]-=result[i][j];
            }
        }
        return result;
    }
}

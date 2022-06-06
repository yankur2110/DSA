class Solution {
    public int[][] updateMatrix(int[][] mat) {
        //DP Approach.
        int numOfRows = mat.length, numOfCols = mat[0].length;

        //since it isn't possible to calculate the minDistance from all adjacent cells in one go, we will first apply the DP approach by comparing left and top. Then with bottom and right.
        for(int i=0;i<mat.length;i++)
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0) continue;

                int top = numOfRows+numOfCols, left = numOfRows+numOfCols; //default max number of traversal required for 0 cell.

                if(i-1>=0)
                    top = mat[i-1][j];
                if(j-1>=0)
                    left = mat[i][j-1];

                mat[i][j]=Math.min(top,left)+1;
            }


        //now check with bottom and right.
        for(int i=numOfRows-1;i>=0;i--)
            for(int j= numOfCols-1;j>=0;j--){
                if(mat[i][j]==0) continue;

                int bottom = numOfRows+numOfCols, right = numOfRows+numOfCols; //default max number of traversal required for 0 cell.

                if(i+1<=numOfRows-1)
                    bottom = mat[i+1][j];
                if(j+1<=numOfCols-1)
                    right = mat[i][j+1];

                mat[i][j]=Math.min(mat[i][j],Math.min(bottom,right)+1);
            }

        return mat;

    }
}

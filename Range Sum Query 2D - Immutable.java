class NumMatrix {
    int[][] sumOfRectTillIndex;

    public NumMatrix(int[][] matrix) {
        sumOfRectTillIndex = new int[matrix.length+1][matrix[0].length+1];

        //pre-calculate the sum from (0,0) to (i,j) of matrix in sumOfRectTillIndex array
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[0].length;j++){
                sumOfRectTillIndex[i+1][j+1]= matrix[i][j]+sumOfRectTillIndex[i][j+1]+sumOfRectTillIndex[i+1][j]-sumOfRectTillIndex[i][j];
            }
    }

    //now we can find the sumRegion in constant time.
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1+=1; col1+=1; row2+=1; col2+=1; //for better understanding of calcuations in sumOfRectTillIndex array, since it has one additional row and column.

        return sumOfRectTillIndex[row2][col2] - sumOfRectTillIndex[row2][col1-1] - sumOfRectTillIndex[row1-1][col2]+sumOfRectTillIndex[row1-1][col1-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

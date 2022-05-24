class Solution {
    public int[][] generateMatrix(int n) {
        int val=1;
        int r1=0, c1=0, r2=n-1, c2=n-1;
        int[][] resultMatrix = new int[n][n];

        while(r1<=r2 && c1<=c2){
            //top side
            for(int c=c1;c<c2;c++) resultMatrix[r1][c] = val++;

            //right side
            for(int r=r1;r<=r2;r++) resultMatrix[r][c2] = val++;

            //bottom side
            for(int c=c2-1;c>=c1;c--) resultMatrix[r2][c] = val++;

            //left side
            for(int r=r2-1;r>r1;r--) resultMatrix[r][c1] = val++;

            //shrink the matrix as outer boundary is already populated.
            r1++;
            c1++;
            c2--;
            r2--;
        }

        return resultMatrix;
    }
}

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        if(n==1) return matrix[0][0];

        int min=Integer.MAX_VALUE;;
        for(int i=n-2;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                matrix[i][j] = getMinFallingPathFromIJ(matrix,i,j);
                if(i==0){
                    min=Math.min(min, matrix[i][j]);
                }
            }
        }

        return min;
    }

    public int getMinFallingPathFromIJ(int[][] matrix, int i, int j){
        int min =Integer.MAX_VALUE;
        int a = Integer.MAX_VALUE, b =Integer.MAX_VALUE, c = Integer.MAX_VALUE;

        if(j-1>=0)
            a=matrix[i+1][j-1];

        b=matrix[i+1][j];

        if(j+1<matrix.length)
            c=matrix[i+1][j+1];

        return matrix[i][j]+Math.min(a, Math.min(b,c));
    }
}

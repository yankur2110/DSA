class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        //we will first build a prefix sum matrix which stores the sum of rectangle (or square) ending at an index (i,j).

        int m=mat.length, n=mat[0].length;
        int[][] sum = new int[m+1][n+1];

        //compute the sum.
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                sum[i][j]=sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + mat[i-1][j-1];
            }
        }

        //now we will do the binary search to find the minimum side length of square if possible whose sum<=threshold.
        int low=0, high=Math.min(m,n), mid=0;

        while(low<=high){
            mid=low+(high-low)/2;

            if(isSquarePossible(mid,sum,threshold)){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        //return the max side length.
        return high;
    }

    //check in the whole matrix if square of length 'len' exists.
    public boolean isSquarePossible(int len, int[][]sum, int threshold){
        for(int i=len;i<sum.length;i++){
            for(int j=len;j<sum[0].length;j++){
                int sumOfSquareAtIJ = sum[i][j]-sum[i][j-len]-sum[i-len][j]+sum[i-len][j-len];

                if( sumOfSquareAtIJ<=threshold){
                    return true;
                }
            }
        }
        return false;
    }
}

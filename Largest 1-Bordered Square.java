class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        if(grid.length==0) return 0;

        int m = grid.length, n = grid[0].length;
        //hori and ver matrices are there to keep track of consecutive 1's in that row/col respectively.
        int[][] horiMaxConsecutive1sTillNow = new int[m+1][n+1];
        int[][] verMaxConsecutive1sTillNow = new int[m+1][n+1];

        int max=0; //max area, which will be storing the result.

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(grid[i-1][j-1]==0) continue; //if it's 0 then hori and vert will keep 0 at the respective index.

                horiMaxConsecutive1sTillNow[i][j] = horiMaxConsecutive1sTillNow[i][j-1]+1;
                verMaxConsecutive1sTillNow[i][j] = verMaxConsecutive1sTillNow[i-1][j]+1;

                //min right, bottom side length possible based with the help of above matrix directly.
                int minEdge = Math.min(horiMaxConsecutive1sTillNow[i][j], verMaxConsecutive1sTillNow[i][j]);

                //find left, top side based on our requirement.
                for(int k=minEdge; k>=1; k--){
                    //k-1 steps above in the same col (of hori matrix)... for top side.
                    //k-1 steps left in the same row (of ver matrix)... for left side.

                    if(horiMaxConsecutive1sTillNow[i-k+1][j]>=k &&
                      verMaxConsecutive1sTillNow[i][j-k+1]>=k){
                        max= Math.max(max,k*k); //k sides square ending at i,j index can be found. If it's greater than max, update max.
                        break;
                    }

                }
            }
        }

        return max; //return result.
    }
}

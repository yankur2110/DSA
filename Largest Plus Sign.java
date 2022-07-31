class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        //here I've used four matrix and iterating grid matrix four times to get the result.
        //however we can do all that in just a single iteration as well.
        int[][] grid = new int[n][n];

        for(int i=0;i<n;i++){
            Arrays.fill(grid[i],1);
        }

        for(int i=0;i<mines.length;i++){
            grid[mines[i][0]][mines[i][1]]=0;
        }

        int[][] left = new int[n][n]; //continuous 1's from left.
        int[][] right = new int[n][n]; //continuous 1's from right.
        int[][] top = new int[n][n]; //continuous 1's from top.
        int[][] bottom = new int[n][n]; //continuous 1's from bottom.

        //populate the left matrix.
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                left[i][j]=grid[i][j];
                if(j-1>=0)
                    left[i][j] = (grid[i][j]==1?left[i][j-1]+1:0);
            }
        }

        //populate right.
        for(int i=0;i<n;i++){
            for(int j=n-1;j>=0;j--){
                right[i][j]=grid[i][j];
                if(j+1<=n-1)
                    right[i][j] = (grid[i][j]==1?right[i][j+1]+1:0);
            }
        }

        //populate top.
        for(int j=0;j<n;j++){
            for(int i=0;i<n;i++){
                top[i][j]=grid[i][j];

                if(i-1>=0)
                    top[i][j] = (grid[i][j]==1?top[i-1][j]+1:0);
            }
        }

        //populate bottom.
        for(int j=0;j<n;j++){
            for(int i=n-1;i>=0;i--){
                bottom[i][j]=grid[i][j];

                if(i+1<=n-1)
                    bottom[i][j] = (grid[i][j]==1?bottom[i+1][j]+1:0);
            }
        }


        //get the min value at i,j index.
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){

                int maxPossibleAtIJ = Math.min(left[i][j], Math.min(right[i][j], Math.min(top[i][j],bottom[i][j])));

                max = Math.max(max, maxPossibleAtIJ);
            }
        }

        //return the max.
        return max;
    }
}

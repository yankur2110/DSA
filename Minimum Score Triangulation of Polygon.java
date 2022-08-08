class Solution {
    int[][] memo = null;
    public int solve(int[] values, int i, int j){
        //take (i,j) as the base of triangle and check all what's the minimum triangulation we can form.
        if(i+1==j) return 0; //(if i and j are adjacent, then no triangle is possible.)

        if(memo[i][j]!=0){
            return memo[i][j];
        }
        int min = Integer.MAX_VALUE;
        //check for every k. K would start from i+1 to j-1 because only these vertices can form a triangle with i and j.
        for(int k=i+1;k<j;k++){

            int IKJtriangle = (values[i]*values[k]*values[j] + solve(values,i,k) + solve(values, k, j));
            min = Math.min(min,IKJtriangle);
        }
        memo[i][j]=min; //memoize this result.
        return min;
    }
    public int minScoreTriangulation(int[] values) {
        memo=new int[values.length][values.length];
        return solve(values, 0, values.length-1);
    }
}

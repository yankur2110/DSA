class Solution {
    //for large results.
    int mod = (int)1e9+7;
    int[][] dirs = {{0,-1},{-1,0},{0,1},{1,0}}; //to explore adjacent 4 directions.

    HashMap<String, Integer> memoMap = new HashMap<>(); //shorthand for memoization.

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        return dfs(m,n,maxMove,startRow,startColumn);
    }

    public int dfs(int m, int n, int max, int i, int j){

        //if no more moves left.
        if(max<0)
            return 0;

        //if out of boundary, increment the count.
        if(i<0 || j<0 || i>=m || j>=n){
            if(max>=0)
                return 1;
        }

        //memoization part i.e., if already computed.
        String key = i+" "+j+" "+max;
        if(memoMap.containsKey(key)){
            return memoMap.get(key);
        }

        int count=0;
        //explore all directions.
        for(int k=0;k<4;k++){
            count = (count + dfs(m,n,max-1,i+dirs[k][0], j+dirs[k][1]))%mod;
        }

        //store every calculation in a map.. for future use.
        memoMap.put(key,count);
        return count;
    }
}

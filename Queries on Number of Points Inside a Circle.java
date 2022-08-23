class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {

        int n = queries.length;
        int[] result = new int[n];

        for(int i=0;i<n;i++){
            int count =0;

            for(int[] point : points){
                if(isInsideRadius(queries[i][0], queries[i][1], queries[i][2], point[0], point[1])){
                    count++;
                }
            }
            result[i]=count;
        }

        return result;
    }

    public boolean isInsideRadius(int x, int y, int r, int i, int j){
        int dist = (x-i)*(x-i) + (y-j)*(y-j);
        return dist<=(r*r);
    }
}

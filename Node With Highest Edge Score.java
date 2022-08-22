class Solution {
    public int edgeScore(int[] edges) {
        long[] edgeScore = new long[edges.length];

        for(int i=0;i<edges.length;i++){
            edgeScore[edges[i]]+=i;
        }

        int node =0;
        long max=Long.MIN_VALUE;
        for(int i=edges.length-1;i>=0;i--){
            if(edgeScore[i]>=max){
                max=edgeScore[i];
                node=i;
            }
        }

        return node;
    }
}

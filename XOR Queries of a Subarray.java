class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n=arr.length;
        int[] prefixXorArray = new int[n];
        int[] result = new int[queries.length];
        int j=0;
        prefixXorArray[0]=arr[0];

        for(int i=1;i<n;i++){
            prefixXorArray[i]=prefixXorArray[i-1]^arr[i];
        }

        for(int[] query : queries){
            int start = query[0];
            int end = query[1];
            result[j++]=(arr[start]^prefixXorArray[start])^prefixXorArray[end];
        }

        return result;

    }
}

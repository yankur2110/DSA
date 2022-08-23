class Solution {
    public int longestMountain(int[] arr) {
        int[] dpUpFromLeft = new int[arr.length];
        int[] dpUpFromRight = new int[arr.length];

        for(int i=0;i<arr.length;i++){
            dpUpFromLeft[i]=1;
            if((i-1)>=0 && arr[i]>arr[i-1]){
                dpUpFromLeft[i]=dpUpFromLeft[i-1]+1;
            }
        }

        int max=0;
        for(int i=arr.length-1;i>=0;i--){
            dpUpFromRight[i]=1;
            if((i+1)<arr.length && arr[i]>arr[i+1]){
                dpUpFromRight[i]=dpUpFromRight[i+1]+1;
            }

            int largestMountainWithTopAtI =0;
            if(dpUpFromLeft[i]>1 && dpUpFromRight[i]>1)
                largestMountainWithTopAtI=dpUpFromLeft[i]+dpUpFromRight[i]-1;

            max=Math.max(max, largestMountainWithTopAtI);
        }
        return max;
    }
}

class Solution {
    public int maxScore(int[] arr, int k) {
        //indirectly we can think of this problem as finding the minimum subArray of size n-k.
        int totalSum=0,currSum=0, minSum=Integer.MAX_VALUE;
        int eligibleWindowSize=arr.length-k, currentWindowSize=0;


        for(int end=0;end<arr.length;end++){
            currSum+=arr[end];
            currentWindowSize = end+1;

            //if the currentWindow from 0 till 'end' is greater than the eligible window then only we calculate the minSum.
            if(currentWindowSize>=eligibleWindowSize){

                //if currentWindow is greater than the eligible window, remove previous element from sum.
                if(currentWindowSize>eligibleWindowSize){
                    currSum-=arr[end-eligibleWindowSize];
                }

                //update the min sum.
                minSum=Math.min(minSum, currSum);
            }

            //keep on adding the current element to the total sum.
            totalSum+=arr[end];
        }

        //our desired sum would be totalSum-minSum.
        return totalSum-minSum;
    }
}

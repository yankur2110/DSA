class Solution {
    public int videoStitching(int[][] clips, int time) {
        int startOfCurrentMaxEndClip=0;
        int endOfCurrentMaxEndClip=0;
        int minClipsCount=0;

        int indexOfClipsToBeConsidered =0;

        Arrays.sort(clips, (a,b)-> a[0]-b[0]); //sort the clips in ascending order.

        //while we haven't reached the clip with end equal to the time.
        while(endOfCurrentMaxEndClip<time){

            while(indexOfClipsToBeConsidered< clips.length && clips[indexOfClipsToBeConsidered][0]<= startOfCurrentMaxEndClip){
                endOfCurrentMaxEndClip = Math.max(endOfCurrentMaxEndClip,clips[indexOfClipsToBeConsidered][1]);
                indexOfClipsToBeConsidered++;
            }

            if(startOfCurrentMaxEndClip==endOfCurrentMaxEndClip) //if start and end is the same, this same we haven't found a video which is overlapping or has end starting with last start ++ have end greater than start.
                //also note that initially start=0, end=0 ++ in the end of loop we are pointing start to the end we found. So, this check is valid to compare if we have a clip which has extended the end or not.
                return -1;

            //if we have found a clip that can be appended, increment the minClipsCount.
            minClipsCount++;

            //we have reached till the end, so for further iteration we will check any clip is there which has start less than this and max greater than this.
            startOfCurrentMaxEndClip=endOfCurrentMaxEndClip;

        }

        return minClipsCount;

    }
}

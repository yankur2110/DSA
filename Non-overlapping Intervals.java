class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //sort the array based on start value.
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);

        int prevEnd = intervals[0][1];
        int minEraseReqd =0;

        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<prevEnd){ //if it's a overlapping case.
                minEraseReqd++; //has to erase one interval.
                prevEnd = Math.min(prevEnd, intervals[i][1]); //remove the one which has greater right end.
            }else{
                prevEnd = intervals[i][1]; //otherwise just increase the prevEnd.
            }
        }

        return minEraseReqd; //return minEraseRequired.
    }
}

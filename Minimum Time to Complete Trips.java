class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int n= time.length-1;
        long minTime=0, maxTime=100_000_000_000_000L;

        while(minTime<maxTime){
            long mid = minTime + (maxTime-minTime)/2;

            long tripsInMidTime = calculateTripsInTime(time, mid);

            if(tripsInMidTime>totalTrips){
                maxTime=mid-1;
            }else{
                minTime=mid;
            }
        }

        return minTime;

    }

    public long calculateTripsInTime(int[] time, long totalTime){
        long trips=0;
        for(int i: time){
            trips+=(totalTime/i);
        }

        return trips;
    }
}

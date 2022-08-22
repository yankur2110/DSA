class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        if(hour<= (double)(dist.length-1) ) return -1;

        int start = 1;
        int end = Integer.MAX_VALUE;

        //binary search to get the minSpeed.
        while(start<end){

            int mid=start+(end-start)/2;
            if(!isPossibleAtSpeed(dist, hour, mid)){
                start=mid+1;
            }else{
                end=mid;
            }
        }

        return start;
    }

    public boolean isPossibleAtSpeed(int[] distArray, double hourAllowed, int speed){

        int hourTaken=0;
        double actualHourTaken=0;
        for(int dist : distArray){
            //using another variable 'actualHourTaken' because we don't need to round off the last hour to integer value.
            actualHourTaken=hourTaken + (double)dist/(double)speed;

            hourTaken+=dist/speed;
            if(dist%speed!=0){
                hourTaken+=1;
            }
        }

        //check if totalHourRequired is less than or equal to allowed hours.
        return actualHourTaken<=hourAllowed;

    }
}

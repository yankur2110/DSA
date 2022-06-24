class Solution {
    public int maxDistToClosest(int[] seats) {
        int maxDistance = Integer.MIN_VALUE;
        int[] nearbyOccupiedSeatInLeft = new int[seats.length];
        int[] nearbyOccupiedSeatInRight = new int[seats.length];

        //initialize the first values for each of these arrays.
        nearbyOccupiedSeatInLeft[0]= seats[0]==1?0:Integer.MAX_VALUE;
        nearbyOccupiedSeatInRight[seats.length-1]= seats[seats.length-1]==1?0:Integer.MAX_VALUE;


        //find the distance of closest person sitting on left from the current seat.
        for(int i=1;i<seats.length;i++){
            if(seats[i]==1) nearbyOccupiedSeatInLeft[i]=0;
            else{
                nearbyOccupiedSeatInLeft[i]=nearbyOccupiedSeatInLeft[i-1]+1;
            }

        }
        //find the distance of closest person sitting on left from the current seat.
        for(int i=seats.length-2;i>=0;i--){
            if(seats[i]==1) nearbyOccupiedSeatInRight[i]=0;
            else{
                nearbyOccupiedSeatInRight[i]=nearbyOccupiedSeatInRight[i+1]+1;
            }
        }

        //go through each seat again and compare the min distance of person sitting on both sides.
        for(int i=0;i<seats.length;i++){
            if(seats[i]==1) continue;
            else{
                maxDistance = Math.max(maxDistance, Math.min(nearbyOccupiedSeatInLeft[i], nearbyOccupiedSeatInRight[i]));
            }
        }

        return maxDistance;
    }
}

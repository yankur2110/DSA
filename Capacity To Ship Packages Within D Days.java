class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0; //minimum capacity of boat should be the weight of heaviest package.
        int right = weights[weights.length-1];  //maximum capacity of boat we should consider i.e., sum of all packages.
        for(int individualPackageWeight : weights){
            left = Math.max(left, individualPackageWeight);
            right += individualPackageWeight;
        }

        //now apply the binary search to randomly pick the mid element as minimum weight capacity. Accordingly keep on discarding one half.
        int mid=0, currentWeightToBeShippedInABoat=0, numberOfDaysNeeded=0;
        while(left<right){
            mid = (left+right)/2;
            numberOfDaysNeeded=1;
            currentWeightToBeShippedInABoat=0;

            //for the randomly picked mid weight, find the number of days we would need to ship all the packages. If number of days required are more than given 'days' then we will increase the capacity i.e., left = mid +1 otherwise we will decrease the capactiy i.e., right = mid.

            for(int individualPackageWeight : weights){
                if (currentWeightToBeShippedInABoat + individualPackageWeight>mid){
                    currentWeightToBeShippedInABoat=0;
                    numberOfDaysNeeded+=1;
                }
                currentWeightToBeShippedInABoat+=individualPackageWeight;
            }

            if(numberOfDaysNeeded>days)
                left=mid+1;
            else
                right = mid;
        }

        return left;

    }
}

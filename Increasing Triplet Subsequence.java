class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        int currentSmall = Integer.MAX_VALUE;
        int currentBig = Integer.MAX_VALUE; 
        
        for(int num: nums){
            if(num<=currentSmall)
                currentSmall=num;
            else if(num<=currentBig)
                currentBig=num;
            else return true;
        }
        return false;
    }
}

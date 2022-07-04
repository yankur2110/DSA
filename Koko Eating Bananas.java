class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1, max = findMaxElement(piles);

        //simple binary search
        while(min<max){
            int mid = min + (max-min)/2;

            if(canFinishEatWithMidSpeed(piles, mid, h)){
                max=mid;
            }else{
                min=mid+1;
            }
        }
        return min;
    }

    //check if at speed k, all banana's can be eaten in h hours.
    public boolean canFinishEatWithMidSpeed(int[] piles, int k, int h){
        int hoursReqd=0;

        for(int pile : piles){
            hoursReqd += (pile/k);
            if(pile%k!=0)
                hoursReqd++;
        }

        return hoursReqd<=h;
    }

    //find the max limit.
    public int findMaxElement(int[] piles){
        int max=0;
        for(int i: piles){
            max=Math.max(i,max);
        }
        return max;
    }
}

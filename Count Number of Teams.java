class Solution {
    public int numTeams(int[] rating) {

        int total=0;
        //if for every element we know the number of elements which are less on left side and number of elements that are there on right side, then multiplication of these number would give the number of combination for the current element (ascending order).
        //likewise descending order.

        for(int i=1;i<rating.length-1;i++){
            int lessThanIOnleft=0, moreThanIOnLeft=0;
            int lessThanIOnRight=0, moreThanIOnRight=0;

            for(int j=0;j<i;j++){
                if(rating[j]<rating[i]){
                    lessThanIOnleft++;
                }else{
                    moreThanIOnLeft++;
                }
            }

            for(int j=i+1;j<rating.length;j++){
                if(rating[j]<rating[i]){
                    lessThanIOnRight++;
                }else{
                    moreThanIOnRight++;
                }
            }

            //this is the main logic part i.e., to get the number of ascending combinations possible with current number.. multiply (lessThanIOnleft)*(moreThanIOnRight), likewise for descending combinations.
            total+= (lessThanIOnleft)*(moreThanIOnRight) + (moreThanIOnLeft)*(lessThanIOnRight);
        }

        return total;
    }
}

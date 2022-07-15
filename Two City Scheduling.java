class Solution {
    public int twoCitySchedCost(int[][] costs) {

        int n=costs.length;
        //extra amount that person 'i' has to pay incase if he chooses city 'b' over 'a'. If it's positive it means extra amount has to be paid, if it's negative it means he will save that amount.
        //it will sorted in increasing order  i.e., first N should choose 'b' and last n should choose 'a'.
        Arrays.sort(costs, (a,b)->((a[1]-a[0])-(b[1]-b[0])));

        int minCost=0,j=0;
        for(int i=0;i<n/2;i++){
            j=(n-1)-i;
            minCost+= costs[i][1]+ costs[j][0];
        }

         return minCost;
    }
}

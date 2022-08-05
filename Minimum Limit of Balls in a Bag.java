class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int low =1, high = 1000000000;
        while(low<high){
            int mid = low+(high-low)/2; //chekcing for min penalty as mid.

            int reqdOp = 0; //operations we would require to make each bag contain atmost mid balls.
            for(int i : nums){
                reqdOp+=(i-1)/mid; //this is the trickliest part, not sure, how does it working.
            }

            if(reqdOp > maxOperations){ //if more operations are reqd, that means our min should be big.
                low=mid+1;
            }else{
                high=mid;
            }

        }

        return low;
    }
}

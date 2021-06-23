class Solution {
    /*
     Here note that this solution is not the most efficient in terms of space complexity, we are using 3 arrays here. We can use instead one array(prodBefore) -> and in the second loop instead of storing in prodAfter array and then computing the result in end, we can just take a varible which will store prodAfter that index. And in the second loop itself we can store the result.
    */
    public int[] productExceptSelf(int[] nums) {
        int[] prodBefore = new int[nums.length];
        int[] prodAfter = new int[nums.length];
        int[] result = new int[nums.length];
        prodBefore[0]=1; prodAfter[nums.length-1]=1;
        
        for(int i=1;i<nums.length;i++){
            prodBefore[i]=prodBefore[i-1]*nums[i-1];
        }
        for(int i=nums.length-2;i>=0;i--){
            prodAfter[i]=prodAfter[i+1]*nums[i+1];
        }
        
        for(int i=0;i<nums.length;i++){
            result[i]=prodBefore[i]*prodAfter[i];
        }
        return result;
    }
}

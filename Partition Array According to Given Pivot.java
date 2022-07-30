class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int lessThanEqualPivotCount = 0;
        int n=nums.length;
        int[] result = new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]<=pivot) lessThanEqualPivotCount++;
        }


        int largeIndex=lessThanEqualPivotCount;
        lessThanEqualPivotCount--;
        int start=0;
        for(int i=0;i<n;i++){
            if(nums[i]==pivot){
                result[lessThanEqualPivotCount--]=pivot;
            }else if(nums[i]>pivot){
                result[largeIndex++]=nums[i];
            }else{
                result[start++]=nums[i];
            }
        }

        return result;
    }


}

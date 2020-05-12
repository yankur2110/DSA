class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int elementAt=binarySearch(nums,target,0,nums.length-1);
        
        int[] result = new int[2];
        int start = elementAt;
        int end = elementAt;
        
        if(elementAt!= -1){
            
            for(int i = elementAt-1; i>=0; i--){
                if(nums[i]==nums[elementAt]){
                    start=i;
                }else{
                    break;
                }
            }
            
            for(int i= elementAt+1;i<nums.length;i++){
                if(nums[i]==nums[elementAt]){
                    end=i;
                }else{
                    break;
                }
            }
            
            result[0]=start;
            result[1]=end;
            
        }else{
            result[0]=-1;
            result[1]=-1;
        }
        
        return result;
                               
    }
    
    public int binarySearch(int[] nums, int target, int start, int end){
        
        if(start>end){
            return -1;
        }
        
        int mid=(start+end)/2;
        
        if(nums[mid]==target){
            return mid;
        }else if(target<nums[mid]){
            return binarySearch(nums,target,start,mid-1);
        }else{
            return binarySearch(nums,target,mid+1,end);
        }
    }
}
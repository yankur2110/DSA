class Solution {
    public int removeDuplicates(int[] nums) {
        
        int j=-1; //variable where next non-duplicate to be placed.
        boolean isInitialized = false;
        
        
        for(int i=1;i<nums.length;i++){
           
            while(i<nums.length && nums[i]==nums[i-1]){
                
                if(isInitialized==false){
                    j=i;
                    isInitialized = true;
                }
                
                i++;
            }
            
            if(i!=nums.length && isInitialized==true){
                nums[j]=nums[i];
                j++;
            }
            
        }
        
        if(isInitialized){
            return j;
        }
        else
            return nums.length;
    }
}
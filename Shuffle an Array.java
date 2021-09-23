class Solution {
    int[] originalArray;

    public Solution(int[] nums) {
        this.originalArray = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return originalArray;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] arr = originalArray.clone();
        
        for(int i=1;i<arr.length;i++)
            swap(arr,new Random().nextInt(i+1),i);
        
        return arr;
        
    }
    
    public void swap (int[] arr, int i, int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */

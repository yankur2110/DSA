class Solution {
    public void nextPermutation(int[] nums) {

        //this solution was accepted but I've taken the unnecessary stack. We can optimize it by just taking a variable.
        Stack<Integer> stack = new Stack<>();
        int i=0;
        for(i=nums.length-1;i>=0;i--){
            if((!stack.isEmpty() && nums[i]>=stack.peek()) || stack.isEmpty()) {
                stack.push(nums[i]);
            }else{
                break;
            }
        }

        if(i==-1){
            //reverse the order in case it's already the max number from numbers possible.
            for(int l=0;l<nums.length/2;l++){
                int k = nums.length-1-l;
                int temp = nums[l];
                nums[l]=nums[k];
                nums[k]=temp;
            }
            return;
        }

        List<Integer> integersToBePlacedCorrectly = new ArrayList<>();
        for(int k=nums.length-1;k>=0;k--){
            if(nums[k]>nums[i]){
                int temp = nums[i];
                nums[i]=nums[k];
                nums[k]=temp;
                break;
            }
        }
        i++;

        for(int k=i;k<=nums.length-1;k++){
            integersToBePlacedCorrectly.add(nums[k]);
        }

        for(int j=integersToBePlacedCorrectly.size()-1;j>=0;j--){
            nums[i]=integersToBePlacedCorrectly.get(j);
            i++;
        }

        return;

    }
}

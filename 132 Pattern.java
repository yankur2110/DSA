class Solution {
    public boolean find132pattern(int[] nums) {
       int[] minArray = new int[nums.length];
       minArray[0] = nums[0];

        //set the minimum values present at left, including that index in minArray.
        for(int i=1; i<nums.length; i++){
            minArray[i] = Math.min(minArray[i-1],nums[i]);
        }

        //stack to find the '2' in '132' pattern.
        Stack<Integer> potential2ElementsStack = new Stack<>();

        //for loop check considers every element from end to start as '3' of '132' pattern.
        for(int i=nums.length-1;i>=1;i--){

            if(nums[i]>minArray[i]){ //if current element is greater than minArray[i], then only proceed.

                //pop the elements from stack (right elements from the current index), till the time it's smaller than or equal to the minArray[i].
                while(!potential2ElementsStack.isEmpty() && potential2ElementsStack.peek()<=minArray[i]){
                    potential2ElementsStack.pop();
                }

                //check with the top element of the stack to see if we found the pattern.
                if(!potential2ElementsStack.isEmpty() && potential2ElementsStack.peek()<nums[i]){
                    return true;
                }

                //if not, then push the current element to stack, because this element which we were considering to be '3' of 132, might be '2' or later potential pattern.
                potential2ElementsStack.push(nums[i]);

            }

        }

        return false;
    }
}

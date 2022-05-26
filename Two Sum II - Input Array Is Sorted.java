class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0, j=numbers.length-1;
        int[] resultArray = new int[]{}; //resultArray which will have size of 2.

        while(i<j){

            int currentSum = numbers[i]+numbers[j];

            if(currentSum<target){
                //increment the start pointer.
                i++;
            }else if(currentSum>target){
                //decrement the end pointer.
                j--;
            }else{
                resultArray = new int[]{i+1, j+1}; //since result has to be 1-indexed.
                break;
            }
        }

        return resultArray;
    }
}

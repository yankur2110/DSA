class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> resultList = new ArrayList<>();


        //whenever you find a number1, flip the number2 at that index (number1-1) to negative.
        for(int i=0;i<nums.length;i++){
            //since nums[i] can be negative due to our changes.
            int index = Math.abs(nums[i])-1;

            //if the element at that index is negative, it means number i.e., Math.abs(index)+1 is repeated.
            if (nums[index] < 0)
                resultList.add(Math.abs(index+1));

            //change the number to negative, when duplicate will be processed it would turn to positive again but that doesn't mean to us.
            nums[index] = -nums[index];
        }

        return resultList;
    }
}

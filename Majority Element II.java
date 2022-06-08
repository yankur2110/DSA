class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //since at max, two such elements can be there we would try to find them in val1, val2.
        //count1 and count2 are just useful for Moore's Voting Algorithm, it doesn't have actual count in it.
        int val1=nums[0], val2=nums[0], count1=0, count2=0;

        //iterate through the array.
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val1) count1++; //if current is element is equal to assumed ME then increment respective count.
            else if(nums[i]==val2) count2++;
            else if(count1==0 || count2==0){ //if we have a slot for new potential ME, then assign current element as ME and increment the count to 1.
                if(count1==0){
                    val1=nums[i];
                    count1=1;
                }else{
                    val2=nums[i];
                    count2=1;
                }
            }else{ //if it's a new element but stil out potential elements occur more than any other element in array.
                count1--;
                count2--;
            }
        }

        //now we calculate the actual occurrences of two potential candidates i.e., val1 and val2 in the array.
        List<Integer> resultList = new ArrayList<>();
        count1=0;count2=0; //reuse the same variables.
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val1) count1++;
            else if(nums[i]==val2) count2++;
        }

        if(count1>nums.length/3) resultList.add(val1); //if their occurrences is >n/3.
        if(count2>nums.length/3) resultList.add(val2);

        return resultList;
    }
}

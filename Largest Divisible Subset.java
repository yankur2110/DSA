class Solution {
    List<Integer> resultList = new ArrayList<>();
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums.length==1) return Collections.singletonList(nums[0]);

        //sort the array so that we just need to check b%a (where b's position > a's position) to check if both are divisible pair or not.
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n]; //actual dp array. DP[i] tells us the longest divisible subset ending at i.
        int[] previousIndexInLongestDivisibleSubSet = new int[n]; //at each of the respective index, it stores the index of previous element (in that longest divisible subset ending at i).

        int maxLengthOfSubset = 0;
        int firstIndexOfMaxLengthSubset = -1;

        for(int i=0;i<nums.length;i++){
            dp[i]=1;
            previousIndexInLongestDivisibleSubSet[i]=-1;

            for(int j=i-1;j>=0;j--){ //simply check all the possible subsets.

                if(nums[i]%nums[j]==0 && dp[i]<dp[j]+1){ //if any previous number divides the current number and number of already existing subsets are less than update dp[i].
                    dp[i]=dp[j]+1;
                    previousIndexInLongestDivisibleSubSet[i]=j; //also update the previous element included in that subset.
                }
            }

            if(dp[i]>maxLengthOfSubset){ //check with maxLength of subset found so far.
                maxLengthOfSubset=dp[i];
                firstIndexOfMaxLengthSubset=i; //find the starting index.
            }
        }

        while(firstIndexOfMaxLengthSubset!=-1){ //till the time we didn't find the first element.. we continue adding to the list.
        //also note that firstIndexOfMaxLengthSubset would always be not equals to 1 even in case only 1 element is there in the nums array.. i.e., this will be executed at least once.
            resultList.add(nums[firstIndexOfMaxLengthSubset]);
            firstIndexOfMaxLengthSubset=previousIndexInLongestDivisibleSubSet[firstIndexOfMaxLengthSubset];
        }

       return resultList;

    }
}

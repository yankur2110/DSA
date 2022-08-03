class Solution {
    public int waysToMakeFair(int[] nums) {
        int n=nums.length, sum=0, oddSum=0, evenSum=0;
        int[] oddSuffixSum = new int[n+2];
        int[] evenSuffixSum = new int[n+2];

        for(int i=n-1;i>=0;i--){
            if(i%2!=0){
                oddSuffixSum[i]=nums[i]+oddSuffixSum[i+2];
                oddSum+=nums[i];
            }else{
                evenSuffixSum[i]=nums[i]+evenSuffixSum[i+2];
                evenSum+=nums[i];
            }
            sum+=nums[i];
        }

        int count=0, newOddSum=0, newEvenSum=0, oddSumBeforeI=0, evenSumBeforeI=0;

        for(int i=0;i<n;i++){
            if(i%2==0){ //calculate the odd and even sum before I.
                oddSumBeforeI = oddSum-oddSuffixSum[i+1];
                evenSumBeforeI = evenSum - evenSuffixSum[i];
            }else{
                oddSumBeforeI = oddSum-oddSuffixSum[i];
                evenSumBeforeI = evenSum - evenSuffixSum[i+1];
            }

            if(i%2==0){ //if removing the even index.
                newEvenSum=oddSuffixSum[i+1];
                newOddSum=evenSuffixSum[i]-nums[i];
            }else{ //if removing the odd index.
                newOddSum=evenSuffixSum[i+1];
                newEvenSum=oddSuffixSum[i]-nums[i];
            }

            newOddSum += oddSumBeforeI;
            newEvenSum += evenSumBeforeI;

            if(newOddSum==newEvenSum){
                count++;
            }
        }

        return count;
    }
}

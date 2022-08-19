class Solution {
    public int minimumOperations(int[] nums) {
        HashMap<Integer, Integer> oddFreqMap = new HashMap<>();
        HashMap<Integer, Integer> evenFreqMap = new HashMap<>();
        int oddNums=0, evenNums=0;
        int maxOddFreq1=0, maxOddFreq2=0, maxEvenFreq1=0, maxEvenFreq2=0;
        int maxOddFreq1Num=0, maxOddFreq2Num=0, maxEvenFreq1Num=0, maxEvenFreq2Num=0;

        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                evenNums++;
                evenFreqMap.put(nums[i], evenFreqMap.getOrDefault(nums[i],0)+1);
            }else{
                oddNums++;
                oddFreqMap.put(nums[i], oddFreqMap.getOrDefault(nums[i],0)+1);
            }
        }

        //set max2 frequency of even index elements.
        for(int num : evenFreqMap.keySet()){
            int freqOfNum = evenFreqMap.get(num);
            if(freqOfNum>=maxEvenFreq1){
                maxEvenFreq2 = maxEvenFreq1;
                maxEvenFreq2Num = maxEvenFreq1Num;

                maxEvenFreq1 = freqOfNum;
                maxEvenFreq1Num = num;
            }else if(freqOfNum>maxEvenFreq2){
                maxEvenFreq2 = freqOfNum;
                maxEvenFreq2Num = num;
            }
        }

        //set max2 frequency of odd index elements.
        for(int num : oddFreqMap.keySet()){
            int freqOfNum = oddFreqMap.get(num);
            if(freqOfNum>=maxOddFreq1){
                maxOddFreq2 = maxOddFreq1;
                maxOddFreq2Num = maxOddFreq1Num;

                maxOddFreq1 = freqOfNum;
                maxOddFreq1Num = num;
            }else if(freqOfNum>maxOddFreq2){
                maxOddFreq2 = freqOfNum;
                maxOddFreq2Num = num;
            }
        }


        if(maxOddFreq1Num==maxEvenFreq1Num){
            int poss1 = evenNums + oddNums - maxOddFreq2 - maxEvenFreq1;
            int poss2 = evenNums + oddNums - maxOddFreq1 - maxEvenFreq2;
            return Math.min(poss1, poss2);
        }

        return evenNums + oddNums - maxOddFreq1 - maxEvenFreq1;

    }
}

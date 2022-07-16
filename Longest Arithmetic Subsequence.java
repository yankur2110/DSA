class Solution {
    public int longestArithSeqLength(int[] nums) {
        int longestAS=2;
        int n=nums.length;
        //generally in subsequence problems we take the int[] dp array and to fill the current index in dp i.e., dp[i], we iterate through previous elements and see if desired subsequence is there then we add.
        //however here, subsequence doesn't has the dependency on just the last element but on previous elements as well, hence we would use a hashmap which would store the previous records using hashmap i.e., at each index of dp array we would store a hashmap which would represent the number of elements (of AS) we have found till that index for any distance encountered so far for the current element.
        HashMap<Integer, Integer> mapOfDistToCountAtThatIndex = new HashMap<>();
        HashMap<Integer, Integer>[] arrOfMap = new HashMap[n];

        for(int i=0;i<n;i++){
            arrOfMap[i] = new HashMap<>();
            for(int j=0;j<i;j++){
                int d=nums[i]-nums[j];
                arrOfMap[i].put(d, arrOfMap[j].getOrDefault(d,1)+1);
                longestAS=Math.max(longestAS, arrOfMap[i].get(d));
            }
        }

        return longestAS;
    }
}

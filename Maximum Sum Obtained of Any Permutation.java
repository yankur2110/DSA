class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int[] freqOfIndicesInRequests = new int[nums.length];

        for(int[] range : requests){
            int start = range[0];
            int end = range[1]+1; //we need to add 1 because till range[1] we are including the index. We start excluding index from rage[1]+1.
            freqOfIndicesInRequests[start]++;

            if(end<nums.length) //since 1 is added, it might go out of bound.
                freqOfIndicesInRequests[end]--;
        }

        //as of now freqOfIndicesInRequests array represents the number of new requests starting at any index.
        //if the value is negative, it means one of the request is ending at this index.
        //so to count the actual number of inclusions of an index, we need to add the existing number of times the index is included + new range starting from here.
        for(int i=1;i<nums.length;i++){
            freqOfIndicesInRequests[i]+=freqOfIndicesInRequests[i-1];
        }

        Arrays.sort(freqOfIndicesInRequests);
        Arrays.sort(nums);

        long result=0;
        int mod = (int)1e9+7;
        for(int i=0;i<nums.length;i++){
            long val = (long)nums[i]*(long)freqOfIndicesInRequests[i];
            result+=val;
        }

        return (int)(result%mod);
    }
}

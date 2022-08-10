class Solution {
    public int maximumProduct(int[] nums, int k) {
        int mod = (int) 1e9+7;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i:nums) pq.add(i);

        while(k-->0){
            pq.add(pq.poll()+1);
        }

        long maxProd=1;
        while(!pq.isEmpty()){
            maxProd=(maxProd*pq.poll())%mod;
        }

        return (int)maxProd%mod;
    }
}

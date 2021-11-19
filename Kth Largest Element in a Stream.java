class KthLargest {
    
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    int K=0;
    boolean firstInsert = true;

    public KthLargest(int k, int[] nums) {
        K=k;
        for(int i:nums){
            minHeap.add(i);
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        int size = minHeap.size();
        
        while(size!=K){
            minHeap.poll();
            size--;
        }
    
        return minHeap.peek();
        
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

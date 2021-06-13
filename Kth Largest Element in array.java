class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i: nums){
            maxHeap.add(i);
        }
        for(int i=1;i<k;i++){
            maxHeap.remove();
        }
        return maxHeap.remove();
    }
}

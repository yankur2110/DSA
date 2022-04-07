class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); //create maxHeap.
        for(int i:stones) maxHeap.offer(i); //add all elements to maxHeap.

        while(maxHeap.size()>1){ //till the time more than one stones are there, keep on smashing.
            maxHeap.offer(maxHeap.poll()-maxHeap.poll());
        }

        return maxHeap.poll(); //return the last stone weight that's there in the maxHeap.
    }
}

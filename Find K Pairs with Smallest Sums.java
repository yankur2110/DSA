class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        //initialize resultList.
        List<List<Integer>> resultList = new ArrayList<>();
        if(nums1.length==0 || nums2.length==0 || k==0) return resultList;

        //define priorityQueue.
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
        (a,b)  -> (a[0]+a[1])-(b[0]+b[1])
        );

        //put all nums1 elements with nums2[0] combination to heap.
        for(int i=0;i<nums1.length && i<k;i++){
            minHeap.offer(new int[]{nums1[i], nums2[0], 0});
        }

        //get the first k min sum pairs.
        while(k-->0 && !minHeap.isEmpty()){

            //poll() the element.
            int[] currMinPair = minHeap.poll();
            List<Integer> currPair = new ArrayList<>();

            currPair.add(currMinPair[0]);
            currPair.add(currMinPair[1]);
            resultList.add(currPair);

            //check if it's the last element of nums2.
            if(currMinPair[2]==nums2.length-1) continue;

            //store the next min pair possibility i.e., (i, j+1) and also the index of nums2 i.e., j+1.
            minHeap.offer(new int[]{currMinPair[0], nums2[currMinPair[2]+1],currMinPair[2]+1});
        }

        return resultList;

    }
}

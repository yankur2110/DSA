class Solution {
    public int maximumScore(int a, int b, int c) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        maxHeap.add(a); maxHeap.add(b); maxHeap.add(c);

        int score=0;
        while(maxHeap.size()>1){
            int max1 = maxHeap.poll();
            int max2 = maxHeap.poll();

            max1--; max2--;
            if(max1>0) maxHeap.offer(max1);
            if(max2>0) maxHeap.offer(max2);
            score++;
        }

        return score;

    }
}

class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());

        double sum=0;
        //add all elements to priority queue.
        for(int i: nums){
            pq.add((double)i);
            sum+=i;
        }

        double currSum=sum;
        double reqdSum=sum/2;

        int k=0;

        while(currSum>reqdSum){
            double polledNum = (double)pq.poll();
            double newNum = polledNum/2;
            currSum-=newNum;

            pq.add(newNum);
            k++;
        }

        return k;

    }
}

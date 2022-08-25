class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Double.compare(profitDiff(b),profitDiff(a)));

        for(int[] classs: classes){
            pq.add(classs);
        }

        while(extraStudents-->0){
            int[] polledClass = pq.poll();
            pq.add(new int[]{polledClass[0]+1, polledClass[1]+1});
        }

        double result =0.0;
        while(!pq.isEmpty()){
            int[] polledClass = pq.poll();

            result +=((double)polledClass[0]/(double)polledClass[1]);
        }

        return result/classes.length;
    }

    private double profit(double a, double b) {
        return a / b;
    }

    private double profitDiff(int[] p) {
        return profit(p[0] + 1, p[1] + 1) - profit(p[0], p[1]);
    }
}

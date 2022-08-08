class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: arr){
            map.put(i, map.getOrDefault(i,0)+1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> (a[1]-b[1]));

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.add(new int[]{entry.getKey(), entry.getValue()});
        }

        while(k-->0){
            int[] poll = pq.poll();
            if(poll[1]>1){
                pq.add(new int[]{poll[0], poll[1]-1});
            }
        }

        return pq.size();
    }
}

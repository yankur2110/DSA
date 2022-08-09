class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i:arr){
            map.put(i, map.getOrDefault(i,0)+1);
        }

        PriorityQueue<int[]> p_que = new PriorityQueue<>((a,b)->(b[1]-a[1]));
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            p_que.add(new int[]{entry.getKey(), entry.getValue()});
        }

        int result=0;
        int remaining = arr.length;

        while(remaining>arr.length/2){
            int[] poll = p_que.poll();
            remaining-=poll[1];
            result++;
        }

        return result;
    }
}

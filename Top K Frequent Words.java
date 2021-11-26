class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        Map<String, Integer> map = new HashMap<>();
        for(String str: words){
            map.put(str, map.getOrDefault(str,0)+1);
        }
        
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>(
        
        (elem1,elem2) -> 
            elem1.getValue()==elem2.getValue()?elem2.getKey().compareTo(elem1.getKey()):elem1.getValue()-elem2.getValue()
        );
        
         for(Map.Entry<String, Integer> entry: map.entrySet())
        {
            pq.offer(entry);
            if(pq.size()>k)
                pq.poll();
        }

        List<String> result = new LinkedList<>();
        while(!pq.isEmpty())
            result.add(0, pq.poll().getKey());
        
        return result;
        
    }
}

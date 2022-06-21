class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        //count frequency of characters in a map.
        for(char ch : s.toCharArray()){
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0)+1);
        }

        //define a pq, which will sort the values based on Map.Entry's value.
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b)-> b.getValue()-a.getValue());

        //add all elements of map to priority_queue.
        pq.addAll(charCountMap.entrySet());

        StringBuilder sb = new StringBuilder();

        //traverse the whole priority_queue.
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> entry = pq.poll();
             for (int i = 0; i < (int)entry.getValue(); i++)
                sb.append(entry.getKey());
        }

        //return string.
        return sb.toString();
    }
}

class Solution {
    public int[] findOriginalArray(int[] changed) {
        int len = changed.length, k=0;
        if(len%2!=0) return new int[0];
        int[] result = new int[len/2];


        Map<Integer,Integer> freqMap = new TreeMap<>();

        for(int i:changed){
            freqMap.put(i, freqMap.getOrDefault(i,0)+1);
        }

        for(int key : freqMap.keySet()){
            if(freqMap.get(key)>freqMap.getOrDefault(2*key,0)) return new int[0];

            for(int j = 0; j < freqMap.get(key); j++) {
                result[k++] = key;
                freqMap.put(2*key, freqMap.get(2*key) - 1);
            }
        }

        return result;
    }
}

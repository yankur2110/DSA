class LFUCache {

    int capacity = 0;
    int currentMinFreq=0;
    HashMap<Integer, Integer> keyToValueMap;
    HashMap<Integer, Integer> keyToFrequencyMap;
    HashMap<Integer, LinkedHashSet<Integer>> freqToElementsKeysMap;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        keyToValueMap = new HashMap<>();
        keyToFrequencyMap = new HashMap<>();
        freqToElementsKeysMap = new HashMap<>();
        freqToElementsKeysMap.put(1, new LinkedHashSet<Integer>()); //GOT THIS. NOTHING LOGICAL HERE.
    }
    
    public int get(int key) {
        if(!keyToValueMap.containsKey(key))
            return -1;
        
        //increment the frequency of key.
        int freq = keyToFrequencyMap.get(key);
        keyToFrequencyMap.put(key, freq+1);
        
        //since the mapping of freqToElementsMap would've changed, do the changes.
        LinkedHashSet<Integer> linkedHS = freqToElementsKeysMap.get(freq);
        linkedHS.remove(key);
        
        //GOT THIS NOW.
        if(freq==currentMinFreq && freqToElementsKeysMap.get(freq).size()==0)
            currentMinFreq++;
        
        linkedHS = freqToElementsKeysMap.get(freq+1);
        if(linkedHS==null){
            linkedHS = new LinkedHashSet<Integer>();
        }
        linkedHS.add(key);
        freqToElementsKeysMap.put(freq+1, linkedHS);
        
        return keyToValueMap.get(key);
    }
    
    public void put(int key, int value) {
        
        if(capacity<=0)
            return;
        
        //if already key is present, we need to update the value, and rest operation is like the get(key) only.
        if(keyToValueMap.containsKey(key)){
            keyToValueMap.put(key, value);
            get(key);
            return;
        }
        
        //if noOfElements in hashmap are at capacity, remove the least frequent -> Lru from 2 maps i.e., other than freqMap.
        if(keyToValueMap.size()>=capacity){
            int keyToRemove = freqToElementsKeysMap.get(currentMinFreq).iterator().next();
            freqToElementsKeysMap.get(currentMinFreq).remove(keyToRemove);
            keyToValueMap.remove(keyToRemove);
        }
        
        //since we are inserting a new element, and that element is not already present, minCurrFrequency would be 1 only.
        keyToValueMap.put(key,value);
        keyToFrequencyMap.put(key,1);
        currentMinFreq = 1;
        freqToElementsKeysMap.get(1).add(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
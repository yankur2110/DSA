class LRUCache {

    int capacity;
    int currentSize = 0;

    HashMap<Integer, Integer> map = new HashMap<>();

    LinkedList<Integer> queue = new LinkedList<>();


    public LRUCache(int capacity) {
        this.capacity=capacity;

    }

    public int get(int key) {
        if(map.get(key)==null)
            return -1;
        queue.remove((Integer) key);
        queue.add(key);
        return map.get(key);
    }

    public void put(int key, int value) {

        if(map.get(key)!=null){
            queue.remove((Integer)key);
            queue.add(key);
            map.put(key,value);
            return;
        }

        if(currentSize>=capacity){
            //need to pull key of least recently used pair.
            map.remove(queue.remove());
            currentSize--;
        }

        queue.add(key);
        map.put(key,value);
        currentSize++;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
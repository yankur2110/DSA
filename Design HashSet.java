class MyHashSet {
    List<Integer>[] hashArray;
    int capacity = 0;
    public MyHashSet() {
        capacity = 1500;
        hashArray = new List[capacity];
    }

    //very basic hash function.
    private int getHash(int key){
        return key%capacity;
    }

    //add to the linkedlist present at 'hash' index of array.
    public void add(int key) {
        int hash = getHash(key);
        if(hashArray[hash]==null){
            hashArray[hash]= new LinkedList<Integer>();
        }

        if(!hashArray[hash].contains(key)){
            hashArray[hash].add(key);
        }
    }

    //remove the key if it exists.
    public void remove(int key) {
        if(contains(key)){
            int hash = getHash(key);
            hashArray[hash].remove(hashArray[hash].indexOf(key));
        }
    }

    public boolean contains(int key) {
        int hash = getHash(key);
        return (hashArray[hash]!=null && hashArray[hash].indexOf(key)!=-1)?true:false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

class RandomizedSet {
    List<Integer> list;
    Map<Integer,Integer> map;
    java.util.Random rand = new java.util.Random();
    
    /** Initialize your data structure here. */
    public RandomizedSet() {

        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        
        list.add(val);
        map.put(val,list.size()-1);
        return true;
        
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        int index = map.get(val);
        int lastValueInList = list.get(list.size()-1);
        map.put(lastValueInList,index);
        list.set(index,lastValueInList);
        
        map.remove(val);
        list.remove(list.size()-1);
        return true;
        
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return  list.get( rand.nextInt(list.size()) );
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

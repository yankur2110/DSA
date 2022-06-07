class MyCalendar {

    TreeMap<Integer, Integer> treeMap = null;
    public MyCalendar() {
        treeMap = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer floorKey = treeMap.floorKey(start); //check the floor key.
        Integer floorValue = null;
        if(floorKey!=null) //if exists, then find the the value against it.
            floorValue = treeMap.get(floorKey);

        Integer ceilingKey = treeMap.ceilingKey(start); //check for the ceiling key.

        //here we checking the value against the floorKey and checking if it is greater than start.
        //likewise for ceiling key, we are checking if that key is less than the end. In both condition it's a overlap, return false.
        if( (floorKey!=null && floorValue>start) || (ceilingKey!=null && ceilingKey<end)) return false;

        treeMap.put(start,end); //insert into the map if it's not a overlap case.
        return true;

    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */

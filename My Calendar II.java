class MyCalendarTwo {

    //map to store the count of event starting or ending at a time.
    TreeMap<Integer, Integer> eventStartEndMap;
    public MyCalendarTwo() {
        eventStartEndMap = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        eventStartEndMap.put(start, eventStartEndMap.getOrDefault(start,0)+1); //represents a new event starting.
        eventStartEndMap.put(end, eventStartEndMap.getOrDefault(end,0)-1); //represents an event ending.

        int count = 0; //represents the concurrent event happening.

        for(Map.Entry<Integer, Integer> mapEntry : eventStartEndMap.entrySet()){ //goThrough the map. Since it's a treemap we will be going in ascending order.

            count+=mapEntry.getValue();

            if(count>2){
                //remove the current booking because it is causing overlapping and thus not possible.
                eventStartEndMap.put(start, eventStartEndMap.get(start)-1);
                eventStartEndMap.put(end, eventStartEndMap.get(end)+1);
                return false;
            }

        }

        return true;

    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */

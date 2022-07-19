class TimeMap {
    Map<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            map.get(key).put(timestamp, value);
        }else{
            TreeMap<Integer, String> internalMap =new TreeMap<>();
            internalMap.put(timestamp, value);
            map.put(key,internalMap);
        }
    }

    public String get(String key, int timestamp) {
        if(map.containsKey(key)){
            if(map.get(key).floorKey(timestamp)!=null){
                int floorKey = map.get(key).floorKey(timestamp);
                return map.get(key).get(floorKey);
            }else{
                return "";
            }
        }else{
            return "";
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

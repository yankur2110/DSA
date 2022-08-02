class RangeFreqQuery {

    //for every integer value of arr, following map stores a treemap.
    //treemap has the information:
        //Key: till an index, Value: number of times that value of arr has appeared.
    Map<Integer, TreeMap<Integer, Integer>> map = new HashMap<>();
    public RangeFreqQuery(int[] arr) {
        for(int i=0;i<arr.length;i++){
            map.putIfAbsent(arr[i], new TreeMap<Integer, Integer>());
            int freqOfArrItillNow = map.get(arr[i]).size(); //since we are storing the count at whichever index a val is appearing. Map.get(arr[i]).size() would give the number of times it has occurred till now, including current.
            TreeMap<Integer, Integer> treeMapForArrI = map.get(arr[i]);
            treeMapForArrI.put(i,freqOfArrItillNow+1);
        }
    }

    public int query(int left, int right, int value) {
        if(!map.containsKey(value)) return 0;

        TreeMap<Integer, Integer> treeMapForValue = map.get(value);

        //check if there exist val after left and before right.
        if(treeMapForValue.ceilingKey(left)==null || treeMapForValue.floorKey(right)==null){
            return 0;
        }

        //now we are sure there exists value in this range. Now we will count the frequency.
        int tillLeft = treeMapForValue.get(treeMapForValue.ceilingKey(left));
        int tillRight = treeMapForValue.get(treeMapForValue.floorKey(right));
        System.out.println("tillLeft for "+left+" is "+tillLeft);
        System.out.println("tillRight for "+right+" is "+tillRight);
        return tillRight-tillLeft+1; //not satisfied why we are adding 1 though.
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> endValToIndexMap = new TreeMap<>();

        for(int i=0; i<intervals.length; i++){
            int[] interval = intervals[i];
            endValToIndexMap.put(interval[0],i);
        }


        int[] result = new int[intervals.length];
        int i=0;
        for(int[] interval : intervals){

            result[i++] = (endValToIndexMap.ceilingKey(interval[1])!=null)?  endValToIndexMap.get(endValToIndexMap.ceilingKey(interval[1]))  :-1;
        }

        return result;
    }
}

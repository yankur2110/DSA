class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> resultList = new ArrayList<>();

        int i=0;
        //simply skip the elements if new interval's start > existing interval's end.
	    while (i < intervals.length && intervals[i][1] < newInterval[0]){
	        resultList.add(intervals[i]);
	        i++;
	    }

        //till the time end of new interval is greater or equal to the start of ith interval.
        while(i<intervals.length && intervals[i][0]<=newInterval[1]){
	        newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
	        newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // add the union of intervals we got
	    resultList.add(newInterval);

        // add all the rest
	    while (i < intervals.length){
	    	resultList.add(intervals[i]);
	    	i++;
	    }

        //convert to 2D array.
	    return resultList.toArray(new int[resultList.size()][]);
    }
}

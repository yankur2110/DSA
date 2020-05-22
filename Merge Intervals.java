class Solution {
    public int[][] merge(int[][] intervals) {
        
        //wow you will learn how to use lambda function to implement comparator.
        //video ref: https://www.youtube.com/watch?v=yb46iD5dJYY
        //https://www.java67.com/2014/11/java-8-comparator-example-using-lambda-expression.html
        //here you will learn how to convert List into 2d array as well.
        
        
        if(intervals.length<=1)
            return intervals;
        
        Arrays.sort(intervals, (arr1,arr2)-> arr1[0]-arr2[0]);
                    
        List<int[]> resultList = new ArrayList<int[]>();
        int[] tempArray = new int[2];
        tempArray[0]= intervals[0][0];
        tempArray[1]=intervals[0][1];
        int i;
                    
        for( i=1;i<intervals.length;i++){
            if(tempArray[1]>=intervals[i][0]){
                tempArray[1]=Math.max(tempArray[1],intervals[i][1]);
            }
            else{
                resultList.add(tempArray);
                tempArray = new int[2];
                tempArray[0]= intervals[i][0];
                tempArray[1]=intervals[i][1];
                
            }
            
        }
            if(tempArray[1]!=intervals[i-1][1] && intervals[i-1][1]>tempArray[1]){ /*for case[[1,4],[2,3]]*/
                tempArray[0]=intervals[i-1][0];
                tempArray[1]=intervals[i-1][1];
            }
                resultList.add(tempArray);
                return resultList.toArray(new int[resultList.size()][]);
                
        
    }
}
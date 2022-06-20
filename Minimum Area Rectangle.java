class Solution {
    public int minAreaRect(int[][] points) {
        HashMap<Integer, HashSet<Integer>> mapOfXtoYCoordinates = new HashMap<>();

        //Store the y coordinates of points against key x in a hashmap for fast loop of points.
        for(int[] point : points ){
            if(!mapOfXtoYCoordinates.containsKey(point[0])){
                HashSet<Integer> set = new HashSet<>();
                mapOfXtoYCoordinates.put(point[0], set);
            }
            mapOfXtoYCoordinates.get(point[0]).add(point[1]);
        }

        int minArea = Integer.MAX_VALUE;
        int x1=0, y1=0, x3=0, y3=0;

        for(int[] point1 : points)
            for(int[] point2 : points){
                x1= point1[0]; y1= point1[1];
                x3= point2[0]; y3= point2[1];

                if(x1==x3 || y1==y3) continue; //if x or y coordinates are equal then they cannot form the diagonal of rectangle.
                //check if other two diagonal points(if exists) are forming the desired rectangle.
                if(mapOfXtoYCoordinates.get(x1).contains(y3) && mapOfXtoYCoordinates.get(x3).contains(y1)){
                    minArea = Math.min(minArea, Math.abs(x3-x1)*Math.abs(y3-y1));
                }

            }

        //in case if desired rectangle is not present in the given array of points.
        return minArea == Integer.MAX_VALUE? 0: minArea;

    }
}

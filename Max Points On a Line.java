/*
	Description: pointsOnSameLine is a recursive function which return List<HashMap<>> where each hashmap contains the the coordinate of points lying on the same line.
	
	NOTES:
1. 	Double value taken to precisely get the slope.
2. 	Point Class (with overriden equals method) is used as a key in hashmap, so that two points having same x-coordinate but different y-coordinate can be stored in hashmap.
3. 	BASE CONDITION IN RECURSIVE FUNCTION: when we are at the last index of array of coordinates, store this in a hashmap and return;
4. 	LOGIC: we have List<HashMap<>>, where each hashmap has all points lying on same line. So, we iterate through this list -> for each hashmap, we first find the slope of the current line.. then check if the new point is having the same slope with all points in that line. If Yes, we add into that hashmap.. Also we add this coordinate as a new hashmap in List because, there may be a case where largest line might be passing through this coordinate and not the existing lines.
	
*/

class Solution {

    class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x=x;
            this.y=y;
        }

        public boolean Equals(Object obj){
            Point point = (Point)obj;
            if(point.x==this.x && point.y==this.y){
                return true;
            }
            return false;
        }
    }

    public int maxPoints(int[][] points) {
        int max =0;


        List<HashMap<Point, Integer>> listOfPointsInStraightLine = pointsOnSameLine(points,0);

        //Hashmap with most elements is the required line.. So, will return it's size.
        for(HashMap<Point,Integer> map : listOfPointsInStraightLine){
            if(map.size()>=max)
                max=map.size();
        }
        return max;
    }

    List<HashMap<Point, Integer>> pointsOnSameLine(int[][] points, int index){


        if(points.length -1 == index){
            HashMap<Point, Integer> mapOfPointsInLine = new HashMap<>();
            mapOfPointsInLine.put(new Point (points[index][0],points[index][1]),points[index][1]);
            List<HashMap<Point, Integer>> listOfPointsInStraightLine = new ArrayList<>();
            listOfPointsInStraightLine.add(mapOfPointsInLine);
            return listOfPointsInStraightLine;

        }

        List<HashMap<Point, Integer>> listOfPointsInStraightLine = pointsOnSameLine(points,index+1);

        int x_cord = points[index][0];
        int y_cord = points[index][1];
        List<Integer> listOfSinglePoints = new ArrayList<>();

        for(HashMap<Point,Integer> map : listOfPointsInStraightLine){


            if(map.size()>=2){

                double slope=0;
                int count=0;
                int flag=0;
                int x=0,y=0;

                for (Point k : map.keySet()){
                    int v =map.get(k);
                    if(count==0){
                        x=k.x;
                        y=v;
                        count++;
                    }else if(count==1){
                        if(k.x-x==0){
                            slope=Integer.MAX_VALUE;
                        }else{
                            slope = Math.abs(((double)v-(double)y)/((double)k.x-(double)x));
                        }
                        break;
                    }


                };

                for (Point k : map.keySet()){
                    int v =map.get(k);
                    double currSlope =0;
                    if(k.x-x_cord==0){
                        currSlope=Integer.MAX_VALUE;
                    }else{
                        currSlope = Math.abs(((double)v-(double)y_cord)/((double)k.x-(double)x_cord));
                    }


                    if(currSlope!=slope){
                        flag=1;
                        break;
                    }

                };

                if(flag==0){
                    map.put(new Point(x_cord,y_cord), y_cord);
                }
            }else{

                int key = 0;
                int value =0;
                for (Point k : map.keySet()){
                    key=k.x;
                    value=k.y;
                }

                listOfSinglePoints.add(key);
                listOfSinglePoints.add(value);

                map.put(new Point(x_cord, y_cord), y_cord);
            }

        }

        HashMap<Point, Integer> mapOfPointsInLine = new HashMap<>();
        mapOfPointsInLine.put(new Point(points[index][0],points[index][1]), points[index][1]);

        for(int i=0;i<listOfSinglePoints.size()-1;){

            HashMap<Point, Integer> tempMap = new HashMap<>();
            tempMap.put(new Point(listOfSinglePoints.get(i), listOfSinglePoints.get(i+1)), listOfSinglePoints.get(i+1));
            listOfPointsInStraightLine.add(tempMap);

            i+=2;

        }

        listOfPointsInStraightLine.add(mapOfPointsInLine);

        return listOfPointsInStraightLine;


    }

}




//EFFICIENT SOLUTION: (CLEAR AND FULLY UNDERSTANDABLE)

class Solution {
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) return 0;

        HashMap<Double, Integer> map=new HashMap<Double, Integer>();
        int maxCount = 1;

        for(int i = 0 ; i < points.length; i++) {

            map.clear();
            for(int j = i + 1; j < points.length; j++) {

                double slope = points[j][0] - points[i][0] == 0 ? Integer.MAX_VALUE : 0.0 + 
                    (double)(points[j][1] - points[i][1]) / (double)(points[j][0] - points[i][0]);

                map.put(slope, map.getOrDefault(slope, 1) + 1);
            }

            for (int count: map.values()) {
                if (count > maxCount) maxCount = count;
            }
        }

        return maxCount;
        
    }
}

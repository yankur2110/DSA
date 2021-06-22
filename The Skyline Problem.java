class Solution {
    
    class Building implements Comparable<Building>{
        int x_coord;
        int height;
        boolean isStart;
        
        Building(){
            
        }
        
        @Override
        public int compareTo(Building o) {
            //first compare by x.
            //If they are same then use this logic
            //if two starts are compared then higher height building should be picked first
            //if two ends are compared then lower height building should be picked first
            //if one start and end is compared then start should appear before end
            if (this.x_coord != o.x_coord) {
                return this.x_coord - o.x_coord;
            } else {
                return (this.isStart ? -this.height : this.height) - (o.isStart ? -o.height : o.height);
            }
        }
    }
    public List<List<Integer>> getSkyline(int[][] buildings) {
        
        /*
            1. Segregate the end and start coordinates. Then sort them based on x-coordinate. Also, keep a flag for                star/end coordinate.
            2. Keep a max heap PQ, to keep track of current max_height of building (which are started and not ended                till now's iteration) && if the current max height building ends then what would be the next building                (as max height).
            3. Now iterating through the coordinates. There will be two possibilities:-
                i. start coordinate:
                    a. if start's y coordinate is greater than current max -> add this coordinate into resultList                          and update the current max.
                    b. if start's y coordinate is smaller than current max, just insert into PQ. It will be useful                          in future, when current max ends.
                ii. end coordinate:
                    a. if end's y coordinate was the current max-> add a new coordinate to resultList with values,                          end's x coordinate and y coordinate would be the max value in PQ after removing current max.
                    b. if end's y coordinate was not the current max, it means it has no effect in skyline, just                            remove the end coordinate's y coordinate from PQ.
        */
    
        List<Building> listOfBuildings = new ArrayList<>();
        
        for(int i=0;i<buildings.length;i++){
            Building building1 = new Building();
            building1.x_coord=buildings[i][0];
            building1.height=buildings[i][2];
            building1.isStart=true;
            Building building2 = new Building();
            building2.x_coord=buildings[i][1];
            building2.height=buildings[i][2];
            building2.isStart=false;
            
            listOfBuildings.add(building1);
            listOfBuildings.add(building2);
        }
        
        Collections.sort(listOfBuildings);
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        List<List<Integer>> resultList = new ArrayList<>();
        
        
        for(Building building : listOfBuildings){
            if(building.isStart){
                if(maxHeap.peek()==null || building.height>maxHeap.peek()){
                    List<Integer> arrayList = new ArrayList<>();
                    arrayList.add(building.x_coord);
                    arrayList.add(building.height);
                    resultList.add(arrayList);
                }
                maxHeap.add(building.height);
            }else{
                if(maxHeap.peek()==building.height){ //this condition is not precisely telling us if after removing the current height, max_height is getting changed. There might be a case when 2 or more building have the same height and all are max. For this, 75 line code was added.
                    
                    maxHeap.remove(building.height);
                    if(maxHeap.peek()!=null && maxHeap.peek()!=building.height){
                        List<Integer> arrayList = new ArrayList<>();
                        arrayList.add(building.x_coord);
                        arrayList.add(maxHeap.peek());
                        resultList.add(arrayList);
                    }
                    else if(maxHeap.peek()==null){
                        List<Integer> arrayList = new ArrayList<>();
                        arrayList.add(building.x_coord);
                        arrayList.add(0);
                        resultList.add(arrayList);
                        
                    }
                }else{
                 maxHeap.remove(building.height);
                }
                
                    
            }
    
    } 
        
        return resultList;
    }
}

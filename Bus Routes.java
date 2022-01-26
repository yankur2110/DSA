class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {

        if(source == target)
            return 0;

        int maxStops = 0; //to initialize the visitedStops array with maxStops+1 size.

        //this map basically tracks all the buses that are coming to that bus stop.
        HashMap<Integer, List<Integer>> busStopToBusNumberMap = new HashMap<>();

        //populate the above map.
        for(int i=0;i<routes.length;i++){
            for(int j=0;j<routes[i].length;j++){
                if(!busStopToBusNumberMap.containsKey(routes[i][j])){
                    busStopToBusNumberMap.put((routes[i][j]), new ArrayList<>());
                }
                busStopToBusNumberMap.get(routes[i][j]).add(i);

                maxStops = Math.max(maxStops, routes[i][j]);
            }
        }

        int[] visitedStops = new int[maxStops+1]; //stops that have been visited.
        boolean[] visitedBus = new boolean[routes.length]; //to improve time complexity.
        Queue<Integer> que = new LinkedList<>(); //stores the busStop.
        que.add(source);
        int leastBusStops = 0;
        int flag=0;


        //main logic. i.e., modified BFS.
        while(!que.isEmpty()){

            int size = que.size();

            for(int i=0;i<size;i++){
                int busStop = que.poll();
                if(busStop==target)
                    return leastBusStops;

                List<Integer> busesThatCanBeCatchedUpFromBusStop = busStopToBusNumberMap.get(busStop);
                visitedStops[busStop]=1; //mark the current busStop visited.

                for(int busIndex : busesThatCanBeCatchedUpFromBusStop){

                    if(visitedBus[busIndex]) //if we have already visited the bus.
                        continue;

                    int length = routes[busIndex].length;
                    for(int j=0;j<length;j++)
                        if(visitedStops[routes[busIndex][j]]!=1) //if that stop is already visited.
                            que.add(routes[busIndex][j]);

                    visitedBus[busIndex]=true;
                }
            }

            leastBusStops++;
        }


        return -1;
    }
}

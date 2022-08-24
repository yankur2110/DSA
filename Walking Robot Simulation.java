class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        HashSet<String> obstacleSet = new HashSet<>();

        for(int[] obstacle : obstacles){
            obstacleSet.add(obstacle[0]+" "+obstacle[1]);
        }

        int maxX=0;
        int maxY=0;
        int maxDistance=0;
        int x=0, y=0;
        int currDirection = 0; //0 North, 1 East, 2 South, 3 West.
        for(int command : commands){

            if(command==-2){
                currDirection=(currDirection-1+4)%4;
                continue;
            }else if(command==-1){
                currDirection=(currDirection+1)%4;
                continue;
            }else{
                int step = 0;
                while (step < command
                       && (!obstacleSet.contains(
                           (x + directions[currDirection][0]) + " " + (y + directions[currDirection][1]))
                          )
                      ) {
                    x += directions[currDirection][0];
                    y += directions[currDirection][1];
                    step++;
                }

            }
            maxDistance = Math.max(maxDistance, x * x + y * y);
        }

        return maxDistance;

    }
}

class Solution {
    int[][] directions = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> resultList = new ArrayList<>();

        if(heights == null || heights.length == 0 || heights[0].length == 0){ //no islands in input.
            return resultList;
        }

        boolean[][] pacificFlowPossible = new boolean[heights.length][heights[0].length]; //keeps track of all islands visited/checked to see if water can go to pacific ocean from this island.
        boolean[][] atlanticFlowPossible = new boolean[heights.length][heights[0].length]; //similar for atlantic ocean.

        Queue<int[]> pQueue = new LinkedList<>(); //to consider the adjacents.
        Queue<int[]> aQueue = new LinkedList<>();

        for(int i=0;i<heights.length;i++){
            pQueue.add(new int[]{i,0}); //eligible to considered for adjacents.
            aQueue.add(new int[]{i,heights[0].length-1});
            pacificFlowPossible[i][0]=true;
            atlanticFlowPossible[i][heights[0].length-1]=true;
        }

        for(int i=0;i<heights[0].length;i++){
            pQueue.add(new int[]{0,i}); //eligible to considered for adjacents.
            aQueue.add(new int[]{heights.length-1, i});
            pacificFlowPossible[0][i]=true;
            atlanticFlowPossible[heights.length-1][i]=true;
        }

        startPopulatingFlowPossible(heights, pQueue, pacificFlowPossible);
        startPopulatingFlowPossible(heights, aQueue, atlanticFlowPossible);

        for(int i=0; i<heights.length; i++){
            for(int j=0; j<heights[0].length; j++){
                if(pacificFlowPossible[i][j] && atlanticFlowPossible[i][j]){
                    List<Integer> singleIsland = new ArrayList<>();
                    singleIsland.add(i); singleIsland.add(j);
                    resultList.add(singleIsland);
                }
            }
        }

        return resultList;
    }

    public void startPopulatingFlowPossible(int[][] heights, Queue<int[]> pQueue, boolean[][] flowPossible){
        int maxRows = heights.length-1;
        int maxColumns = heights[0].length-1;

        while(!pQueue.isEmpty()){
            int size = pQueue.size();

            for(int i=0; i<size; i++){
                int[] currentIsland = pQueue.poll();

                for(int[] dir: directions ){
                    int adjX = currentIsland[0]+dir[0];
                    int adjY = currentIsland[1]+dir[1];

                    //check if water can flow from island at (adjX, adjY) to current Island. If yes then add to visited.

                    if(adjX>maxRows || adjX<0 || adjY>maxColumns || adjY<0 || heights[currentIsland[0]][currentIsland[1]]>heights[adjX][adjY] || flowPossible[adjX][adjY])
                        continue;

                    flowPossible[adjX][adjY]=true;
                    pQueue.add(new int[]{adjX, adjY});
                }
            }
        }

    }
}

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        int n = rooms.size();
        if(n==0) return false;

        //keep track of visited rooms.
        boolean[] visited = new boolean[n];
        int count=0;

        Queue<Integer> que = new LinkedList<>(); //que for bfs.
        que.add(0);
        visited[0]=true;

        //bfs starts from here.
        while(!que.isEmpty()){
            int size=que.size();

            for(int i=0;i<size;i++){
                int visitedRoom = que.poll();

                count++;

                if(count==n) return true; //if we are able to visit all rooms, return true.

                for(int roomsThatWeCanVisit : rooms.get(visitedRoom)){ //check all neighbor rooms.
                    if(!visited[roomsThatWeCanVisit]){ //if neighbor room is not visited, visit them.
                        que.add(roomsThatWeCanVisit);
                        visited[roomsThatWeCanVisit]=true;
                    }
                }
            }
        }

        return false; //if not able to visit all rooms.

    }
}

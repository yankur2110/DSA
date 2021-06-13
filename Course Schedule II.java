class Solution {
    
    //if we found a cycle return true.
    private boolean isCycleAndDFS(int u, List<ArrayList<Integer>> adj, List<Integer> s, int[] visited){
        visited[u] = 1;
        for(int v : adj.get(u)){
            if(visited[v] == 1) return true;
            if(visited[v] == 0 && isCycleAndDFS(v, adj, s, visited)) return true;
        }
        //value 2 ensures we don't visit the already visited node.
        visited[u] = 2;
        s.add(u);
        return false;
    }
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //let's first create a dependency list.
        List<ArrayList<Integer>> dep_list = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            dep_list.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            ArrayList<Integer> list = dep_list.get(prerequisites[i][0]);
            list.add(prerequisites[i][1]);
        }
        
        //resultList to store the result.
        ArrayList<Integer> resultList = new ArrayList<>();
        int[] visited = new int[numCourses];
        
        //main logic.
        for(int i = 0; i < numCourses; ++i)
            if(visited[i] == 0 && isCycleAndDFS(i, dep_list, resultList, visited)) return new int[0];
        
        //convert the resultList into array using stream.
        int[] result = resultList.stream().mapToInt(Integer::intValue).toArray();
        return result;

    }
}

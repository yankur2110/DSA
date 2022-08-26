class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {

        int[] indegree = new int[n];
        List<List<Integer>> childList = new ArrayList<>();

        for(int i=0;i<n;i++){
            childList.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            indegree[edge[1]]++;
            childList.get(edge[0]).add(edge[1]);
        }

        Queue<Integer> que = new LinkedList<>();
        List<Set<Integer>> parentsList = new ArrayList<>();

        for(int i=0;i<n;i++){
            parentsList.add(new HashSet<>());
            if(indegree[i]==0)
                que.add(i);
        }

        while(!que.isEmpty()){
            int size = que.size();
            for(int i=0;i<size;i++){
                int parent = que.poll();
                List<Integer> childs = childList.get(parent);
                for(int child : childs){
                    parentsList.get(child).add(parent);
                    parentsList.get(child).addAll(parentsList.get(parent));
                    indegree[child]--;
                    if(indegree[child]==0)
                        que.add(child);
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (Set<Integer> set : parentsList)
            ans.add(new ArrayList<>(new TreeSet<>(set)));
        return ans;
    }
}

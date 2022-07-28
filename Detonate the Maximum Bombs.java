class Solution {
    int max=0;
    int count=0;
    public int maximumDetonation(int[][] bombs) {
        int n=bombs.length;

        for(int i=0;i<n;i++){
            count=0;
            dfs(i,new boolean[n], bombs);
        }

        return max;
    }

    public void dfs(int curr, boolean[] visited, int[][] bombs){
        count++;
        visited[curr]=true;
        max=Math.max(max,count);

        for(int i=0;i<bombs.length;i++){
            if(!visited[i] && inRadius(curr, i, bombs)){ //check if 'i' is in radius of curr.
                dfs(i,visited,bombs);
            }
        }
    }

    public boolean inRadius(int a, int b, int[][] bombs){
        long radiusOfA = bombs[a][2];
        long dx = bombs[a][0]-bombs[b][0];
        long dy = bombs[a][1]-bombs[b][1];

        return (dx*dx+dy*dy)<=radiusOfA*radiusOfA;
    }
}

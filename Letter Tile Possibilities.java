class Solution {
    int count=0;
    public int numTilePossibilities(String tiles) {
        char[] tilesArray = tiles.toCharArray();
        boolean[] visited = new boolean[tiles.length()];
        Arrays.sort(tilesArray);
        backtrack(tilesArray, 0, visited);
        return count;
    }

    public void backtrack(char[] charArray, int length, boolean[] visited){
        if(length==charArray.length)
            return;

        for(int i=0;i<charArray.length;i++){
            if(visited[i]) continue;

            if((i-1)>=0 && charArray[i]==charArray[i-1] && !visited[i-1]) //this is the crucial part.
                continue;

            visited[i]=true;
            count++;
            backtrack(charArray, length+1, visited);
            visited[i]=false;
        }
    }
}

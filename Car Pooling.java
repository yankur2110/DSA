class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        HashMap<Integer, Integer> boardMap = new HashMap<>();
        HashMap<Integer, Integer> dropMap = new HashMap<>();

        int maxDist =0;

        for(int i=0;i<trips.length;i++){
            boardMap.put(trips[i][1], boardMap.getOrDefault(trips[i][1], 0) + trips[i][0]);
            dropMap.put(trips[i][2], dropMap.getOrDefault(trips[i][2], 0) + trips[i][0]);
            maxDist = Math.max(maxDist, trips[i][2]);
        }

        for(int i=0; i<=maxDist; i++){
            if(dropMap.containsKey(i)){
                capacity+=dropMap.get(i);
            }

            if(boardMap.containsKey(i)){
                capacity-=boardMap.get(i);
            }

            if(capacity<0) return false;
        }

        return true;
    }
}

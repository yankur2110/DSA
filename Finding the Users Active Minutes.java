class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] result = new int[k];
        Map<Integer, HashSet<Integer>> userToTimeMap = new HashMap<>();

        for(int[] log : logs){
            userToTimeMap.putIfAbsent(log[0], new HashSet<>());
            userToTimeMap.get(log[0]).add(log[1]);
        }

        for(HashSet<Integer> set : userToTimeMap.values()){
            if(set.size()<=k){
                result[set.size()-1]++;
            }
        }

        return result;

    }
}

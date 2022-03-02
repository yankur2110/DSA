class Solution {
    public boolean canCross(int[] stones) {
        //hashmap to store the index of stone as the key and number of forward jumps that can be made from that stone.
        HashMap<Integer, HashSet<Integer>> stoneToNumberOfJumpsMap = new HashMap<>(stones.length);
        for(int i: stones){ //for each stone, populate an empty hashset.
            stoneToNumberOfJumpsMap.put(i, new HashSet<>());
        }
        stoneToNumberOfJumpsMap.get(0).add(1); //manually add 1 to 0th index stone as 1 can be jump from 0th stone everytime.

        int lastStone = stones[stones.length-1];

        for (int stone : stones) { //start checking each stone... where we can reach.
        	if(stone==lastStone) continue;
        	for (int jump : stoneToNumberOfJumpsMap.get(stone)) {
        		int reach = jump + stone;
        		if (reach == lastStone) { //if lastStone can be reached.
        			return true;
        		}
        		HashSet<Integer> set = stoneToNumberOfJumpsMap.get(reach); //otherwise add jump, jump-1, jump+1 to the hashSet of stone where we can reach from current stone.
        		if (set != null) {
        		    set.add(jump);
        		    if (jump - 1 > 0) set.add(jump - 1);
        		    set.add(jump + 1);
        		}
        	}
        }

     return false;
    }
}

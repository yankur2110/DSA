class Solution {
    //GETTING TLE FOR LAST CASE, THOUGH WHOLE CODE IS ALMOST SAME. NOT SPENDING MUCH TIME.

    class UnionFind{
        //array which will store the parent of a node. If two elements have same absoluteParents then they belong to same group.
        //parent has no meaning as such, they are just created to indicate that they belong to same group.
        private int[] parentArray;

        public UnionFind(int n){
            parentArray = new int[n];
            for(int i=0;i<n;i++){
                parentArray[i]=i; //initially everyone is the parent of itself.
            }
        }

        public int getAbsoluteParent(int i){
            if(parentArray[i]==i){ //while doing the recursion if we reach the at array element which has same value as it's index, it means it the absolute parent.
                return i;
            }

            return getAbsoluteParent(parentArray[i]);
        }

        public void unify(int i, int j){ //grouping the elements into same group.
            int absoluteParentOfI = getAbsoluteParent(i);
            int absoluteParentOfJ = getAbsoluteParent(j);
            if(absoluteParentOfI!=absoluteParentOfJ){ //if both's parent are not same, then just make any of them the parent of other.. this way both will point to the same parent and hence belong to same group.
                parentArray[absoluteParentOfJ]=absoluteParentOfI;
            }
        }
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        //the main logic of this problem is group the characters.
        //if they belong to the same group they can be used interchangeably.. so we will first form the groups -> then pick the smallest character from the group one by one at those index.
        UnionFind uf = new UnionFind(s.length());

        //form the groups.
        for(List<Integer> pair: pairs){
            uf.unify(pair.get(0),pair.get(1));
        }

        char[] str = s.toCharArray();
        // <ParentID, All Character that map to same parent>
		Map<Integer, PriorityQueue<Character>> map = new HashMap<>();

        //till now we have formed the groups of indexes. Now we will group the actual characters... i.e., will store the characters in priority queue against the parentId.
        for (int i = 0; i < str.length; i++) {
			int parentId = uf.getAbsoluteParent(i);
			PriorityQueue<Character> pq = map.getOrDefault(parentId, new PriorityQueue<Character>());
			pq.offer(str[i]);
			map.putIfAbsent(parentId, pq);
		}

        //now form the actual string.
		for (int i = 0; i < str.length; i++) {
			int parentId = uf.getAbsoluteParent(i);
			str[i] = map.get(parentId).poll();
		}
		return new String(str);
    }
}

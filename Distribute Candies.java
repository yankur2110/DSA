class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> set = new HashSet<>();

        for(int i : candyType)
            set.add(i);

        int n=candyType.length;
        int allowed=n/2;
        int diffTypes = set.size();

        return Math.min(allowed,diffTypes);
    }
}

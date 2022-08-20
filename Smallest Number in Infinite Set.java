class SmallestInfiniteSet {

    int smallest=1;
    TreeSet<Integer> set; //contains the elements which are added after polling and smaller than the current smallest.
    public SmallestInfiniteSet() {
        set = new TreeSet<>();
    }

    public int popSmallest() {
        if(!set.isEmpty()){
            return set.pollFirst();
        }
        return smallest++;
    }

    public void addBack(int num) {
        if(num<smallest)
            set.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */

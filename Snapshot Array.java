class SnapshotArray {

    TreeMap<Integer, Integer>[] treeMapArray; //choice of ds was the main important part of this problem.
    //above treeMap stores the value against snap.
    int snap_id=0;

    public SnapshotArray(int length) {
        treeMapArray = new TreeMap[length];

        for(int i=0;i<length;i++){
            treeMapArray[i]=new TreeMap<>();
            treeMapArray[i].put(0,0); //since initially all elements have 0 value and initially snap_id is also 0.
        }
    }

    public void set(int index, int val) { //simply update the value at that snap_id, for the index.
        treeMapArray[index].put(snap_id,val);
    }

    public int snap() { //increment the snap_id.
       return snap_id++;
    }

    public int get(int index, int snap_id) { //we want the last snap's value... for that index. Using floor entry it might happen that.. after the snap no value has been entered... So, if we had used the get method.. it would have thrown null pointer exception.
        return treeMapArray[index].floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */

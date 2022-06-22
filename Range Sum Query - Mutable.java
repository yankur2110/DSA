class NumArray {

    //since in our case there would be multiple update calls, we are using segment tree.
    class SegmentTreeNode{
        int start, end, sum;
        SegmentTreeNode left, right;

        SegmentTreeNode(int start, int end){
            this.start=start;
            this.end=end;
        }
    }

    SegmentTreeNode root =null;

    public NumArray(int[] nums) {
        root = buildSegmentTree(0,nums.length-1,nums);
    }

    //build the segment tree. Leaf nodes will have same value as of the node, for others calculate the sum of left and right subtree... and return this new node.
    private SegmentTreeNode buildSegmentTree(int start, int end, int[] nums){
        if(start>end) return null;

        SegmentTreeNode toBeReturned = new SegmentTreeNode(start, end);
        if(start==end){
            toBeReturned.sum=nums[start];
        }else{
            int mid = start + (end-start)/2;
            toBeReturned.left = buildSegmentTree(start,mid,nums);
            toBeReturned.right = buildSegmentTree(mid+1,end,nums);

            toBeReturned.sum = toBeReturned.left.sum + toBeReturned.right.sum;
        }
        return toBeReturned;

    }

    public void update(int index, int val) {
        updateHelper(index,val, root);
    }

    //go to the leaf node, update it's value. For rest other nodes that came along the way, calculate the sum again.
    private void updateHelper(int index, int val, SegmentTreeNode root){

        if(root.start==root.end){
            root.sum=val;
            return;
        }

        int mid = root.start+(root.end-root.start)/2;

        if(index<=mid){
            updateHelper(index, val, root.left);
        }else{
            updateHelper(index, val, root.right);
        }

        root.sum = root.left.sum+root.right.sum;
    }

    public int sumRange(int left, int right) {
        //we will calculate the sum only when the range of SegmentTreeNode is overlapping fully exactly.
        return sumRangeHelper(root,left,right);
    }


    private int sumRangeHelper(SegmentTreeNode root, int start, int end) {
        if (root.end == end && root.start == start) { //full overlap.
            return root.sum;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (end <= mid) {
                return sumRangeHelper(root.left, start, end); //lies in left half.
            } else if (start >= mid+1) {
                return sumRangeHelper(root.right, start, end); //lies in right half.
            }  else {
                return sumRangeHelper(root.right, mid+1, end) + sumRangeHelper(root.left, start, mid); //partial overlap.
            }
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */

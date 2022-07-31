class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> que = new LinkedList<>();

        int root = findRoot(n, leftChild, rightChild); //we need to find root first because if we assume 0 as the root, it might happen that later we get to know that 0 is child of some other node but it would be marked as visited and hence would return false.
        if (root == -1) return false;

        que.add(root);
        visited.add(root);

        while(!que.isEmpty()){
            int size=que.size();

            for(int i=0;i<size;i++){
                int polledVal = que.poll();
                int leftChildVal = leftChild[polledVal];
                int rightChildVal = rightChild[polledVal];

                if(visited.contains(leftChildVal) || visited.contains(rightChildVal) || (leftChildVal==rightChildVal && leftChildVal!=-1)){
                    return false;
                }

                if(leftChildVal!=-1){
                    que.add(leftChildVal);
                    visited.add(leftChildVal);
                }

                if(rightChildVal!=-1){
                    que.add(rightChildVal);
                    visited.add(rightChildVal);
                }
            }
        }

        return (visited.size()==n)?true:false;
    }

    private int findRoot(int n, int[] left, int[] right) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) set.add(i);
        for (int node : left) set.remove(node);
        for (int node : right) set.remove(node);

        return set.size() == 1 ? set.iterator().next() : -1; //if we don't know the elements of set, we can get them simply by iterating like this.
    }
}

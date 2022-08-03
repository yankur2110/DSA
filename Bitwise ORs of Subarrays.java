class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer> prev = new HashSet<>(), curr = null;
        HashSet<Integer> result = new HashSet<>();

        //start iterating.
        int n= arr.length;
        for(int i=0;i<n;i++){
            curr = new HashSet<>();
            prev.add(0);
            for(int prevXOR: prev){
                curr.add(arr[i]|prevXOR);
                result.add(arr[i]|prevXOR);
            }
            prev=curr;
        }

        return result.size();
    }
}

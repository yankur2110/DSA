class Solution {
    public int maximumSum(int[] arr) {

        int oneDelete=0;
        int noDelete=arr[0];
        int max=arr[0];

        for(int i=1;i<arr.length;i++){
            oneDelete = Math.max(oneDelete+arr[i], noDelete); //i.e., excluded the current element OR already excluded one previous element + current element.
            noDelete = Math.max(noDelete+arr[i],arr[i]); //not excluding the previous sum OR continuing adding.
            max=Math.max(max, Math.max(noDelete,oneDelete));
        }
        return max;
    }
}

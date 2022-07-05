class Solution {
    public int[] replaceElements(int[] arr) {
        int n= arr.length,max=0;
        int prev=arr[n-1];
        arr[n-1]=-1;
        for(int i=n-2;i>=0;i--){
            max=Math.max(prev,arr[i+1]);
            prev=arr[i];
            arr[i]=max;
        }

        return arr;
    }
}

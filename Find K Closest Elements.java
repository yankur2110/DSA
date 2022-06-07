class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
       int left = 0, right = arr.length - k; //start right from arr.length-k.
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid + k] - x < x - arr[mid] ) //if x is closer to (mid+k)th element, then increment the left.
                left = mid + 1;
            else
                right = mid; //otherwise make the right as mid. Note: here we aren't leaving mid.
        }

        return Arrays.stream(arr, left, left + k).boxed().collect(Collectors.toList()); //convert array from index left to (left+k)th index to arraylist.
    }
}

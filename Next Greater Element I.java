class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> numToNGEmap  = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for(int curr : nums2){
            while(!stack.isEmpty() && curr>stack.peek()){
                numToNGEmap.put(stack.pop(), curr);
            }
            stack.push(curr);
        }

        for(int i=0;i<nums1.length;i++){
            nums1[i]=numToNGEmap.getOrDefault(nums1[i],-1);
        }
        return nums1;
    }
}

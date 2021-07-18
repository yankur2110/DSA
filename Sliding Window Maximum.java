class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int[] result = new int[nums.length-k+1];
        int index = 0;
        
        Deque<Integer> indicesDeque = new ArrayDeque<>();
        
        for(int i=0;i<nums.length;i++){
            if(indicesDeque.peekFirst()!=null && indicesDeque.peekFirst()<(i-k+1))
                indicesDeque.poll();
            while(indicesDeque.peekLast()!=null && nums[indicesDeque.peekLast()] < nums[i])
                indicesDeque.removeLast();
            indicesDeque.add(i);
            
            if(i>=k-1)
                result[index++]=nums[indicesDeque.peekFirst()];
        }
        
        return result;
    }
}

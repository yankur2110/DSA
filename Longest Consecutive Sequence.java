class Solution {
    //https://www.youtube.com/watch?v=jWeS4LTqLFA
    //idea is pretty simple put the values in hashset, then for each element check their consecutives of left side and right side.
    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> set = new HashSet<Integer>();
        for(int number:nums){
            set.add(number);
        }
        int max=0;
        while(!set.isEmpty()){
            int num= set.iterator().next();
            set.remove(num);
            int lowerBound=num-1;
            int upperBound=num+1;
            while(set.contains(lowerBound)){
                set.remove(lowerBound);
                lowerBound--;
            }
            while(set.contains(upperBound)){
                set.remove(upperBound);
                upperBound++;
            }
            max=Math.max(max,upperBound-lowerBound-1);
            
        }

        return max;
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        //remember substring is always a continuos string.
        //video ref: https://www.youtube.com/watch?v=3IETreEybaA
        
        HashSet <Character> hashSet = new HashSet<Character>();
        int start_pointer = 0;
        int end_pointer = 0;
        int max = 0;
        
        while(end_pointer < s.length()){
            if(!hashSet.contains(s.charAt(end_pointer))){
                hashSet.add(s.charAt(end_pointer));
                max = Math.max(hashSet.size(),max);
                end_pointer++;
            }
            else{
                hashSet.remove(s.charAt(start_pointer)); //either that duplicate one will be at first place or we will keep on deleting, so that substring with unique element in constructed in hashSet.
                start_pointer++;
            }
        }
       return max; 
    }
}

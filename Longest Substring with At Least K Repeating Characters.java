class Solution {
    public int longestSubstring(String s, int k) {
        return recSolution(0,s.length()-1,s,k);
    }
    
    public int recSolution(int start, int end, String s , int k){
        if(k==1){
            return end-start+1;
        }else if(start>=end){
            return 0;
        }
        
        int[] charCountArray = new int[26];
        
        for(int i=start;i<=end;i++){
            charCountArray[s.charAt(i)-'a']++;
        }
        
        for(int i=start;i<=end;i++){
            if(charCountArray[s.charAt(i)-'a']<k)
                return Math.max(recSolution(start,i-1,s,k), recSolution(i+1,end,s,k));
        }
        
        return end-start+1;
    }
}
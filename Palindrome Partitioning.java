class Solution {
    
    //solution: https://www.youtube.com/watch?v=A0wENqSIxK4
    public List<List<String>> partition(String s) {
        
        List<List<String>> res = new ArrayList<>();
        
        helper(res,new ArrayList<>(),s,0);
        return res;
    }
    
    public void helper(List<List<String>> res, List<String> cur, String s, int lo){
        
        if(lo==s.length()){
            res.add(new ArrayList(cur));
            return;
        }
        
        for(int hi=lo;hi<s.length();hi++){
            
            if(isPalindrome(s.substring(lo,hi+1))){
                
                cur.add(s.substring(lo,hi+1));
                helper(res,cur,s,hi+1);
                cur.remove(cur.size()-1);
                
            }
        }
        
    }
    
    public boolean isPalindrome(String s){
        int low =0;
        int high = s.length()-1;
        
        while(low<=high){
            if(s.charAt(low) != s.charAt(high))
                return false;
            low++;
            high--;
        }
        
        return true;
        
    }
}
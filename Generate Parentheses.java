class Solution {
    
    // https://www.youtube.com/watch?v=I9GxNZBLYdk  ...to understand 
    // https://www.youtube.com/watch?v=qBbZ3tS0McI&t=623s ..for code
    
    // Note: important example to understand backtracking.
    public List<String> generateParenthesis(int n) {
        
        List<String> output_arr = new ArrayList<String>();
        
        backtrack(output_arr, "",0 , 0 , n);
        
        return output_arr;
        
    }
    
    public void backtrack(List<String> output_arr,String current_string,int open,int close, int max){
        
        if(current_string.length()==max*2){
            output_arr.add(current_string);
            return;
        }
        
        if(open<max){ //if open parenthesis is not reached maximum we can add open parenthesis
            backtrack(output_arr,current_string+"(",open+1,close,max);
        } 
        if(close<open){ //if close<open then we can add closing parenthesis too.
            backtrack(output_arr,current_string+")",open,close+1,max);
        } 
        
        
    }
}
class Solution {
    
    boolean[][] visited;
    
    
    public boolean exist(char[][] board, String word) {
        
        if(board==null || word ==null){
            return false;
        }
        
        visited= new boolean[board.length][board[0].length];
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                
                if(word.charAt(0)==board[i][j] && FindWordUsingBacktracking(i,j,board,word,0))
                    return true;
            }
        }
        
       return false;
        
    }
    
    public boolean FindWordUsingBacktracking(int i_index, int j_index, char[][] board,String word, int word_index){
        
        if(word_index==word.length()){
            return true;
        }
        
        if(i_index>=board.length ||i_index<0 || j_index>=board[i_index].length ||  j_index<0 || board[i_index][j_index]!=word.charAt(word_index) || visited[i_index][j_index]) {
        	return false;
        }
        
        visited[i_index][j_index]=true;
           
            if(FindWordUsingBacktracking(i_index+1,j_index,board,word,word_index+1))
            	return true;
            if(FindWordUsingBacktracking(i_index,j_index+1,board,word,word_index+1))
            	return true;
            if(FindWordUsingBacktracking(i_index-1,j_index,board,word,word_index+1))
            	return true;
            if(FindWordUsingBacktracking(i_index,j_index-1,board,word,word_index+1))
            	return true;
        
        visited[i_index][j_index]=false;
            
        return false;
            
    }
}
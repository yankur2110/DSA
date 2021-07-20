class Solution {
    public void gameOfLife(int[][] board) {
        
        if (board == null || board.length == 0) return;
        
        for(int i=0; i<board.length;i++){
            for(int j=0; j<board[0].length;j++){
                
                int surroundingLives = countSurrounding(board,i,j);
                
                if(board[i][j]==1 && (surroundingLives==2 || surroundingLives==3)){
                    board[i][j]=3;   
                }else{
                   if(surroundingLives==3) 
                       board[i][j]=2;
                }
            }
        }
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j]=board[i][j]>>1;
            }
        }
    }
    
    public int countSurrounding(int[][] board, int i, int j){
        int count =0;
        int rows = board.length-1;
        int cols = board[0].length-1;
        

        for(int x = Math.max(i-1,0); x<=Math.min(i+1, rows);x++)
            for(int y = Math.max(j-1,0); y<=Math.min(j+1,cols); y++)
                count+=board[x][y]&1;
        
        count-=board[i][j]&1;
        return count;
        
    }
}

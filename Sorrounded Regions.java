class Solution {
//https://www.youtube.com/watch?v=ztTLGMeleco&t=81s
    
    public void solve(char[][] board) {
        
        if(board.length==0 || board[0].length==0)
            return;
        
        int row = board.length;
        int col = board[0].length;
        
        for(int i=0;i<row;i++){//check boundary values for first and last column.
            if(board[i][0]=='O')
                depthDFS(board,i,0);
            if(board[i][col-1]=='O')
                depthDFS(board,i,col-1);
        }
        
          for(int i=0;i<col;i++){//check boundary values for first and last row.
            if(board[0][i]=='O')
                depthDFS(board,0,i);
            if(board[row-1][i]=='O')
                depthDFS(board,row-1,i);
        }
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='O')
                    board[i][j]='X';
                if(board[i][j]=='*')
                    board[i][j]='O';
                
            }
        } 
        
    }
    
    
    public void depthDFS(char[][] board, int row, int col){
        if(row<0 || row>board.length-1 || col<0 || col>board[0].length)
            return;
        
        if(board[row][col]=='O')
            board[row][col]='*';
        
        if(row>0 && board[row-1][col]=='O'){
            depthDFS(board,row-1,col);
        }
            
        if(row<board.length-1 && board[row+1][col]=='O'){
            depthDFS(board,row+1,col);
        }
            
        if(col>0 && board[row][col-1]=='O'){
            depthDFS(board,row,col-1);
        }
            
        if(col<board[0].length-1 && board[row][col+1]=='O'){
            depthDFS(board,row,col+1);
        }
    }
    
}
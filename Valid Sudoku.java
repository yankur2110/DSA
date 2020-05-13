class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        HashSet<Character> box1 = new HashSet<Character>();
        HashSet<Character> box2 = new HashSet<Character>();
        HashSet<Character> box3 = new HashSet<Character>();
        int j;
        
        for(int i=0;i<board[0].length;i++){
            HashSet<Character> hash_set = new HashSet<Character>();
            HashSet<Character> hash_set_col = new HashSet<Character>();
            for(j=0;j<board[0].length;j++){
                
                if(hash_set.contains(board[i][j])==true){
                    return false;
                }else if(hash_set.contains(board[i][j])==false && board[i][j]!='.'){
                    hash_set.add(board[i][j]);
                }
                
                if(hash_set_col.contains(board[j][i])==true){
                    return false;
                }else if(hash_set_col.contains(board[j][i])==false && board[j][i]!='.'){
                    hash_set_col.add(board[j][i]);
                }
            }
            
            if(i%3==0){
                box1.clear(); box2.clear(); box3.clear();
            }
            
            for(j=0;j<3;j++){
                if(box1.contains(board[i][j])==true){
                    return false;
                }else if(box1.contains(board[i][j])==false && board[i][j]!='.'){
                    box1.add(board[i][j]);
                }
                
            }
            for(j=3;j<6;j++){
                if(box2.contains(board[i][j])==true){
                    return false;
                }else if(box2.contains(board[i][j])==false && board[i][j]!='.'){
                    box2.add(board[i][j]);
                }
                
            }
            for(j=6;j<9;j++){
                if(box3.contains(board[i][j])==true){
                    return false;
                }else if(box3.contains(board[i][j])==false && board[i][j]!='.'){
                    box3.add(board[i][j]);
                }
                
            }
            
        }
        
        
        
        return true;
        
    }
}
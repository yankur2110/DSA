class Solution {
    List<String> resultString = new ArrayList<>();
    
    public List<String> findWords(char[][] board, String[] words) {
     
        TrieNode root = buildTrie(words);
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                helper(i,j,board,words,"",root);
            }
        }

        return resultString;
    }
    
    public void helper (int i, int j, char[][]board, String[] words, String currWord, TrieNode root){
        
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]=='*'){
            return;
        }
        
        currWord += Character.toString(board[i][j]);
        char temp = board[i][j];
        board[i][j]='*';
        
        //check if words has a possibility for such word.
        
        if(root.next[temp-'a']==null){
            board[i][j]=temp;
            return;
        }else{
            if(root.next[temp-'a'].isWord)
                resultString.add(currWord);
            root.next[temp-'a'].isWord=false;
            root=root.next[temp-'a'];
        }
      
        //if this word is present, then add it to resultString and delete that word from words.
        //here we will continue even for case like indo,indochina.
        
        helper(i,j-1,board,words,currWord,root);
        helper(i,j+1,board,words,currWord,root);
        helper(i-1,j,board,words,currWord,root);
        helper(i+1,j,board,words,currWord,root);
        
        board[i][j]=temp;
        
    }
    
    public TrieNode buildTrie(String[] words) {
    TrieNode root = new TrieNode();
    for (String w : words) {
        TrieNode p = root;
        for (char c : w.toCharArray()) {
            int i = c - 'a';
            if (p.next[i] == null) p.next[i] = new TrieNode();
            p = p.next[i];
        }
        p.isWord = true;
     }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        boolean isWord;
    }
}

class TrieNode{
    char value;
    boolean isWord;
    TrieNode[] children = new TrieNode[26];
    
    TrieNode(char c){
       this.value= c;
    }
}

class Trie {
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(' ');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode atNode = root;
        
        for(int i=0;i<word.length();i++){
            int charMapping  = word.charAt(i)-'a'; 
            
            if(atNode.children[charMapping]==null){
                atNode.children[charMapping]=new TrieNode(word.charAt(i));
            }
            atNode = atNode.children[charMapping];
            
        }
        atNode.isWord = true;
        
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode atNode = root;
        for(int i=0;i<word.length();i++){
            int charMapping  = word.charAt(i)-'a';
            
            if(atNode.children[charMapping]==null)
                return false;
            atNode = atNode.children[charMapping];
        }
        
        
        return atNode.isWord;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String word) {
        
        TrieNode atNode = root;
        for(int i=0;i<word.length();i++){
            int charMapping  = word.charAt(i)-'a';
            
            if(atNode.children[charMapping]==null)
                return false;
            atNode = atNode.children[charMapping];
        }
        
        
        return true;
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

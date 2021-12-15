class TrieNode{
    char ch;
    boolean isWord;
    TrieNode[] children = new TrieNode[26];
    
    TrieNode(char ch){
        this.ch =ch;
    }
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
       TrieNode root = new TrieNode('/'); //intialize with a root.
        for(String str : products){
            insert(root, str);  //insert each of the product into trie.
        }
        
        List<List<String>> suggestionsList = new ArrayList<>();
        populateSuggestionsList(root, suggestionsList, searchWord);
        
        return suggestionsList;
    }
    
    public void insert(TrieNode atNode, String str){
        for(int i=0;i<str.length();i++){ //setting each character of the TrieNode at correct position.
            char ch = str.charAt(i);
            TrieNode[] children = atNode.children;
            if(children[ch-'a']==null){
                children[ch-'a'] = new TrieNode(ch);
            }
            atNode = atNode.children[ch-'a'];
        }
        atNode.isWord = true;
    }
    
    public void populateSuggestionsList(TrieNode root, List<List<String>> suggestionsList, String searchWord){
        
        for(int i=0;i<searchWord.length();i++){
            String str = searchWord.substring(0,i+1);
            populate3SuggestionsForStr(str, root, suggestionsList);
        }
        
    }
    
    public void populate3SuggestionsForStr(String str, TrieNode atNode, List<List<String>> suggestionsList){
        List<String> list = new ArrayList<>();
        suggestionsList.add(list);
        
        
        for(int i=0;i<str.length();i++){
            int index = str.charAt(i)-'a';
            atNode = atNode.children[index];
            
            if(atNode==null)
                return;
        }
        
        //now we are the node whose leaves nodes we need to suggest.
        populateListRecursively(atNode, str, list);
    }
    
    public void populateListRecursively(TrieNode atNode, String str, List<String> list){
        
        if(list.size()==3)
            return;
        
        if(atNode.isWord==true){
            list.add(str);
        }
        
        TrieNode[] children = atNode.children;
        for(int i=0;i<26;i++){
            if(children[i]!=null){
                populateListRecursively(children[i], str+Character.toString(children[i].ch), list);
                
                if(list.size()==3)
                    break;
            }
        }
    }
    
    
}

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> preWords = new HashSet<>();
        Arrays.sort(words, new Comparator<String>() {
            public int compare (String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        
        for (int i = 0; i < words.length; i++) {
            if (canForm(words[i], preWords)) {
                result.add(words[i]);
            }
            preWords.add(words[i]);
        }
        
        return result;
    }
    
    public boolean canForm(String word, Set<String> dict){
        if (dict.isEmpty()) return false;
        boolean[] boolArray = new boolean[word.length()+1];
        boolArray[0]=true;
        
        for(int i=1;i<=word.length();i++){
            for(int j=0;j<i;j++){
                if(boolArray[j] && dict.contains(word.substring(j,i) )){
                    boolArray[i]=true;
                    break;
                }
            }
            
        }
        
        return boolArray[word.length()];
    }
}

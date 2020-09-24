class Solution {
    
    //https://www.youtube.com/watch?v=uR3RElKnrkU&ab_channel=anotherdigitalnomad
    //to escape time limit exceeded, we are using memoization, that is storing the results for string in a hashmap.
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreakHelper(s,wordDict, new HashMap<String,List<String>>());
    }
    
    public List<String> wordBreakHelper(String s, List<String> wordDict, Map<String,List<String>> memo){
        
        if(memo.containsKey(s))
            return memo.get(s);
        
        List<String> resultList = new ArrayList<String>();
        
        if(s.isEmpty()){
            resultList.add("");
            return resultList;
        }
        
         
        for(String word : wordDict){
            if(s.startsWith(word)){
                List<String> wordsFromTrimmedString=wordBreakHelper(s.substring(word.length()),wordDict,memo);
                
                for(String eachWord: wordsFromTrimmedString){

                    String optionalString = eachWord.isEmpty()?"": " ";
                    resultList.add(word + optionalString + eachWord);
                }
            }
        }
        
        memo.put(s,resultList);
        
        return resultList;
    }
}
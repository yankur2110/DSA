class Solution {
    //https://www.youtube.com/watch?v=M9cVl4d0v04&t=637s
    //actually it's not very efficient solution by Nick White, but here you learn when BFS can be used.
    //here we are using BFS. we put the beginWord in the queue...then changes it's all letter from a->z one by one and if on any change we find already in the set..then push in the queue..If same as the endWord then return the level+1....If not..repeat this in the loop.
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashSet<String> set = new HashSet<String>();
        
        for(String word: wordList){
            set.add(word);
        }
        
        if(!set.contains(endWord))
            return 0;
        
        int level =1;
        
        Queue<String> keepTrack = new LinkedList<>();
        keepTrack.offer(beginWord);
        
        while(!keepTrack.isEmpty()){
            
            int size=keepTrack.size();
            
            for(int i=0;i<size;i++){
                
                String currWord = keepTrack.poll();
                char[] currWordCharArray = currWord.toCharArray();
                
                for(int j=0;j<currWordCharArray.length;j++){
                    
                    char originalChar = currWordCharArray[j];
                    
                    for(char c='a'; c<='z'; c++){
                        if(currWordCharArray[j]==c)
                            continue;
                        currWordCharArray[j]=c;
                        String newWord = new String(currWordCharArray);
                        if(newWord.equals(endWord))
                            return level+1;
                        if(set.contains(newWord)){
                            keepTrack.offer(newWord);
                            set.remove(newWord);
                        }
                        
                    }
                    
                    currWordCharArray[j]=originalChar;
                }
            }
            
            level++;
            
        }
        
        return 0;
        
    }
    
}
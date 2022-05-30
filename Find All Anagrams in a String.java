class Solution {

    int distinctCharacterCount = -1;
    public List<Integer> findAnagrams(String s, String p) {

        //this map contains the count of characters needed to form an anagram from string s. If there are extra characters in the current window then it count would be -ve and if less characters are there then count would be +ve.
        HashMap<Character, Integer> pCharacterCountMap = new HashMap<>();

        //resultList.
        List<Integer> resultList = new ArrayList<>();

        //Invalid case check.
        if(s.length()<p.length()) return resultList;

        //populate the map for string p.
        for(int i=0;i<p.length();i++){
            char ch = p.charAt(i);
            if(!pCharacterCountMap.containsKey(ch))
                pCharacterCountMap.put(ch,0);
            addToMap(ch, pCharacterCountMap);
        }

        //keep track of distinct character count in p, so that we don't need to iterate the hashmap to compare if window and string 'p' are anagram of each other.
        distinctCharacterCount = pCharacterCountMap.size();

        //create the first window.
        for(int i=0;i<p.length();i++){
            char ch = s.charAt(i);
            decrementCountInMap(ch, pCharacterCountMap);
        }

        //we check the current window and set the distinctCharacterCount of next window.
        for(int i=0;i<s.length()-p.length();i++){
            if(distinctCharacterCount==0) resultList.add(i);

            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i+p.length());

            addToMap(ch1, pCharacterCountMap);
            decrementCountInMap(ch2, pCharacterCountMap);
        }

        //since we are not checking the last window.. Reason: since we are setting the distinctCharacterCount of next window, it would give ArrayOutOfBoundException when we are in last window.
        if(distinctCharacterCount==0) resultList.add(s.length()-p.length());

       return resultList;
    }

    //handling the start element of window. Since we are removing, we increment the count in map.
    public void addToMap(char ch, HashMap<Character, Integer> map){
        if(map.containsKey(ch)){
            if(map.get(ch)==0)
                distinctCharacterCount++;

            map.put(ch, map.get(ch)+1);
            if(map.get(ch)==0)
                distinctCharacterCount--;
        }

    }

    //handling the last element of window. Since we are adding, we decrement the count in map.
    public void decrementCountInMap(char ch, HashMap<Character, Integer> map){
        if(map.containsKey(ch)){
            if(map.get(ch)==0)
                distinctCharacterCount++;

            map.put(ch, map.get(ch)-1);

            if(map.get(ch)==0)
                distinctCharacterCount--;
        }

    }
}

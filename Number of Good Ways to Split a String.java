class Solution {
    public int numSplits(String s) {
        int count=0;
        Map<Character, Integer> freqMap = new HashMap<>();//store the characters frequency in right substring.
        Set<Character> leftCharSet = new HashSet<>(); //store the characters in left substring.

        for(char ch : s.toCharArray()){ //populate the right substring freq Map.
            freqMap.put(ch, freqMap.getOrDefault(ch,0)+1);
        }

        for(int i=1;i<s.length();i++){ //in every iteration add one char to left.
            char ch = s.charAt(i-1);
            leftCharSet.add(ch);
            freqMap.put(ch, freqMap.getOrDefault(ch,0)-1);
            if(freqMap.get(ch)==0){
                freqMap.remove(ch);
            }

            if(leftCharSet.size()==freqMap.size()){ //count the number of distinct characters in left and right substring.
                count++;
            }
        }

        return count;

    }
}

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] charFrequencies = new int[26];
        for(char ch: magazine.toCharArray()){
            charFrequencies[ch-'a']++;
        }

        for(char ch: ransomNote.toCharArray()){
            if(charFrequencies[ch-'a']-- <=0){
                return false;
            }
        }
        return true;
    }
}

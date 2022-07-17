class Solution {
    int[] charArray = new int[26];
    int length=0;

    public int countCharacters(String[] words, String chars) {
        length=chars.length();

        for(char ch : chars.toCharArray()){
            charArray[ch-'a']++;
        }

        int length=0;
        for(String str : words){
            if(canBeFormed(str)){
                length+=str.length();
            }
        }

        return length;
    }

    public boolean canBeFormed(String str){
        int[] tempArray = new int[26];
        for(char ch : str.toCharArray()){
            tempArray[ch-'a']++;
        }

        for(int i=0;i<26;i++){
            if(tempArray[i]>charArray[i]){
                return false;
            }
        }
        return true;
    }
}

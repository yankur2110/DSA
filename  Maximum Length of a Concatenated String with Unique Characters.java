class Solution {
    public int maxLength(List<String> arr) {
        List<String> uniqueCharactersStrings = new ArrayList<>();

        uniqueCharactersStrings.add("");

        int maxValidStrLength=0;

        //check current string with all the existing valid strings. If it forms a valid string then add to the list for future elements.
        //keep track of max length of valid strings till now.
        for(String str : arr){
            List<String> newValidStrings = new ArrayList<>();
            for(String alreadyPresentString : uniqueCharactersStrings){
                String newStr = str+alreadyPresentString;
                if(isUnique(newStr)){
                    newValidStrings.add(newStr);
                    maxValidStrLength = Math.max(maxValidStrLength, newStr.length());
                }
            }

           //add valid new strings for future elements.
           uniqueCharactersStrings.addAll(newValidStrings);
        }

        return maxValidStrLength;
    }

    public boolean isUnique(String str){
        if(str.length()>26) return false;
        int[] freqArray = new int[26];

        for(int i=0;i<str.length();i++){
            freqArray[str.charAt(i)-'a']++;
            if(freqArray[str.charAt(i)-'a']>1){
                return false;
            }
        }
        return true;
    }
}

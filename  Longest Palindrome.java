class Solution {
    public int longestPalindrome(String s) {
        int result=0; //stores the longest palindrome length.
        int[] frequencyOfEachCharArray = new int[256]; //array to store the frequency of each character in string.
        for(char ch : s.toCharArray()){ //populate above array.
            frequencyOfEachCharArray[ch]+=1;
        }

        for(int i=0;i<s.length();i++){ //check the count of each character, if it's even it can surely contribute to the longest palindrome. Add it. Also decrement that count from the array.
            result+=(2*(frequencyOfEachCharArray[s.charAt(i)]/2));
            frequencyOfEachCharArray[s.charAt(i)]%=2;
        }

        for(int i=0;i<256;i++){ //check if any odd length character is remaining, If yes then it can be appended in the middle to get max length of palindrome string.
            if(frequencyOfEachCharArray[i]==1){
                result+=1;
                break;
            }
        }

        return result; //return result.
    }
}

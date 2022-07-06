class Solution {
    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        s=stringBuilder.reverse().toString(); //reverse the string.

        char[] charArray = s.toCharArray();

        //we have to make sure start and end are at the desired place.
        int end = charArray.length;
        int start = charArray.length-1;
        stringBuilder = new StringBuilder(); //use the same stringBuilder.

        while(true){

            //keep looking for spaces.
            //we are making use of constraint that:
            //  1. there are no leading or trailing spaces. 2. no consecutive spaces are there.
            while(start!=-1 && charArray[start]!=' '){
                start--;
            }

            stringBuilder.append(s.substring(start+1,end));

            end=start;
            if(start!=-1){ //if it's not the last word, we have to append space.
                stringBuilder.append(" ");
                start--;
            }else{ //if it was the last word, break.
                break;
            }


        }

        return stringBuilder.toString();
    }
}

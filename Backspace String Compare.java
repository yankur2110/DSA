class Solution {
    public boolean backspaceCompare(String s, String t) {
        int sEnd = s.length()-1, tEnd = t.length()-1, numOfSkips;

        while(true){

            //skip '#' of first string till the time lowercase english letter is not found after backspaces.
            numOfSkips=0;
            while(sEnd>=0 && (numOfSkips>0 || s.charAt(sEnd)=='#')){
                if(s.charAt(sEnd)=='#')
                    numOfSkips++;
                else
                    numOfSkips--;
                sEnd--;
            }

            //skip '#' of second string till the time lowercase english letter is not found after backspaces.
            numOfSkips=0;
            while(tEnd>=0 && (numOfSkips>0 || t.charAt(tEnd)=='#')){
                if(t.charAt(tEnd)=='#')
                    numOfSkips++;
                else
                    numOfSkips--;
                tEnd--;
            }

            //if both are >=0 then both are english characters only, compare them.
            if (sEnd >= 0 && tEnd >= 0 && s.charAt(sEnd) == t.charAt(tEnd)) {
                sEnd--;
                tEnd--;
            } else {
                break;
            }

        }

        //incase more backspaces are present or all characters are equal.
        return sEnd==-1 && tEnd==-1;
    }
}

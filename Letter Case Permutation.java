class Solution {
    List<String> resultList = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        findPermutationsBacktrack(s.toCharArray(),0); //helper method.
        return resultList;
    }

    public void findPermutationsBacktrack(char[] s, int start){
        if(start==s.length){ //once we have explored all the possible permutations.
            resultList.add(new String(s));
            return;
        }else{
            if(Character.isLetter(s[start])){ //if it's a letter, then we should explore both possibilities.. i.e., branching (one with capital, one with small.)
                s[start]=Character.toUpperCase(s[start]);
                findPermutationsBacktrack(s,start+1);
                s[start]=Character.toLowerCase(s[start]);
                findPermutationsBacktrack(s,start+1);
            }else{
                findPermutationsBacktrack(s,start+1); //if it's a digit, simple go for next one.
            }
        }
    }

}

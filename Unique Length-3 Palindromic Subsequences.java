class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] firstIndex = new int[26];
        int[] lastIndex = new int[26];
        Arrays.fill(firstIndex, Integer.MAX_VALUE);

        for(int i=0;i<s.length();i++){
            if(firstIndex[s.charAt(i)-'a']==Integer.MAX_VALUE){
                firstIndex[s.charAt(i)-'a']=i;
            }
            lastIndex[s.charAt(i)-'a']=i;
        }

        int result=0;
        Set<Character> hashSet = new HashSet<>();
        for(char ch='a';ch<='z';ch++){
            int index = ch-'a';
            int firstPosOfCh = firstIndex[index];
            int lastPosOfCh = lastIndex[index];

            hashSet.clear();
            if(lastPosOfCh-firstPosOfCh>1){
                for(int i=firstPosOfCh+1;i<lastPosOfCh;i++){
                    hashSet.add(s.charAt(i));
                }
            }

            result+=hashSet.size();

        }

        return result;
    }
}

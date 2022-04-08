class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;

        char[] strCharArray = s.toCharArray();
        char charInS, charInT;
        HashMap<Character, Character> mapChars = new HashMap<>();
        HashSet<Character> set = new HashSet<>(); //avoid two chars mapping to same character.

        for(int i=0;i<t.length();i++){
            charInS = s.charAt(i);
            charInT = t.charAt(i);

            if(mapChars.containsKey(charInS)){
                if(mapChars.get(charInS)!=charInT)
                    return false;
            }else{

                if(set.contains(charInT)) return false;
                mapChars.put(charInS,charInT);
                set.add(charInT);
            }

        }
        return true;

    }
}

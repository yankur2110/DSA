class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0 || s.equals(t)) return true;
        if(s.length()>t.length()) return false;

        int j=0;

        for(int i=0;i<t.length();i++){
            char charInT = t.charAt(i);

            char ch = s.charAt(j);
            if(ch==charInT){
                j++;
            }
            if(j>=s.length()) return true;
        }

        return j>=s.length()?true: false;
    }
}

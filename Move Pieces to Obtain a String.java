class Solution {
    public boolean canChange(String s, String t) {
        if(s.length()!=t.length()) return false;

        //pointers that will point to corresponding 'L'/'R' of s and t.
        //using the fact that we are sure that order or 'L'/'R' of s and t must be the same.
        int s_ptr=0, t_ptr=0;

        while(s_ptr<s.length() || t_ptr<t.length()){
            while(s_ptr<s.length() && s.charAt(s_ptr)=='_') s_ptr++;
            while(t_ptr<t.length() && t.charAt(t_ptr)=='_') t_ptr++;

            //let's check if both are in bound or not.
            if(s_ptr>=s.length() || t_ptr>=t.length()){
                return (s_ptr==s.length() && t_ptr==t.length()); //if both are going out of bound then only it's valid otherwise one has extra 'L' or 'R' present on it's right.
            }

            char s_char = s.charAt(s_ptr);
            char t_char = t.charAt(t_ptr);
            if(s_char!=t_char) return false;

            //making sure that 'L' of s is appearing on or after corresponding 'L' of t.
            //likewise 'R' of s is appearing on or before corresponding 'R' of t.
            if((s_char=='L' &&  s_ptr<t_ptr) || (s_char=='R' && s_ptr>t_ptr)) return false;

            s_ptr++;
            t_ptr++;
        }

        return true;
    }
}

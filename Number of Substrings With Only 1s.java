class Solution {
    public int numSub(String s) {
        int res=0;
        int mod = (int)1e9+7;

        char prev='a';
        int continuous1TillNow=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                continuous1TillNow = (prev=='1')? continuous1TillNow+1 : 1;
                res = (res+continuous1TillNow)%mod;
            }

            prev=s.charAt(i);
        }

        return res;
    }
}

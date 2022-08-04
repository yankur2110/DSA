class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int low=0, high=removable.length, n=s.length();
        if(p.length()==0) return removable.length;

        char[] charArray = s.toCharArray();

        while(low<=high){
            int mid = low+(high-low)/2;

            for(int i=0;i<mid;i++){
                charArray[removable[i]]='/';
            }

            if(isSubsequence(charArray, p)){
                low=mid+1;
            }else{
                for(int i=0;i<mid;i++){
                    charArray[removable[i]]=s.charAt(removable[i]);
                }
                high=mid-1;
            }

        }

        return high;
    }

    public boolean isSubsequence(char[] charArray, String p){
        int j=0;
        for(int i=0;i<charArray.length;i++){
            if(charArray[i]!='/' && p.charAt(j)==charArray[i]){
                j++;
                if(j==p.length()) return true;
            }

        }
        return false;
    }
}

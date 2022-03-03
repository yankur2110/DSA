class Solution {
    String longestDuplicateSubstring = "";

    public String longestDupSubstring(String s) {
        int low=0,high=s.length()-1;

        //binary search to guess the maxLength of Duplicate String Efficiently.
        while(low<=high){
            int mid = (low+high)/2;
            if(checkIfDuplicateStringOfLengthExists(s, mid)){
                low = mid+1;
            }else{
                high=mid-1;
            }
        }
        return longestDuplicateSubstring;
    }

    private boolean checkIfDuplicateStringOfLengthExists(String s, int len){
        int rollingHash=0;
        HashMap<Integer, List<Integer>> hashToIndexMap = new HashMap<>();
        for(int i=0;i<s.length()-len;i++){
            String windowString = s.substring(i,len+i+1);
            int currentWindowStringHash = findHash(s,i,len+i,rollingHash, len);
            // System.out.println("hash for string "+windowString+" is: "+currentWindowStringHash);

            //if hashcode exists already, then check if windowString is duplicate with existing string.
            if(hashToIndexMap.containsKey(currentWindowStringHash)){
                for(int j : hashToIndexMap.get(currentWindowStringHash)){
                    if(compare(s,i,j,len) && len>longestDuplicateSubstring.length()){
                        longestDuplicateSubstring=windowString;
                        return true;
                    }
                }
            }

            List<Integer> list = null; //add the current hash to map.
            if(hashToIndexMap.containsKey(currentWindowStringHash)){
                list = hashToIndexMap.get(currentWindowStringHash);
            }else{
                list = new ArrayList<>();
                hashToIndexMap.put(currentWindowStringHash,list);
            }
            list.add(i);

        }
        return false;
    }

    private int findHash(String str, int start, int end, int prevHash, int len){
        if(prevHash==0){
            int maxIndex = end-start;
            int hash=0;
            for(int i=0;i<=maxIndex;i++){
                hash+=((str.charAt(end)-'a'+1)*26^i)%5381; //basically implementing the formula: (a+b)%M = ((a%M)+(b%M))%M.
            }
            return hash%5381; //to prevent overflow.
        }else{ //if previously hash is calculated, apply rolling hash.
            return ((prevHash-(str.charAt(start-1)-'a'+1)*26^(len-1))*26)%5381 + (str.charAt(end)-'a'+1);
        }

    }

    private boolean compare(String S, int i, int j, int len) {
        for (int count = 0; count < len; count++) {
            if (S.charAt(i++) != S.charAt(j++)) return false ;
        }
        return true ;
    }
}

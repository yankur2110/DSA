class Solution {
    public int minimumBuckets(String street) {
        char[] charArray = street.toCharArray();
        int count=0;
        for(int i=0;i<street.length();i++){
            char ch = charArray[i];

            if(ch=='H'){
                if((i-1)>=0 && charArray[i-1]=='B'){ //if already present bucket can be used.
                    continue;
                }else if((i+1)<street.length() && charArray[i+1]=='.'){ //if bucket wasn't there on (i-1) or a house is there on (i-1) && empty space is there at (i+1) -> go greedy.
                    charArray[i+1]='B';
                    count++;
                }else if((i-1)>=0 && charArray[i-1]=='.'){ //in case empty space is not there at (i+1). In that case we have to place the bucket at adjacent left empty space.
                    charArray[i-1]='B';
                    count++;
                }else{ //in case bucket can't be placed.
                    return -1;
                }
            }
        }

        return count;
    }
}

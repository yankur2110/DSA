class Solution {
    public int nextGreaterElement(int n) {
        char[] charArray = (n+"").toCharArray();
        int len = charArray.length;
        int i=0;
        for( i=len-1;i>0;i--){
            if(charArray[i-1]<charArray[i]){
                break;
            }
        }

        if(i==0) return -1;

        int x = charArray[i-1], justGreaterThanXInTheRightIndex = i; //(i-1)th index is the smallest. For now, justGreaterThanXInTheRightIndex is i.

        for(int j=i+1;j<len;j++){ //check the smallest greater than x on right side.
            if(charArray[j]>x && charArray[justGreaterThanXInTheRightIndex]>=charArray[j]){
                justGreaterThanXInTheRightIndex=j;
            }
        }

        //swap the number with justGreater from right.
        char ch = charArray[i-1];
        charArray[i-1]=charArray[justGreaterThanXInTheRightIndex];
        charArray[justGreaterThanXInTheRightIndex]=ch;

        //swap the elements from right of (i-1)th elements.
        Arrays.sort(charArray, i, len);

        long val = Long.parseLong(new String(charArray)); //because number might go overflow from INT values range as per condition.
        return (val <= Integer.MAX_VALUE) ? (int) val : -1;
    }
}

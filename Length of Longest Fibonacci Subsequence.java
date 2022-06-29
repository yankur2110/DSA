class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        //add all the elements of arr to a hashset so that it's easy to check whether an element is present in or not.
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i: arr) hashSet.add(i);

        //intialize with a random value.
        int maxLength=2;
        
        //simply check all the possible subsequences.
        for(int i=0;i<arr.length-2;i++)
            for(int j=i+1;j<arr.length-1;j++){
                int a=arr[i], b=arr[j], len=2;
                while(hashSet.contains(a+b)){ //if a fibonacci-like sequence found, check for it's extension.
                    b=a+b;
                    a=b-a;
                    len++;
                }
                maxLength=Math.max(maxLength, len); //update the maxLength of fibonacci-like subsequence.
            }

        //if no such subsequence found, return 0.. else return maxLength.
        return (maxLength==2)?0:maxLength;
    }
}

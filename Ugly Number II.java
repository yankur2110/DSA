class Solution {
    public int nthUglyNumber(int n) {

        int[] uglyArray = new int[n];
        uglyArray[0]=1;

        int twoMultiplePtr=0,threeMultiplePtr=0,fiveMultiplePtr=0;
        int possVal1=0, possVal2=0, possVal3=0;

        //start populating the uglyArray.
        for(int i=1;i<n;i++){

            //compare with the lowest values possibilities.
            possVal1 = 2*uglyArray[twoMultiplePtr];
            possVal2 = 3*uglyArray[threeMultiplePtr];
            possVal3 = 5*uglyArray[fiveMultiplePtr];

            uglyArray[i]=Math.min(Math.min(possVal1, possVal2), possVal3);

            //note that we are comparing with all three so that if two multiplications are giving same result, both pointer should be incremented. For e.g., 2 * (3), 3 * (2).
            if(uglyArray[i]==possVal1) twoMultiplePtr++;
            if(uglyArray[i]==possVal2) threeMultiplePtr++;
            if(uglyArray[i]==possVal3) fiveMultiplePtr++;


        }

        return uglyArray[n-1];

    }
}

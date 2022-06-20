class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        //take array of 7 size so that we can count the number of times 1 -> 6 has occurred in top and bottom arrays. We will store the count at respective index.
        //same are counted separately, because those rotations are not at all useful for us.
        int[] countA = new int[7], countB = new int[7], same = new int[7];
        int n = A.length;

        //iterate through the given arrays and count the number of times 1-> 6 has occurred in top/bottom respectively.
        for (int i = 0; i < n; ++i) {
            countA[A[i]]++;
            countB[B[i]]++;
            if (A[i] == B[i])
                same[A[i]]++;
        }


        for (int i  = 1; i < 7; ++i)
            if (countA[i] + countB[i] - same[i] == n) //if at all same number 'i' at top/bottom is possible throuhout.
                return n - Math.max(countA[i], countB[i]); //to check 'i' at top, rotations reauired are n-countA[i].. similarly for bottom, rotations required are n-countB[i]. Minimum of these should be useful for us.
        return -1;
    }
}

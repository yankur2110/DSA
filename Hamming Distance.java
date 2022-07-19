class Solution {
    public int hammingDistance(int x, int y) {
        int diff = x^y;
        int num=1, count=0;

        for(int i=0;i<31;i++){
            num=1<<i;

            if((diff&num) == num){
                count++;
            }
        }

        return count;
    }
}

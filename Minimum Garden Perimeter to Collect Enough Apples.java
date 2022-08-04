class Solution {
    public long minimumPerimeter(long neededApples) {
        long low=1, high=100000;
        while(low<high){
            long m=(low+high)/2;

            if(m * m * m * 4 + m * m * 6 + m * 2 < neededApples){
                low=m+1;
            }else{
                high=m;
            }

        }

        return 8*low;
    }

}

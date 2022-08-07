class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long currSum=mass;

        for(int i:asteroids){
            if(currSum>=i){
                currSum+=i;
            }else{
                return false;
            }
        }
        return true;
    }
}

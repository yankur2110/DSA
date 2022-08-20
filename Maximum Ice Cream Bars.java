class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int count=0;
        Arrays.sort(costs);
        for(int i:costs){
            if(coins>0){
                coins-=i;
                if(coins<0){
                    break;
                }
                count++;
            }else{
                break;
            }
        }

        return count;
    }
}

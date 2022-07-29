class Solution {
    public int longestWPI(int[] hours) {
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int score=0;
        int res=0;

        for(int i=0;i<hours.length;i++){
            score+=(hours[i]>8)?1:-1;
            if(score>0){
                res=i+1; //because score denotes the sum from 0th index till i.
            }else{
                prefixSumMap.putIfAbsent(score, i); //we want to store the min index where that sum occured hence using putIfAbsent.
                if(prefixSumMap.containsKey(score-1)){
                    res = Math.max(res, i-prefixSumMap.get(score-1));
                }
            }

        }
        return res;
    }
}

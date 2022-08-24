class Solution {
    public int minimumCardPickup(int[] cards) {
        int globalMin=Integer.MAX_VALUE;
        HashMap<Integer, Pair<Integer, Integer>> minDiffOfKeyMap = new HashMap<>(); // val, {lastIndex, minDiff};

        for(int i=0;i<cards.length;i++){
            int val=cards[i];

            if(minDiffOfKeyMap.containsKey(val)){
                Pair<Integer,Integer> lastValEntryDetailsPair = minDiffOfKeyMap.get(val);
                int newDiff = Math.min(lastValEntryDetailsPair.getValue(), Math.abs(lastValEntryDetailsPair.getKey()-i));

                globalMin = Math.min(globalMin, newDiff);

                minDiffOfKeyMap.put(val, new Pair<>(i,newDiff));

            }else{
                minDiffOfKeyMap.put(val, new Pair<>(i,Integer.MAX_VALUE));
            }
        }



        return globalMin==Integer.MAX_VALUE? -1: globalMin+1;

    }
}

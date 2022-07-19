class Solution {
    public int heightChecker(int[] heights) {
        int[] heightFreqArray = new int[101];
        for(int height:heights){
            heightFreqArray[height]++;
        }

        int index=0;
        int count=0;
        for(int height : heights){
            while(heightFreqArray[index]==0){
                index++;
            }

            if(height !=index){
                count++;
            }
            heightFreqArray[index]--;
        }
        return count;
    }
}

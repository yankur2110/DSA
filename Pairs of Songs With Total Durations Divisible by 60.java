class Solution {
    public int numPairsDivisibleBy60(int[] time) {

        int resultCount = 0; //count of pair songs.
        int[] remainderCountTillNow = new int[60]; //songDuration%60... count.

        for(int t: time){
            //logic here is to keep on checking, how many already existing song does make pair with current song. *This ensures that no repeated pair get’s counted.*

            //straightforward: 60 - (t%60)... but we are storing t%60 in array storing. Hence we should do %60 again. i.e., (60-(t%60))%60.
            resultCount += remainderCountTillNow[(60 - (t % 60)) % 60];

            remainderCountTillNow[t%60]++; //add the song to existing song.
        }

        return resultCount;
    }
}

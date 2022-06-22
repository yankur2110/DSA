class Solution {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4) return false;
        int sum=0;
        for(int i : matchsticks) sum+=i;

        //check 1: if integer length side is not possible.
        if(sum%4!=0) return false;

        int reqdLength = sum/4;

        Arrays.sort(matchsticks); //sort the array.

        //start placing the bigger matchsticks first.
        return backtrack(matchsticks.length-1,matchsticks,reqdLength, new int[4]);

    }

    public boolean backtrack (int matchStickIndex, int[] arr, int reqdLength, int[] sidesOfSquare ){
        if(matchStickIndex == -1){ //if already all matchsticks are used. It's decision time.
            if(sidesOfSquare[0]==reqdLength && sidesOfSquare[1]==reqdLength && sidesOfSquare[2]==reqdLength )
                return true;
            return false;
        }

        for(int i=0;i<4;i++){ //add the matchStick to each side.
            if(sidesOfSquare[i]+arr[matchStickIndex]>reqdLength) continue; //if that sides become greater than the reqdLength then it's meaningless to consider this path.

            sidesOfSquare[i]+=arr[matchStickIndex];
            if(backtrack(matchStickIndex-1, arr, reqdLength, sidesOfSquare)) return true;
            sidesOfSquare[i]-=arr[matchStickIndex];
        }

        return false;
    }

}

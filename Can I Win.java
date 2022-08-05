class Solution {
    HashMap<Integer, Boolean> memo = new HashMap<>();
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        //visited is used to keep track of elements which are picked are either of the players. So, that the other no player picks it again.
        boolean[] visited = new boolean[maxChoosableInteger+1];

        //if desiredTotal is less than the maxChoosable, first player can directly choose that number.
        if (desiredTotal <= maxChoosableInteger)
            return true;

        //desired total should be less than sum of all elements.
        //it just for a false check.
        if (((1 + maxChoosableInteger) / 2 * maxChoosableInteger) < desiredTotal) {
            return false;
        }

        //then we start checking if firstPlayer can win with those options(visited) in hand.
        return ifICanWin(maxChoosableInteger, visited, desiredTotal);
    }

    public boolean ifICanWin(int maxChoosableInteger, boolean[] visited, int desiredTotal){

        //this is the break condition i.e., when other player has already chosen the big number.
        if(desiredTotal<=0)
            return false;

        //this is the important part here. We are creating the int key from boolean visited array i.e., corresponding bit of visited array is represented by 1 for true and 0 for false.
        //note that converting this to string using Array.toString() gives TLE hence can't use that.
        int visitedAsKeyForMemo = format(visited);

        //whether a person can win or not completely depends on visited array hence it's the key.
        if (memo.containsKey(visitedAsKeyForMemo)) {
            return memo.get(visitedAsKeyForMemo);
        }

        //explore possibility of current player picking each integer.
        for(int i=1;i<=maxChoosableInteger;i++){
            if(visited[i]) continue; //if already picked by any player skip.

            visited[i]=true;

            //check if other person can win with left options. If not, put true for this visited array in hashmap and return true from here only.
            if(!ifICanWin(maxChoosableInteger, visited, desiredTotal-i)){
                visited[i]=false;
                memo.put(visitedAsKeyForMemo,true);
                return true;
            }

            visited[i]=false;
        }

        //if he can't win, put false against this key and return false.
        memo.put(visitedAsKeyForMemo,false);
        return false;
    }

    //build the int key from boolean array.
    public int format(boolean[] used){
        int num = 0;
        for(boolean b: used){
            num <<= 1;
            if(b) num |= 1;
        }
        return num;
    }
}

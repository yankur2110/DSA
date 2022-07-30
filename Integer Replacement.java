class Solution {
    HashMap<Integer, Integer> memoMap = new HashMap<>(); //for memoization.

    public int integerReplacement(int n) {

        //break conditions for recursive functions.
        memoMap.put(0,1);
        memoMap.put(1,0);
        memoMap.put(Integer.MAX_VALUE,32);

        //call the helper method.
        return helper(n);
    }

    public int helper(int n){
        if(memoMap.containsKey(n)){
            return memoMap.get(n);
        }

        if(n%2==0){
            memoMap.put(n, 1+integerReplacement(n/2));
        }else{
            memoMap.put(n, 1+Math.min(integerReplacement(n-1), integerReplacement(n+1)));
        }

        return memoMap.get(n);
    }
}

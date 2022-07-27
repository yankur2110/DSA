class Solution {
    public List<Integer> pathInZigZagTree(int n) {
        List<Integer> resultList = new ArrayList<>();
        int level=1; //level on which the current number lies.
        while(n>=Math.pow(2,level)){
            level++;
        }

        int levelMax, levelMin;

        while(level!=0){
            resultList.add(n); //add the number to the resultList.
            levelMax= (int)Math.pow(2,level)-1; //max number of the level on which 'n' lies.
            levelMin = (int)Math.pow(2,level-1); //min number of the level on which 'n' lies.
            n = levelMax+levelMin-n; //find the complement of n... i.e., mirror element. For e.g., for 9 it would 14 etc.

            n/=2; //find the parent of number.
            level--; //go to parent level.
        }

        Collections.reverse(resultList); //reverse the list.
        return resultList;
    }
}

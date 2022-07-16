class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prevList = new ArrayList<>();
        if(rowIndex==0){
            prevList.add(1);
            return prevList;
        }
        List<Integer> resultList = null;

        while(rowIndex-->0){
            resultList = new ArrayList<>();
            resultList.add(1);

            //main part.
            int i=0;
            while((i+1)<prevList.size()){
                resultList.add(prevList.get(i++) + prevList.get(i));
            }
            //main partends here.

            resultList.add(1);
            prevList=resultList;

        }


        return resultList;
    }
}

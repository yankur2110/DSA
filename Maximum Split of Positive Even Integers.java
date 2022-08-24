class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> resultList = new ArrayList<>();
        if(finalSum%2!=0)
            return resultList;

        long currIncludedNum=0;
        long remainingSum=finalSum;

        while(remainingSum>0){

            currIncludedNum+=2;

            if(remainingSum-currIncludedNum>currIncludedNum){
                resultList.add(currIncludedNum);
                remainingSum-=currIncludedNum;
            }else{
                resultList.add(remainingSum);
                break;
            }
        }

        return resultList;
    }
}

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        List<Boolean> resultList = new ArrayList<>();

        for(int i=0;i<l.length;i++){
            int start = l[i], end = r[i];

            int[] temp = Arrays.copyOfRange(nums, start, end+1);
            boolean resultIncluded=false;
            Arrays.sort(temp);
            if(temp.length<=2){
                resultList.add(true);
                resultIncluded=true;
                continue;
            }

            for(int j=2;j<temp.length;j++){
                if(temp[j]-temp[j-1]!=temp[j-1]-temp[j-2]){
                    resultList.add(false);
                    resultIncluded=true;
                    break;
                }
            }
            if(!resultIncluded)
                resultList.add(true);
        }

        return resultList;
    }
}

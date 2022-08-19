class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        int max = 0, count=0;

        for(int i=nums.size()-1;i>=0;i--){ //starting from last row to maintain order.
            //note: if we will start from row 0 till maxRow, it will print in diaogal elements in reverse order.
            for(int j=0;j<nums.get(i).size();j++){
                map.putIfAbsent(i+j, new ArrayList<>());
                map.get(i+j).add(nums.get(i).get(j));
                max= Math.max(max, i+j);

                count++;
            }
        }

        int[] resultArray = new int[count];
        int k=0;

        for(int i=0;i<=max;i++){
            List<Integer> diagonalElements = map.get(i);

            for(int elem : diagonalElements){
                resultArray[k++]=elem;
            }
        }

        return resultArray;
    }
}

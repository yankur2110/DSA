class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int totalRows = triangle.size();

        for(int i=totalRows-2;i>=0;i--){ //start from second last row, as last row would already contains the minPathSum since only 1 element is present in their path.
            List<Integer> currentRowList = triangle.get(i);
            List<Integer> nextRowList = triangle.get(i+1); //since we need minPathSum of j, j+1 index elements (of next row).

            for(int j=0;j<currentRowList.size();j++){
                int pathSumIncludingCurrentElement = currentRowList.get(j) +
                    Math.min(nextRowList.get(j), nextRowList.get(j+1));
                currentRowList.set(j, pathSumIncludingCurrentElement); //update the given list, as we won't need these elements again.
            }
        }

        return triangle.get(0).get(0); //in the end, first element would have the result.

    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int col = matrix[0].length;
        int row = matrix.length;
        int start = 0, end = (row*col)-1, mid=0, midElement=0;


        while(start<=end){
            mid=(start+end)/2;
            midElement=matrix[mid/col][mid%col];

            if(target==midElement)
                return true;
            if(target>midElement)
                start=mid+1;
            else
                end=mid-1;

        }
        return false;
    }
}

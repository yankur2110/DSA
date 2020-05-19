class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> result = new ArrayList<Integer>();
        if(matrix.length==0)
            return result;
        int row_begin= 0;
        int col_begin=0;
        int col_last=matrix[0].length-1;
        int row_last=matrix.length-1;
        
        while(row_begin<=row_last && col_begin<=col_last){
            for(int i=col_begin;i<=col_last;i++){
                result.add(matrix[row_begin][i]);
            }
            row_begin++;

            for(int i=row_begin;i<=row_last;i++){
                result.add(matrix[i][col_last]);
            }
            col_last--;

            if(row_begin<=row_last) //Important
            for(int i=col_last; i>=col_begin;i--){
                result.add(matrix[row_last][i]);
            }
            row_last--;

            if(col_begin<=col_last) //Important
            for(int i=row_last;i>=row_begin;i--){
                result.add(matrix[i][col_begin]);
            }
            col_begin++;
        }
        
        return result;
    }
}
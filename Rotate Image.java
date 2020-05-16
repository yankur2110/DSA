class Solution {
    public void rotate(int[][] matrix) {
        //basically the idea here is to first get the transpose of the matrix
        //flip the matrix
        
        int length = matrix[0].length;
        
        for(int i=0;i<length;i++){
            for(int j=i;j<length;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
                
            }
            
        }
        
        
        int actualLastIndex = matrix[0].length-1;
        
         for(int i=0;i<length;i++){
            for(int j=0;j<length/2;j++){
                int temp=matrix[i][actualLastIndex-j];
                matrix[i][actualLastIndex-j]=matrix[i][j];
                matrix[i][j]=temp;
                
            }
        }
    }
}
class Solution {
    int globalMax=Integer.MIN_VALUE;
    public int longestIncreasingPath(int[][] matrix) {
        int[][] resultArray = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[0].length;j++)
                resultArray[i][j]=Integer.MIN_VALUE;
                
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[0].length;j++)
                 helper(matrix,resultArray,i,j);
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++)
                System.out.print(resultArray[i][j]+" ");
            System.out.println(" ");
            
        }
                 
        return globalMax;
    }

    public int helper(int[][] matrix, int[][] result, int i, int j){
        
        if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length)
            return 0;
        
        if(result[i][j]!=Integer.MIN_VALUE)
            return result[i][j];
        
        int leftValue = Integer.MIN_VALUE; int rightValue = Integer.MIN_VALUE;
        int aboveValue = Integer.MIN_VALUE; int belowValue = Integer.MIN_VALUE;
        
        int currentValue = matrix[i][j];
        int resultTemp = 1;
        
        if(j-1>=0 && matrix[i][j-1]>currentValue){
            leftValue = helper(matrix,result,i,j-1);
            resultTemp = Math.max(resultTemp,1+leftValue);
        }
            
        if(j+1<matrix[0].length && matrix[i][j+1]>currentValue){
            rightValue = helper(matrix,result,i,j+1);   
            resultTemp = Math.max(resultTemp,1+rightValue);
        }
           
        if(i-1>=0 && matrix[i-1][j]>currentValue){
            aboveValue = helper(matrix,result,i-1,j);
            resultTemp = Math.max(resultTemp,1+aboveValue);
            
        }
            
        if(i+1<matrix.length && matrix[i+1][j]>currentValue){
            belowValue = helper(matrix,result,i+1,j);
            resultTemp = Math.max(resultTemp,1+belowValue);
        }
        
        result[i][j] = resultTemp;
        globalMax=Math.max(globalMax,result[i][j]);
        return result[i][j];
        
        
    }
}

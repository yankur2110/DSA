class Solution {
    public void setZeroes(int[][] matrix) {
       
        
	boolean makeFirstRowZero =false;
    boolean makeFirstColZero = false;
    
    for(int i=0;i<matrix.length;i++){
        for(int j=0;j<matrix[0].length;j++){
            if(matrix[i][j]==0){
                matrix[i][0]=-9991;
                matrix[0][j]=-9991; //if j index is zero of an element with value 0 that means 0th column needs to be zero.
                if(j==0){
                	makeFirstColZero=true;
                }
                if(i==0){
                	makeFirstRowZero=true;
                }
            }
        }
    }

     
    for(int i=0;i<matrix.length;i++){
        if(matrix[i][0]==-9991){
        	
        	 if(i==0 && makeFirstRowZero==false)
        		 continue;
        	
            for(int j=0;j<matrix[0].length;j++){
            	if(!(i==0 && matrix[i][j]==-9991))
                matrix[i][j]=0;
            	if(i==0 && j==0 && matrix[i][j]==-9991 && makeFirstColZero==false){
            		matrix[i][j]=0;
            	}
            }
        }
    }

    
    for(int j=0;j<matrix[0].length;j++){
        if(matrix[0][j]==-9991){
        	
        	if(j==0 && makeFirstColZero==false)
       		 continue;
        	
            for(int i=0;i<matrix.length;i++){
                matrix[i][j]=0;
            }
        }
    }
    
    }
}
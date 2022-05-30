class Solution {
    int maxRow=0, maxCol=0, i=0; //global variables so that we don't need them to pass in each recursive call.
    int[] resultArray = null;

    public int[] findDiagonalOrder(int[][] matrix) {
        maxRow = matrix.length; maxCol = matrix[0].length;
        resultArray = new int[maxRow*maxCol];
        traverse(0,0,true, matrix); //start with upward direction.
        return resultArray; //return result.
    }

    //traverse upward or downward based on boolean variable.
    public void traverse(int row, int col, boolean upwardDirection, int[][] matrix){

        int nextRow=row, nextCol=col; //these variable are used to store the last valid row, col so that next direction can be started.

        //break condition.
        if(!boundaryCheck(row, col)){
            return;
        }

        if(upwardDirection){ //if it's upward direction.
            while(boundaryCheck(row, col)){
                resultArray[i++]=matrix[row][col];

                nextRow=row;
                nextCol=col;

                row--;   //move diagonally up.
                col++;
            }
            if(nextCol+1<maxCol) //change the direction and shift.
                traverse(nextRow, nextCol+1, !upwardDirection, matrix);
            else
                traverse(nextRow+1, nextCol, !upwardDirection, matrix);
        }else{ //if it's downward direction.
            while(boundaryCheck(row, col)){
                resultArray[i++]=matrix[row][col];

                nextRow=row;
                nextCol=col;

                row++; //move diagonally down.
                col--;

            }

            if(nextRow+1<maxRow) //change the direction and shift.
                traverse(nextRow+1, nextCol, !upwardDirection, matrix);
            else
                traverse(nextRow, nextCol+1, !upwardDirection, matrix);

        }
    }

    public boolean boundaryCheck(int row, int col){ //check whether current row, col index are in range.
        return (row<maxRow && row>=0 && col<maxCol && col>=0) ? true: false;
    }
}

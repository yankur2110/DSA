class Solution {
    int[][] directionsArray = new int[][]{ {2,1},{-2,1},{2,-1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};

    public double knightProbability(int n, int k, int row, int column) {

        double[][] currentProbabilityArray = new double[n][n]; //create a 2-d array, which tells the probability of knight at an index initially.
        currentProbabilityArray[row][column] = 1; //since it's given that the knight would be at (row,column) initially, it's probability would be 1.

        //now lets move K steps. For each move there would be a new probability Array.
        for(int move = 1; move<=k; ++move){

            double[][] nextProbabilityArray = new double[n][n];
            //we need to check the currentDPArray to construct nextProbabilityArray.
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(currentProbabilityArray[i][j]!=0){

                        //check move of knight in all directions.
                        for(int[] direction : directionsArray){
                            //if it's valid, update the probability of new position, by adding current probability to it.
                            if(isValidStep(i+direction[0], j+direction[1], n)){
                               nextProbabilityArray[i+direction[0]][j+direction[1]] += currentProbabilityArray[i][j]/8.0;
                            }
                        }
                    }
                }
            }

           //nextProbabilityArray would be considered for next move, hence update currentProbabilityArray=nextProbabilityArray.
           currentProbabilityArray = nextProbabilityArray;
        }

        double result =0.0;
        //sum up all the probabilities.
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                result+=currentProbabilityArray[i][j];
            }
        }

        return result;
    }

    public boolean isValidStep(int i, int j, int n){
        if(i>=0 && j>=0 && i<n && j<n)
            return true;
        return false;
    }
}

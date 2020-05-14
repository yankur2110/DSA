class Solution {
    public boolean isMatch(String s, String p) {
        int row = s.length();
        int col = p.length();
        
        int[][] resultMatrix = new int[row+1][col+1];
        
        resultMatrix[0][0]=1;
        
        System.out.println(row+" "+col);
        
        for(int i=1;i<=col;i++){
            if(p.charAt(i-1)=='*')
                resultMatrix[0][i]=resultMatrix[0][i-1];
        }
        
        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                
                if(s.charAt(i-1)==p.charAt(j-1)){
                    resultMatrix[i][j]=resultMatrix[i-1][j-1];
                }else if(p.charAt(j-1)=='?'){
                    resultMatrix[i][j]=resultMatrix[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    if(resultMatrix[i][j-1]==1 || resultMatrix[i-1][j-1]==1 || resultMatrix[i-1][j]==1){
                        resultMatrix[i][j]=1;
                    }
                }
                
            }
        }
        
        if(resultMatrix[row][col]==1)
            return true;
        return false;
        
    }
}
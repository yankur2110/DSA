class Solution {
    public boolean isMatch(String s, String p) {
        
        if(p.length()<1){
            if(s.length()<1)
                return true;
            else
                return false;
        }
        
        boolean R[][] = new boolean[s.length()+1][p.length()+1];
        R[0][0] = true;
        
        int i;
		for(i=1;i<=p.length();i++){
            if(p.charAt(i-1)=='*'){
                R[0][i]=R[0][i-2];
            }
        }
        
        for(i=1;i<s.length()+1;i++){
            for(int j = 1;j<p.length()+1;j++){
                if(p.charAt(j-1)==('.')  ||  s.charAt(i-1)==p.charAt(j-1)){
                    R[i][j]=R[i-1][j-1];
                }
                else if(p.charAt(j-1)=='*'){
                    if(R[i][j-2]==true)
                        R[i][j]=true;
                    else if(s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.')
                        R[i][j]=R[i-1][j]; //thinking reqd
                }
                else if(s.charAt(i-1)!=p.charAt(j-1)){
                    R[i][j]=false;
                }
                else 
                    R[i][j]=false;
            }
        }
        
        print2D(R); 
        
        return R[s.length()][p.length()];
    }
    
    public static void print2D(boolean mat[][]) 
    { 
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) 
                System.out.print(mat[i][j] + " "); 
            System.out.print("\n");
        }
    }
}
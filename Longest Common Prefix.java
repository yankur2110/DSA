class Solution {
    public String longestCommonPrefix(String[] strs) {
        int numOfString = strs.length;
        if(numOfString<1)
            return "";
        int i = 0;
        int flag=0;
        StringBuilder resultString = new StringBuilder();
        
        while(flag==0){
        	char sameChar = 0;
            for(int j=0;j<numOfString;j++){
                if(j==0 && strs[j].length()>i )
                 sameChar = strs[j].charAt(i);
                if(strs[j].length()>i){
                    if(j!=0 && !(strs[j].charAt(i)==sameChar)){
                        flag=1;
                    }
    
                }
                else{
                    flag=1;
                }
            }
            i++;
            
            if(flag!=1)
             resultString = resultString.append(sameChar);
             
        }
        
        return resultString.toString();
    }
}
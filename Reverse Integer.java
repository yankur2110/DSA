class Solution {
    public int reverse(int x) {
        Integer sign = 1;
        String resultString = "";
        Integer resultInt;
        
        if(x<0){
            sign = -1;
            x=x*(-1);
        }
        
        if(x<0)
            return 0; /*number is -2147483648 and when it is multiplied by (-1) it exceeds the int range*/
        
        while((x/10)>0){
            resultString = resultString + (x%10); 
            x=x/10;
         
        }
        resultString = resultString + x;
        resultString = resultString.trim();
        try{
        resultInt = sign*Integer.parseInt(resultString);
        }catch(Exception e){
        return 0;}
        
        return resultInt;
        
    }
}
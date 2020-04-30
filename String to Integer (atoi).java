class Solution {
    public int myAtoi(String str) {
        
        if ( str == null || str.length()<=0)
            return 0;
        str=str.trim();
        int sign = 1;
        int i = 0;
        
        if(str.length()<1 || !((str.charAt(0)>=48 &&str.charAt(0)<=57) || (str.charAt(0) == 45) || (str.charAt(0) == 43))){
            //if start char is not a '-' sign or not an int
            return 0;
         }
        
        if(str.charAt(0) == 45 || str.charAt(0)==43 ){
            if(str.charAt(0) == 45)
                 sign = -1;
         str= str.substring(1,str.length());
         if(str.length()<1 || !(str.charAt(0)>=48 &&str.charAt(0)<=57)) /*incase string starting with - but containing no consecutive number is passed.*/
            return 0;
        }
        while(i<str.length() && (str.charAt(i)>=48 && str.charAt(i)<=57)){
            i++;
        }
    
        if (sign==1)
          str = str.substring(0,i);
        else{
          str = "-"+str.substring(0,i);
        }
        
        try{
            return Integer.parseInt(str);
        }catch(Exception e){
            if(sign == -1)
                return Integer.MIN_VALUE;
            return Integer.MAX_VALUE;
        }
    }

}
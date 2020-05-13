class Solution {
    public String countAndSay(int n) {
       
        if(n==1){
            return "1";
        }
        
        return recursiveCountAndSay("1",n);
    }
    
    public String recursiveCountAndSay(String a, int count){
        
        if(count==1)
            return a;
        
        String newString = "";
        
        for(int i=0;i<a.length();i++){
            
            int temp=1;
            
            if( (i<a.length()-1 && a.charAt(i)!=a.charAt(i+1)) || a.length()==1){
                newString=newString+Integer.toString(temp)+a.charAt(i);
            }else if((i<a.length()-1 && a.charAt(i)==a.charAt(i+1))){
                while(i<a.length()-1 && a.charAt(i)==a.charAt(i+1)){
                    temp++;
                    i++;
                }
                newString=newString+Integer.toString(temp)+a.charAt(i);
            }
            else{
                newString=newString+Integer.toString(temp)+a.charAt(i);
            }
        }
        
        count = count-1;
        return recursiveCountAndSay(newString,count);
        
    }
}
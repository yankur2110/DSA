class Solution {
    public int romanToInt(String s) {
    
        String four = "IV";
        String nine ="IX";
        String forty ="XL";
        String ninety = "XC";
        String fourHundred = "CD";
        String nineHundred = "CM";
        
        int sum=0;
        
        if(s.contains(four)){
            sum =sum+4;
            s=s.replace(four,"");
        }
        if(s.contains(nine)){
            sum =sum+9;
            s=s.replace(nine,"");
        }
        if(s.contains(forty)){
            sum =sum+40;
            s=s.replace(forty,"");
        }
        if(s.contains(ninety)){
            sum =sum+90; 
            s=s.replace(ninety,"");
        }
        if(s.contains(fourHundred)){
            sum =sum+400;
            s=s.replace(fourHundred,"");
        }
        if(s.contains(nineHundred)){
            sum =sum+900;
            s=s.replace(nineHundred,"");
        }
        
        System.out.println(sum);
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='I')
                sum = sum+1;
            if(s.charAt(i)=='V')
                sum = sum+5;
            if(s.charAt(i)=='X')
                sum = sum+10;
            if(s.charAt(i)=='L')
                sum = sum+50;
            if(s.charAt(i) == 'C')
                sum = sum+100;
            if(s.charAt(i)== 'D')
                sum = sum + 500;
            if(s.charAt(i)=='M')
                sum = sum + 1000;
        }
        
        return sum;
        
    }
}
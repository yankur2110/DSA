class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        
        if(numerator == -2147483648 && denominator== -1)
            return "2147483648";
        
        if((double)numerator%(double)denominator==0){
            return String.valueOf(numerator/denominator);
        }
        String sign = (numerator < 0 == denominator < 0)?"":"-";

        String ans = sign+ String.valueOf(Math.abs(numerator/denominator)+properFormatDecimalPart((long)numerator, (long)denominator) );
        
        return ans;
        
    }
    
    public String properFormatDecimalPart(long num, long den){
        num= Math.abs(num);
        den = Math.abs(den);
        String fractionResult = ".";
        long remainder = num%den;
        HashMap<Long, Integer> hashmap = new HashMap<>();
        
        //logic is recurring values will start once remainder is the same that we have already encountered.
        while(!hashmap.containsKey(remainder)){
            hashmap.put(remainder,fractionResult.length());
            fractionResult+=(remainder*10)/den;
            remainder=(remainder*10)%den;
        }
        
        fractionResult = fractionResult.substring(0,hashmap.get(remainder))+"("+fractionResult.substring(hashmap.get(remainder),fractionResult.length())+")";
        
        
        return fractionResult.replace("(0)","");
        
    }
}

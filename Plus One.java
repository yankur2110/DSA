class Solution {
    public int[] plusOne(int[] digits) {
        int i,carry=1;
        if(digits[digits.length-1]!=9){
            digits[digits.length-1]=digits[digits.length-1]+1;
            return digits;
        }
        
        for(i=0;i<digits.length;i++){
            if(digits[i]!=9)
                break;
        }
        if(i==digits.length){
            int[] result = new int[i+1];
            result[0]=1;
            return result;
        }else{
            for(i=digits.length-1;i>=0;i--){
                carry=digits[i]+carry;
                if(carry>9){
                    digits[i]=carry%10;
                    carry=carry/10;
                }else{
                    
                    digits[i]=carry;
                    carry=0;
                }
            }
        }
        
        return digits;
    }
}
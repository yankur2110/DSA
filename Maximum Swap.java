class Solution {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int[] lastIndexArray = new int[10];
        for(int i=0;i<digits.length;i++){ //store the lastIndex of each character in string.
            lastIndexArray[digits[i]-'0']=i;
        }

        for(int i=0;i<digits.length;i++){ //iterating from start to see if any element is present after this index whose value is greater than current.
            for(int j=9;j>digits[i]-'0';j--){ //checking only the indexes of values greater than current character.
                if(lastIndexArray[j]>i){
                    //swap the numbers if there exists a greater number after index 'i'.
                    char tmp = digits[i];
                    digits[i] = digits[lastIndexArray[j]];
                    digits[lastIndexArray[j]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }

        return num; //if current number is the maximum, return the same.
    }
}

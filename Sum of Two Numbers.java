class Solution {
    public int getSum(int a, int b) {
        
        while(b!=0){
            int c=a; //since value of 'a' is changing in step 1, we can't use it in step2, therefore we are storing it sepeartely in a variable 'c' for later use.
            a=a^b; //Step 1: (XOR i.e., actual sum)
            b=c&b; //Step 2: (AND i.e., the carries)
            b=b<<1; //Step 3: (shifting it to one position left to add this to XOR in next step.)
        }
        
        return a;
    }
}

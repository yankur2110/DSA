class Solution {
    public int trailingZeroes(int n) {
        /*  Logic:
        1. factorise the N.
        2. count how many of them can give product 10 i.e., (2*5).. which furthermore break down into how many times 5 occurs, because there always be plenty of 2's with whom can multiply.
        3. numbers of 5 in that factorical like below can be calculated by N/5, then there one more 5 when the factor contains 25 (5*5), to get that we do N/5^2 + likewise (more one five can be in 125.. 5*5*5.. till now 5 and all 25's are done), N/5^3.
        4. continue likewise.
        
        For e.g., 10!
        1*2*3*(2*2)*5*(2*3)*7*(2*2*2)*(3*3)*(2*5)
        */
        
        int count=0;
        int fiveMultiple=5;
        
        while(n/fiveMultiple>0){
            count+= n/fiveMultiple;
            fiveMultiple*=5;
        }
        return count;
    }
}
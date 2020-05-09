class Solution {
    public int divide(int dividend, int divisor) {
        
        /* https://www.youtube.com/watch?v=htX69j1jf5U&t=483s.. 
        idea behind is keep checking the multiples in divisor*(2^i)..and when divisor*(2^i) exceeds
        the dividend,add 2*(i-1) to result & check dividend-2*(i-1) whith the same procedure.

Note: same can be achieved with other powers like 3*i as well, but since we have bitwise operators only, we will use the above method only. */
        
        
         if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        int res = 0;
        while(a - b >= 0){
            
            int x = 0;
            while( a - (b << 1 << x) >= 0){
                x++;
            }
            res += 1 << x;
            a -= b << x;
        }
        return (dividend >= 0) == (divisor >= 0) ? res :-res;
    }
      
}
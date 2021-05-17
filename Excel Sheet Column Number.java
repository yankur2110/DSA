class Solution {
    public int titleToNumber(String columnTitle) {
        
        int len = columnTitle.length();
        int sum = 0, pos = 0;
        
        for(int i=len-1; i>=0;i--)
            sum+=((int)columnTitle.charAt(i)-64)*Math.pow(26,pos++);
            
        return sum;
    }
}

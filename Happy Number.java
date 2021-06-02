class Solution {
    public boolean isHappy(int n) {
        
        Set<Integer> hashSet = new HashSet<>();
        
        while(hashSet.add(n) ){
            n=getSquareOfDigits(n);
        }
       
        return  n==1?true:false;
    }
    
    public int getSquareOfDigits(int num){
        int result=0;
        while(num!=0){
            result+=(num%10)*(num%10);
            num=num/10;
        }
        return result;
    }
}

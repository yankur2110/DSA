class Solution {
    public int mySqrt(int x) {
	        
	        if(x==0)
	            return 0;
	        
	    long start =1;
	    long mid =0;
	    long midSquare = 0;
	    long end =x;
	    int ans = 1;
	        
	        while(start<=end){
	            
	            mid=(start+end)/2;
	            midSquare=mid*mid;
	            
	            
	            if(mid*mid==x )
	                return (int)mid;
	            
	            else if(mid*mid>x){
	                end=mid-1;
	            }else{
	                start=mid+1;
	                ans =(int)mid;
	            }
	            
	            }
	        return ans;
	    }
	
}
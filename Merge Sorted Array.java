class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        
        int index =nums1.length-1;
        m=m-1;n=n-1;
        
        while(m>=0&&n>=0){
            if(nums1[m] >= nums2[n]){
                nums1[index]=nums1[m];
                index--;
                m--;
            }else if (nums2[n]>nums1[m]){
                nums1[index]=nums2[n];
                index--;
                n--;
            }
        }
        
        if(m<0){
            int i=0;
            while(n>=0){
                nums1[i]=nums2[i];
                i++;
                n--;
                
            }
        }
        
    }
}
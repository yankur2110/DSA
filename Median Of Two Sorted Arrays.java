class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result;
        int len1=nums1.length;
        int len2=nums2.length;
        int len = len1 + len2;
        int[] num3 = new int[len];
        
        int a_pointer=0;
        int b_pointer=0;
        int count =0;
        
            while(a_pointer<len1){
                if(b_pointer==len2)
                    break;
                
                if(nums1[a_pointer]<nums2[b_pointer]){
                    num3[count]=nums1[a_pointer];
                    a_pointer++;
                    count++;
                }
                else{
                    num3[count]=nums2[b_pointer];
                    b_pointer++;
                    count++;
                }
            }
        
        if(b_pointer == len2)
        {
            while(a_pointer<len1){
                num3[count]=nums1[a_pointer];
                a_pointer++;
                count++;
            }
        }else{
             while(b_pointer<len2){
                num3[count]=nums2[b_pointer];
                b_pointer++;
                count++;
             }
        }
        System.out.println("sorted array numbers " + Arrays.toString(num3)); 
        
        if(len%2==0){
            result = Double.valueOf(num3[len/2] +num3[(len/2)-1])/2;
        }
        else{
            result = num3[len/2];
        }
        return result;
        
    }
}
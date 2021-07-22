class Solution {
    
    //Class to store the values and their ORIGINAL INDEXES.
    class ValueAndIndex{
        int value;
        int index;
        ValueAndIndex(int value, int index){
            this.value = value;
            this.index = index;
        }
    }
    
    //list to store the final LIST.
    List<Integer> list;
    public List<Integer> countSmaller(int[] nums) {
        
        ValueAndIndex[] VIArray = new ValueAndIndex[nums.length];
        //intializing list with 0 values to avoid outOfBound Exception while inserting values in it.
        list = new ArrayList<>(Collections.nCopies(nums.length, 0));
        
        //modifying given array, so that we also have indexes while we are sorting.
        for(int i=0;i<nums.length;i++)
            VIArray[i]=new ValueAndIndex(nums[i],i);

        //NO CHANGE: simple merge sort.
         mergeSort(VIArray, 0, VIArray.length-1);
        
        return list;
        
    }
    
    //NO CHANGE HERE, simple MERGE SORT.
    public void mergeSort(ValueAndIndex[] VIArray, int start, int end){
        if(start>=end)
            return;
        int middle = (start+end)/2;
        mergeSort(VIArray, start, middle);
        mergeSort(VIArray, middle+1, end);
        merge(VIArray, start, middle, end);
    }
    
    //1 LINE CHANGE, REST ALL IS SAME as there in simple MERGE SORT.
    public void merge(ValueAndIndex[] VIArray, int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;
        ValueAndIndex L[] = new ValueAndIndex[n1];
        ValueAndIndex R[] = new ValueAndIndex[n2];
 
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = VIArray[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = VIArray[m + 1 + j];
 
        /* Merge the temp arrays */
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].value > R[j].value) {
                
                /*THIS IS THE ONLY LINE WE NEED TO UNDERSTAND.
                Explanation: 
                Suppose original array was 2,7,1,6,8.
                Let's consider the last merge iteration where we have two half arr1=[7,2] and arr2=[8,6,1]. 
                
                n2=3, j=1 (when we are trying to merge and comparing 7 of arr1 with 6 of arr2.)
                -below line means for 7 of arr1: we will have (n2-j) i.e., 2 elements less than 7. This number 
                we will add to the the already present value in result array at index (1 in this case because 2 is less than 7) where 7 was present initially (i.e., index 2).
                */
                  list.set(L[i].index, list.get(L[i].index)+(n2-j));
                
                VIArray[k] = L[i];
                i++;
            }
            else {
                VIArray[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            VIArray[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            VIArray[k] = R[j];
            j++;
            k++;
        }
            
     }
}

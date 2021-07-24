class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        int smallerArray=(nums1.length<nums2.length)?1:2;
        
        //below line ensures that nums1 is always pointing to smaller array.
        if(smallerArray==2){
            int[] temp;
            temp=nums1;
            nums1=nums2;
            nums2=temp;
        }
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        List<Integer> resultList = new ArrayList<>();
        
        for(int i: nums1)
            map.put(i, map.getOrDefault(i,0)+1);
        
        for(int i: nums2){
            if(map.get(i)!=null && map.get(i)>0){
                map.put(i, map.get(i)-1);
                resultList.add(i);
            }
        }
        
        return resultList.stream().mapToInt(Integer::intValue).toArray();
        
    }
}
